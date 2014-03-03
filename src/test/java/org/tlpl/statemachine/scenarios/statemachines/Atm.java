package org.tlpl.statemachine.scenarios.statemachines;

import org.tlpl.statemachine.ICompositeState;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.statemachines.StateMachine;
import org.tlpl.statemachine.states.CompositeState;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.transitions.Transition;

public class Atm extends StateMachine {

    private IState cardEntry;
    private IState pinEntry;
    private IState verification;
    private IState returningCard;
    private IState amountEntry;
    private IState counting;
    private IState dispending;
    private ICompositeState givingMoneyCompositeState;

    private final Bank bank;

    public Atm(Bank bank) {
        super("ATM");
        this.bank = bank;
        initStates();
        initCompositeStates();
        initTransitions();
    }

    @Override
    protected IState getInitialState() {
        return cardEntry;
    }

    private void initStates() {
        cardEntry = new SimpleState("CardEntry");
        pinEntry = new SimpleState("PINEntry");
        verification = new SimpleState("Verification");
        returningCard = new SimpleState("ReturningCard");
        amountEntry = new SimpleState("AmountEntry");
        counting = new SimpleState("Counting");
        dispending = new SimpleState("Dispending");
    }

    private void initCompositeStates() {
        givingMoneyCompositeState = new CompositeState("Giving Money", counting);
        counting.addTransition(new Transition(dispending));
        dispending.addTransition(new Transition(givingMoneyCompositeState.getEndState()));
    }

    private void initTransitions() {
        cardEntry.addTransition(new Transition(pinEntry));

        Behavior bank_verifyPIN_effect = new Behavior() {
            @Override
            public void execute() {
                bank.verifyPin();
            }

            @Override
            public String toString() {
                return "bank.verifyPIN()";
            }
        };
        Transition pinEntry_verification = new Transition(bank_verifyPIN_effect, verification);
        pinEntry.addTransition(pinEntry_verification);

        verification.addTransition(new Transition(new SignalEvent("reenterPIN"), pinEntry));

        verification.addTransition(new Transition(new SignalEvent("abort"), returningCard));

        verification.addTransition(new Transition(new SignalEvent("PINVerified"), amountEntry));

        amountEntry.addTransition(new Transition(givingMoneyCompositeState));

        givingMoneyCompositeState.addTransition(new Transition(returningCard));

        Behavior bank_done = new Behavior() {
            @Override
            public void execute() {
                bank.send(new SignalEvent("done"));
            }

            @Override
            public String toString() {
                return "bank.done";
            }
        };

        returningCard.addTransition(new Transition(bank_done, this.getEndState()));

    }

}
