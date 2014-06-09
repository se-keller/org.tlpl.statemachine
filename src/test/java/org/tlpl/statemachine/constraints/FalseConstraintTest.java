package org.tlpl.statemachine.constraints;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class FalseConstraintTest {
    private FalseConstraint falseConstraint;

    @Before
    public void setUp() {
        this.falseConstraint = new FalseConstraint();
    }

    @Test
    public void verify_false() {
        Assert.assertFalse(falseConstraint.verify());
    }

    @Test
    public void toString_false() {
        Assert.assertSame("false", falseConstraint.toString());
    }
}
