package org.tlpl.statemachine.statemachines;

import org.junit.Before;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.statemachines.EmptyStateMachine;
import org.tlpl.statemachine.states.SimpleState;


public class EmptyStateEqualsTest extends AbstractEqualsHashCodeTest<EmptyStateMachine> {
    private static final String NAME = "TEST_STATEMACHINE";
    private static final String DIFFERENT_NAME = "DIFFERENT_TEST_STATEMMACHINE";
    private static final String INITIAL_STATENAME = "INITIAL_STATE_NAME";

    private IState initialState;

    @Before
    public void setUp() {
        initialState = new SimpleState(INITIAL_STATENAME);
    }

    @Override
    protected EmptyStateMachine getAnotherEqualObject() {
        return new EmptyStateMachine(NAME, initialState);
    }

    @Override
    protected EmptyStateMachine getDifferentObject() {
        return new EmptyStateMachine(DIFFERENT_NAME, initialState);
    }

    @Override
    protected EmptyStateMachine getEqualObject() {
        return new EmptyStateMachine(NAME, initialState);
    }

    @Override
    protected EmptyStateMachine getObject() {
        return new EmptyStateMachine(NAME, initialState);
    }

    @Override
    protected EmptyStateMachine getObjectWithNullParameterContructor() {
        return new EmptyStateMachine(null, null);
    }

    @Override
    protected EmptyStateMachine getAnotherObjectWithNullParameterContructor() {
        return new EmptyStateMachine(null, initialState);
    }
}
