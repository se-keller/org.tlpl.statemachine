package org.tlpl.statemachine.transitions;

import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.states.pseudo.Join;
import org.tlpl.statemachine.transitions.Transition;


public class TransitionEqualsHashCodeTest extends AbstractEqualsHashCodeTest<Transition> {

    private final Join join = new Join();

    @Override
    protected Transition getObject() {
        return new Transition(join);
    }

    @Override
    protected Transition getEqualObject() {
        return new Transition(join);
    }

    @Override
    protected Transition getAnotherEqualObject() {
        return new Transition(join);
    }

    @Override
    protected Transition getDifferentObject() {
        return new Transition(new SignalEvent("TEST"), join);
    }

}
