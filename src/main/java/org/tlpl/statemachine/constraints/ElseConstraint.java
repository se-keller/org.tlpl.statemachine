package org.tlpl.statemachine.constraints;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ElseConstraint extends Constraint {

    private final Set<Constraint> ifConstraints;

    public ElseConstraint(Constraint ifConstraint, Constraint... otherIfConstraints) {
        ifConstraints = new HashSet<Constraint>(Arrays.asList(otherIfConstraints));
        // TODO check for concurrent constraints and throw StateMachineException
        ifConstraints.add(ifConstraint);
    }

    @Override
    public boolean verify() {
        for (Constraint ifConstraint : ifConstraints) {
            if (ifConstraint.verify()) {
                return false;
            }
        }
        return true;
    }

}
