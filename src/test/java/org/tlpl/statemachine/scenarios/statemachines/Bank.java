package org.tlpl.statemachine.scenarios.statemachines;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.constraints.ElseConstraint;
import org.tlpl.statemachine.constraints.FalseConstraint;
import org.tlpl.statemachine.constraints.TrueConstraint;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.statemachines.StateMachine;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.states.pseudo.Decision;
import org.tlpl.statemachine.states.pseudo.Fork;
import org.tlpl.statemachine.states.pseudo.Join;
import org.tlpl.statemachine.transitions.Transition;

public class Bank extends StateMachine {

    private IState idle;
    private IState verifyingCard;
    private IState verifyingPin;
    private IState cardValidState;
    private IState pinCorrect;
    private IState pinIncorrect;
    private Fork forkVerifyingCardPin;
    private Decision decisionCardValid;
    private Decision decisionPinCorrect;
    private Decision decisionCardStillValid;
    private Join joinCardValidPinCorrect;
    private Join joinCardValidPinIncorrect;

    private final static int MAX_NUM_INCORRECT = 3;
    private int numIncorrect;
    private final boolean cardValid;

    private Atm atm;

    public Bank() {
        super("Bank");
        cardValid = true;
        initStates();
        initTransitions();
    }

    public void setAtm(Atm atm) {
        this.atm = atm;
    }

    @Override
    protected IState getInitialState() {
        return idle;
    }

    private void initStates() {
        idle = new SimpleState("Idle");
        verifyingCard = new SimpleState("verifyingCard");
        verifyingPin = new SimpleState("verifyingPin");
        cardValidState = new SimpleState("cardValid");

        pinCorrect = new SimpleState("pinCorrect");
        pinCorrect.setEntryBehavior(new Behavior() {

            @Override
            public void execute() {
                numIncorrect = 0;
            }
        });

        pinIncorrect = new SimpleState("pinIncorrect");
        forkVerifyingCardPin = new Fork();
        decisionCardValid = new Decision();
        decisionPinCorrect = new Decision();
        decisionCardStillValid = new Decision();
        joinCardValidPinCorrect = new Join();
        joinCardValidPinIncorrect = new Join();
    }

    private void initTransitions() {
        idle.addTransition(new Transition(new CallEvent("verifyPIN"), forkVerifyingCardPin));

        forkVerifyingCardPin.addTransition(new Transition(verifyingCard));
        forkVerifyingCardPin.addTransition(new Transition(verifyingPin));

        verifyingCard.addTransition(new Transition(decisionCardValid));

        Constraint cardValidConstraint = new Constraint() {

            @Override
            public boolean verify() {
                return cardValid;
            }
        };
        decisionCardValid.addTransition(new Transition(cardValidConstraint, cardValidState));

        Constraint elseCardValidConstraint = new ElseConstraint(cardValidConstraint);

        Behavior decisionCardValidElseBehavior = new Behavior() {

            @Override
            public void execute() {
                atm.send(new SignalEvent("abort"));
            }

            @Override
            public String toString() {
                return "atm.abort";
            }
        };

        decisionCardValid.addTransition(new Transition(elseCardValidConstraint,
                decisionCardValidElseBehavior, idle));

        cardValidState.addTransition(new Transition(joinCardValidPinCorrect));
        cardValidState.addTransition(new Transition(joinCardValidPinIncorrect));

        verifyingPin.addTransition(new Transition(decisionPinCorrect));

        // TODO do not force the flow
        decisionPinCorrect.addTransition(new Transition(new TrueConstraint(), pinCorrect));
        decisionPinCorrect.addTransition(new Transition(new FalseConstraint(), pinIncorrect));

        pinCorrect.addTransition(new Transition(joinCardValidPinCorrect));
        pinIncorrect.addTransition(new Transition(joinCardValidPinIncorrect));

        Behavior effect = new Behavior() {

            @Override
            public void execute() {
                atm.send(new SignalEvent("PINVerified"));
            }

            @Override
            public String toString() {
                return "atm.PINVerified";
            }
        };
        joinCardValidPinCorrect.addTransition(new Transition(effect, idle));
        joinCardValidPinIncorrect.addTransition(new Transition(decisionCardStillValid));

        Constraint numIncorrect_less_maxNumIncorrect = new Constraint() {

            @Override
            public boolean verify() {
                return numIncorrect < MAX_NUM_INCORRECT;
            }
        };

        Behavior incNumIncorrect_AtmReenterPIN = new Behavior() {

            @Override
            public void execute() {
                numIncorrect++;
                atm.send(new SignalEvent("reenterPIN"));
            }

            @Override
            public String toString() {
                return "atm.reenterPIN";
            }
        };

        decisionCardStillValid.addTransition(new Transition(numIncorrect_less_maxNumIncorrect,
                incNumIncorrect_AtmReenterPIN, idle));

        // Constraint numIncorrect_gt_maxNumIncorrect = new ElseConstraint(
        // numIncorrect_less_maxNumIncorrect);
        //
        // Behavior cardValidFalse_atmAbort = new Behavior() {
        //
        // @Override
        // public void execute() {
        // cardValid = false;
        // atm.send(new SignalEvent("abort"));
        // }
        //
        // @Override
        // public String toString() {
        // return "atm.abort";
        // }
        // };

        idle.addTransition(new Transition(new SignalEvent("done"), this.getEndState()));
    }

    public void verifyPin() {
        this.send(new CallEvent("verifyPIN"));
    }

}
