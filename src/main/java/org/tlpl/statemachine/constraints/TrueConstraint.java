package org.tlpl.statemachine.constraints;

public class TrueConstraint extends Constraint {

    @Override
    public boolean verify() {
        return true;
    }

    @Override
    public String toString() {
        return Boolean.TRUE.toString();
    }

}
