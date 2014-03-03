package org.tlpl.statemachine.states.pseudo;

import org.junit.BeforeClass;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.states.pseudo.Decision;


public class DecisionEqualsTest extends AbstractEqualsHashCodeTest<Decision> {

    private static Decision decision;
    private static Decision differentDecision;

    @BeforeClass
    public static void setUpBeforeClass() {
        decision = new Decision();
        differentDecision = new Decision();
    }

    @Override
    protected Decision getAnotherEqualObject() {
        return decision;
    }

    @Override
    protected Decision getDifferentObject() {
        return differentDecision;
    }

    @Override
    protected Decision getEqualObject() {
        return decision;
    }

    @Override
    protected Decision getObject() {
        return decision;
    }
}
