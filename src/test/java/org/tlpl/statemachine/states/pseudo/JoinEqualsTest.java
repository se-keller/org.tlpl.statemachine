package org.tlpl.statemachine.states.pseudo;

import org.junit.BeforeClass;
import org.tlpl.statemachine.AbstractEqualsHashCodeTest;
import org.tlpl.statemachine.states.pseudo.Join;


public class JoinEqualsTest extends AbstractEqualsHashCodeTest<Join> {

    private static Join join;
    private static Join differentJoin;

    @BeforeClass
    public static void setUpBeforeClass() {
        join = new Join();
        differentJoin = new Join();
    }

    @Override
    protected Join getAnotherEqualObject() {
        return join;
    }

    @Override
    protected Join getDifferentObject() {
        return differentJoin;
    }

    @Override
    protected Join getEqualObject() {
        return join;
    }

    @Override
    protected Join getObject() {
        return join;
    }
}
