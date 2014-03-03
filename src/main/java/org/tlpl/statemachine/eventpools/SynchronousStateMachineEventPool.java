package org.tlpl.statemachine.eventpools;

import org.tlpl.statemachine.IStateMachine;

public class SynchronousStateMachineEventPool extends AbstractStateMachineEventPool {
    public SynchronousStateMachineEventPool(IStateMachine... stateMachines) {
        super(stateMachines);
    }

    @Override
    protected void callMethodOnStateMachineToOverride(String methodName, IStateMachine stateMachine) {
        callMethodOnStateMachine(methodName, stateMachine);

    }

    @Override
    protected void sendSignalToStateMachineToOverride(String stateMachineName, String signalName) {
        sendSignalToStateMachine(stateMachineName, signalName);
    }

}
