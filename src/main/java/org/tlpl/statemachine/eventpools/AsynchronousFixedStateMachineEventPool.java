package org.tlpl.statemachine.eventpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousFixedStateMachineEventPool extends
        AbstractAsynchronousStateMachineEventPool {

    private final int poolSize;

    public AsynchronousFixedStateMachineEventPool(int poolSize) {
        this.poolSize = poolSize;
        executorService = getExecutorService();
    }

    @Override
    protected ExecutorService getExecutorService() {
        // TODO somehow after the constructor-call the super-constructor is called. It shouldn't!
        // So this is a work around. It's an uninitialized read of field method called from
        // constructor of superclass.
        // poolSize isn't initialized when invoked from constructor for superclass.
        if (poolSize == 0) {
            return Executors.newFixedThreadPool(1);
        }
        return Executors.newFixedThreadPool(poolSize);
    }

}
