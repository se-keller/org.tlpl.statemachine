package org.tlpl.statemachine.constraints;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.constraints.TrueConstraint;


public class TrueConstraintTest {
    private TrueConstraint trueConstraint;

    @Before
    public void setUp() {
        this.trueConstraint = new TrueConstraint();
    }

    @Test
    public void verify_true() {
        Assert.assertTrue(trueConstraint.verify());
    }

    @Test
    public void toString_true() {
        Assert.assertSame(Boolean.TRUE.toString(), trueConstraint.toString());
    }
}
