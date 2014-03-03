package org.tlpl.statemachine.behaviors;

public abstract class Behavior {
    public static final Behavior NO_BEHAVIOR = new EmptyBehavior();

    public abstract void execute();
}
