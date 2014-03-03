package org.tlpl.statemachine.scenarios.statemachines;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.statemachines.StateMachine;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.transitions.Transition;

public class OneStepToEndStateMachine extends StateMachine {

    private final IState initialState;

    public OneStepToEndStateMachine() {
        super(OneStepToEndStateMachine.class.getName());

        initialState = new SimpleState("Idle");

        initialState
                .addTransition(new Transition(new SignalEvent("TO_END"), getEndState()));
        initialState.addTransition(new Transition(new CallEvent("toEnd"), getEndState()));
    }

    @Override
    protected IState getInitialState() {
        return initialState;
    }

    public void toEnd() {
        send(new CallEvent("toEnd"));
    }

}
