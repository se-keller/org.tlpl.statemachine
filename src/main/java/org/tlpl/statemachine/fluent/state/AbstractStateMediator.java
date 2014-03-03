package org.tlpl.statemachine.fluent.state;

import org.tlpl.statemachine.IState;

public class AbstractStateMediator {
    protected IState state;

    public AbstractStateMediator(IState state) {
        super();
        this.state = state;
    }
}
