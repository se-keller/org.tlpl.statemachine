package org.tlpl.statemachine.states;

import org.junit.Before;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.states.CompositeState;
import org.tlpl.statemachine.states.SimpleState;


public class CompositeStateEqualsTest extends AbstractEqualsHashCodeTest<CompositeState> {
    private static final String NAME = "COMPOSITE_TEST_STATE";
    private static final String DIFFERENT_NAME = "DIFFERENT_COMPOSITE_TEST_STATE";
    private static final String INITIAL_STATENAME = "INITIAL_TEST_STATE";

    private IState initialState;

    @Before
    public void setUp() {
        initialState = new SimpleState(INITIAL_STATENAME);
    }

    @Override
    protected CompositeState getAnotherEqualObject() {
        return new CompositeState(NAME, initialState);
    }

    @Override
    protected CompositeState getDifferentObject() {
        return new CompositeState(DIFFERENT_NAME, initialState);
    }

    @Override
    protected CompositeState getEqualObject() {
        return new CompositeState(NAME, initialState);
    }

    @Override
    protected CompositeState getObject() {
        return new CompositeState(NAME, initialState);
    }

    @Override
    protected CompositeState getObjectWithNullParameterContructor() {
        return new CompositeState(null, null);
    }

    @Override
    protected CompositeState getAnotherObjectWithNullParameterContructor() {
        return new CompositeState(null, initialState);
    }
}
