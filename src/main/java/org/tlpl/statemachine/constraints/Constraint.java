package org.tlpl.statemachine.constraints;

public abstract class Constraint {
    public static final Constraint TRUE_CONSTRAINT = new TrueConstraint();

    public abstract boolean verify();
}
