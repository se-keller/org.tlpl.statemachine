package org.tlpl.statemachine.constraints;

public class FalseConstraint extends Constraint {

    @Override
    public boolean verify() {
        return false;
    }

    @Override
    public String toString() {
        return Boolean.FALSE.toString();
    }

}
