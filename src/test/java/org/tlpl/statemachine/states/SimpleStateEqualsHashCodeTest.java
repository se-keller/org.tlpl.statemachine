package org.tlpl.statemachine.states;

import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.states.SimpleState;


public class SimpleStateEqualsHashCodeTest extends AbstractEqualsHashCodeTest<SimpleState> {

    private static final String NAME = "TEST_STATE";
    private static final String DIFFERENT_NAME = "DIFFERENT_TEST_STATE";

    @Override
    protected SimpleState getAnotherEqualObject() {
        return new SimpleState(NAME);
    }

    @Override
    protected SimpleState getDifferentObject() {
        return new SimpleState(DIFFERENT_NAME);
    }

    @Override
    protected SimpleState getEqualObject() {
        return new SimpleState(NAME);
    }

    @Override
    protected SimpleState getObject() {
        return new SimpleState(NAME);
    }

    @Override
    protected SimpleState getObjectWithNullParameterContructor() {
        return new SimpleState(null);
    }

    @Override
    protected SimpleState getAnotherObjectWithNullParameterContructor() {
        return new SimpleState(null);
    }

}
