package org.tlpl.statemachine.behaviors;

public class EmptyInterruptableBehavior extends InterruptableBehavior {

    @Override
    public void execute() {
        // Do nothing
    }

    @Override
    public void interrupt() {
        // Do Nothing
    }

}
