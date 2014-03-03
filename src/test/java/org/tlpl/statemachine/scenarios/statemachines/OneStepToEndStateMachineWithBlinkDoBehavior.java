package org.tlpl.statemachine.scenarios.statemachines;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.scenarios.behaviors.BlinkBehavior;
import org.tlpl.statemachine.statemachines.StateMachine;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.transitions.Transition;


public class OneStepToEndStateMachineWithBlinkDoBehavior extends StateMachine {
    private final IState initialState;

    public OneStepToEndStateMachineWithBlinkDoBehavior() {
        super(OneStepToEndStateMachineWithBlinkDoBehavior.class.getName());

        initialState = new SimpleState("Idle");
        initialState.setDoBehavior(new BlinkBehavior());
        initialState.addTransition(new Transition(new SignalEvent("TO_END"), getEndState()));
    }

    @Override
    protected IState getInitialState() {
        return initialState;
    }
}
