package org.tlpl.statemachine.states;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.states.SimpleState;


public class SimpleStateTest {
    private static final String STATE_NAME = "TEST_STATE";
    private SimpleState state;

    @Before
    public void setUp() {
        state = new SimpleState(STATE_NAME);
    }

    @Test
    public void getName_returnsTheStateName() {
        Assert.assertEquals(STATE_NAME, state.getName());
    }
}
