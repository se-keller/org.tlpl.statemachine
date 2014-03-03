package org.tlpl.statemachine.states.pseudo;

import org.junit.BeforeClass;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.states.pseudo.Fork;


public class ForkEqualsTest extends AbstractEqualsHashCodeTest<Fork> {
    private static Fork fork;
    private static Fork differentFork;

    @BeforeClass
    public static void setUpBeforeClass() {
        fork = new Fork();
        differentFork = new Fork();
    }

    @Override
    protected Fork getAnotherEqualObject() {
        return fork;
    }

    @Override
    protected Fork getDifferentObject() {
        return differentFork;
    }

    @Override
    protected Fork getEqualObject() {
        return fork;
    }

    @Override
    protected Fork getObject() {
        return fork;
    }
}
