package org.tlpl.statemachine.events;

import org.junit.Before;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.events.CompletionEvent;
import org.tlpl.statemachine.states.SimpleState;


public class CompletionEventEqualsTest extends AbstractEqualsHashCodeTest<CompletionEvent> {
    private static final String NAME = "TEST_STATE";
    private static final String DIFFERENT_NAME = "DIFFERENT_TEST_STATE";

    private CompletionEvent completionEvent;
    private CompletionEvent anotherEqualCompletionEvent;
    private CompletionEvent equalCompletionEvent;
    private CompletionEvent differentCompletionEvent;
    private IState state;
    private IState anotherState;

    @Before
    public void setUp() {
        state = new SimpleState(NAME);
        anotherState = new SimpleState(DIFFERENT_NAME);

        completionEvent = new CompletionEvent();
        completionEvent.setSenderState(state);
        anotherEqualCompletionEvent = new CompletionEvent();
        anotherEqualCompletionEvent.setSenderState(state);
        equalCompletionEvent = new CompletionEvent();
        equalCompletionEvent.setSenderState(state);
        differentCompletionEvent = new CompletionEvent();
        differentCompletionEvent.setSenderState(anotherState);
    }

    @Override
    protected CompletionEvent getAnotherEqualObject() {
        return anotherEqualCompletionEvent;
    }

    @Override
    protected CompletionEvent getDifferentObject() {
        return differentCompletionEvent;
    }

    @Override
    protected CompletionEvent getEqualObject() {
        return equalCompletionEvent;
    }

    @Override
    protected CompletionEvent getObject() {
        return completionEvent;
    }

    @Override
    protected CompletionEvent getObjectWithNullParameterContructor() {
        return new CompletionEvent();
    }

    @Override
    protected CompletionEvent getAnotherObjectWithNullParameterContructor() {
        return new CompletionEvent();
    }
}
