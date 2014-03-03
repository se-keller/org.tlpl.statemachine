package org.tlpl.statemachine;

import java.util.Set;


public interface IStateMachine extends ISignalEventReceiver {
    void start();

    void reset();

    Set<IState> getActualStates();

    IState getEndState();

    boolean isInEndState();

    boolean isInState(IState state);

    String getName();
}
