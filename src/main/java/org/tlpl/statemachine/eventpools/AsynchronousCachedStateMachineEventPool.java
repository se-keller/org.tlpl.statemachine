package org.tlpl.statemachine.eventpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsynchronousCachedStateMachineEventPool extends
        AbstractAsynchronousStateMachineEventPool {

    @Override
    protected ExecutorService getExecutorService() {
        return Executors.newCachedThreadPool();
    }

}
