package org.tlpl.statemachine.fluent.state;

import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.states.SimpleState;


public class FluentStateTest {

    private IFluentState state;

    @Before
    public void setUp() {
        state = new SimpleState("TestState");
    }

    @Test
    public void fluentApiSmokeTest() {
        state
                .onEntry(Behavior.NO_BEHAVIOR)
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .onExit(Behavior.NO_BEHAVIOR)
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggeredBySignal("test")
                    .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggeredBySignal("test")
                    .causingEffect(Behavior.NO_BEHAVIOR);
    }

    @Test
    public void transitionAdding_noException() {

        // ///////////
        state
                .transition().to(state)
                .transition().to(state);
        // ///////////
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggeredBySignal("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggeredBySignal("test")
                .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggeredByCall("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .triggeredBySignal("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .triggeredByCall("test")
                .transition().to(state);
        // ///////////
        state
                .transition().to(state)
                    .triggeredBySignal("test")
                .transition().to(state);
        state
                .transition().to(state)
                .triggeredByCall("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .triggeredBySignal("test")
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                .transition().to(state);
        state
                .transition().to(state)
                    .triggeredBySignal("test")
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state);
        state
                .transition().to(state)
                    .triggeredBySignal("test")
                    .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state);
        state
                .transition().to(state)
                    .triggeredBySignal("test")
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                .transition().to(state);

        // ///////////
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .triggerdBySignal("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .triggerdByCall("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .triggerdByCall("test")
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggerdBySignal("test")
                .transition().to(state);
        state
                .transition().to(state)
                    .causingEffect(Behavior.NO_BEHAVIOR)
                    .guardedBy(Constraint.TRUE_CONSTRAINT)
                    .triggerdByCall("test")
                .transition().to(state);

    }

    @Test
    public void stateInitialization_noException() {

        state
                .onEntry(Behavior.NO_BEHAVIOR)
                .onExit(Behavior.NO_BEHAVIOR)
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .transition().to(state);

        state
                .onEntry(Behavior.NO_BEHAVIOR)
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .onExit(Behavior.NO_BEHAVIOR)
                .transition().to(state);

        state
                .onExit(Behavior.NO_BEHAVIOR)
                .onEntry(Behavior.NO_BEHAVIOR)
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .transition().to(state);
        state
                .onExit(Behavior.NO_BEHAVIOR)
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .onEntry(Behavior.NO_BEHAVIOR)
                .transition().to(state);

        state
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .onExit(Behavior.NO_BEHAVIOR)
                .onEntry(Behavior.NO_BEHAVIOR);

        state
                .whileInside(InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR)
                .onEntry(Behavior.NO_BEHAVIOR)
                .onExit(Behavior.NO_BEHAVIOR);
        // TODO support deferrable trigger event
    }
}
