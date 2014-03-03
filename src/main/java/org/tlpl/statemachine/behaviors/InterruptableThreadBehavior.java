package org.tlpl.statemachine.behaviors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class InterruptableThreadBehavior extends InterruptableBehavior {

    private final ExecutorService singleThreadExecutor;

    public InterruptableThreadBehavior() {
        singleThreadExecutor = Executors.newSingleThreadExecutor();
    }

    @Override
    public void start() {
        singleThreadExecutor.execute(new Runnable() {
            @Override
            public void run() {
                executeAndCallCompletionEvent();
            }
        });
    }

    @Override
    public void interrupt() {
        singleThreadExecutor.shutdownNow();
    }

}
