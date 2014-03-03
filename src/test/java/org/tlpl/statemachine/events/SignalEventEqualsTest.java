package org.tlpl.statemachine.events;

import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.events.SignalEvent;


public class SignalEventEqualsTest extends AbstractEqualsHashCodeTest<SignalEvent> {
    private static final String NAME = "TEST_EVENT";
    private static final String DIFFERENT_NAME = "DIFFERENT_TEST_EVENT";

    @Override
    protected SignalEvent getAnotherEqualObject() {
        return new SignalEvent(NAME);
    }

    @Override
    protected SignalEvent getDifferentObject() {
        return new SignalEvent(DIFFERENT_NAME);
    }

    @Override
    protected SignalEvent getEqualObject() {
        return new SignalEvent(NAME);
    }

    @Override
    protected SignalEvent getObject() {
        return new SignalEvent(NAME);
    }

    @Override
    protected SignalEvent getObjectWithNullParameterContructor() {
        return new SignalEvent(null);
    }

    @Override
    protected SignalEvent getAnotherObjectWithNullParameterContructor() {
        return new SignalEvent(null);
    }
}
