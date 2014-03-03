package org.tlpl.statemachine.scenarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.scenarios.statemachines.SimpleEMailValidator;


public class SimpleEMailValidatorTest {
    private SimpleEMailValidator validator;

    @Before
    public void setUp() {
        validator = new SimpleEMailValidator();
    }

    @Test
    public void validatorTest() {
        Assert.assertTrue(validator.validate("sekell@sekell.de"));
        Assert.assertFalse(validator.validate("sekellsekell.de"));
        Assert.assertFalse(validator.validate("sekell@sekellde"));
    }
}
