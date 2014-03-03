package org.tlpl.statemachine.events;

import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.events.CallEvent;


public class CallEventEqualsTest extends AbstractEqualsHashCodeTest<CallEvent> {
    private static final String NAME = "TEST_EVENT";
    private static final String DIFFERENT_NAME = "DIFFERENT_TEST_EVENT";

    @Override
    protected CallEvent getAnotherEqualObject() {
        return new CallEvent(NAME);
    }

    @Override
    protected CallEvent getDifferentObject() {
        return new CallEvent(DIFFERENT_NAME);
    }

    @Override
    protected CallEvent getEqualObject() {
        return new CallEvent(NAME);
    }

    @Override
    protected CallEvent getObject() {
        return new CallEvent(NAME);
    }

    @Override
    protected CallEvent getObjectWithNullParameterContructor() {
        return new CallEvent(null);
    }

    @Override
    protected CallEvent getAnotherObjectWithNullParameterContructor() {
        return new CallEvent(null);
    }
}
