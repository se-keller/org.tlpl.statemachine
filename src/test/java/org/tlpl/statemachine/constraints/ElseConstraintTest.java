package org.tlpl.statemachine.constraints;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.constraints.ElseConstraint;
import org.tlpl.statemachine.constraints.TrueConstraint;


public class ElseConstraintTest {
    private TrueConstraint trueConstraint;

    @Before
    public void setUp() {
        this.trueConstraint = new TrueConstraint();

    }

    @Test
    public void verify_NotTrueConstraint_false() {
        ElseConstraint elseConstraint = new ElseConstraint(trueConstraint);
        Assert.assertFalse(elseConstraint.verify());
    }

    @Test
    public void verify_4GreaterThan3_true() {
        ElseConstraint greaterThan3 = createGreaterThan3ElseConstraint(4);
        Assert.assertTrue(greaterThan3.verify());
    }

    @Test
    public void verify_3GreaterThan3_false() {
        ElseConstraint greaterThan3 = createGreaterThan3ElseConstraint(3);
        Assert.assertFalse(greaterThan3.verify());
    }

    private ElseConstraint createGreaterThan3ElseConstraint(final int i) {
        Constraint lowerOrEquals1 = new Constraint() {
            @Override
            public boolean verify() {
                return i <= 1;
            }
        };
        Constraint bigger1lowerOrEquals3 = new Constraint() {
            @Override
            public boolean verify() {
                return (i > 1) && (i <= 3);
            }
        };
        ElseConstraint greaterThan3 = new ElseConstraint(lowerOrEquals1, bigger1lowerOrEquals3);
        return greaterThan3;
    }
}
