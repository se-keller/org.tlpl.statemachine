package org.tlpl.statemachine.statemachines;

import org.tlpl.statemachine.IState;

public class EmptyStateMachine extends StateMachine {

    private final IState initialState;

    public EmptyStateMachine(String name, IState initialState) {
        super(name);
        this.initialState = initialState;
    }

    @Override
    protected IState getInitialState() {
        return initialState;
    }

}
