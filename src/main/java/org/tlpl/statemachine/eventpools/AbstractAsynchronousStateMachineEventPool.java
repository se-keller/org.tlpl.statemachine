package org.tlpl.statemachine.eventpools;

import java.util.concurrent.ExecutorService;

import org.tlpl.statemachine.IStateMachine;


public abstract class AbstractAsynchronousStateMachineEventPool extends
        AbstractStateMachineEventPool {
    protected ExecutorService executorService;

    public AbstractAsynchronousStateMachineEventPool(IStateMachine... stateMachines) {
        super(stateMachines);
        executorService = getExecutorService();
    }

    protected abstract ExecutorService getExecutorService();

    @Override
    protected void callMethodOnStateMachineToOverride(String methodName, IStateMachine stateMachine) {
        callMethodOnStateMachine(methodName, stateMachine);
    }

    @Override
    protected void sendSignalToStateMachineToOverride(final String stateMachineName,
            final String signalName) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                sendSignalToStateMachine(stateMachineName, signalName);
            }
        });

    }
}
