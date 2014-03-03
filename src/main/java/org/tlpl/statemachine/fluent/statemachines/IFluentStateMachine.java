package org.tlpl.statemachine.fluent.statemachines;

import org.tlpl.statemachine.fluent.state.IFluentState;

public interface IFluentStateMachine {
    IFluentStateMachine send(String signal);

    boolean isInEndState();

    IFluentStateMachine resetStateMachine();

    IFluentStateMachine startStateMachine();

    IFluentState getEndStateOfStateMachine();
}
