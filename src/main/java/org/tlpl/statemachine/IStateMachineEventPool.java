package org.tlpl.statemachine;

public interface IStateMachineEventPool extends ICallEventReceiver, ISignalEventReceiver {
    void addStateMachine(IStateMachine stateMachine);
}
