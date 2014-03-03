package org.tlpl.statemachine.fluent.statemachines;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.statemachines.StateMachine;

public class FluentStateMachine extends StateMachine implements IFluentStateMachine {

    private IFluentState initialState;

    public FluentStateMachine(String name) {
        super(name);
    }

    @Override
    protected IState getInitialState() {
        return (IState) initialState;
    }

    public void setInitialState(IFluentState state) {
        this.initialState = state;
    }

    @Override
    public IFluentStateMachine send(String signal) {
        send(new SignalEvent(signal));
        return this;
    }

    @Override
    public IFluentStateMachine resetStateMachine() {
        reset();
        return this;
    }

    @Override
    public IFluentStateMachine startStateMachine() {
        start();
        return this;
    }

    @Override
    public IFluentState getEndStateOfStateMachine() {

        return (IFluentState) getEndState();
    }

}
