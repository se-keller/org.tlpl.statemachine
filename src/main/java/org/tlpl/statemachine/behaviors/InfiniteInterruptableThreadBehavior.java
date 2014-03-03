package org.tlpl.statemachine.behaviors;

public abstract class InfiniteInterruptableThreadBehavior extends InterruptableThreadBehavior {

    private boolean isInterrupted = false;

    @Override
    public void execute() {
        while (!isInterrupted) {
            executeInfinitTillInterrupted();
        }
    }

    protected abstract void executeInfinitTillInterrupted();

    @Override
    public void interrupt() {
        isInterrupted = true;
    }

}
