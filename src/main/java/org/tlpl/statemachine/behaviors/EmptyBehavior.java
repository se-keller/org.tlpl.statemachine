package org.tlpl.statemachine.behaviors;

public class EmptyBehavior extends Behavior {

    @Override
    public void execute() {
        // Do nothing
    }

    @Override
    public String toString() {
        return "skip";
    }

}
