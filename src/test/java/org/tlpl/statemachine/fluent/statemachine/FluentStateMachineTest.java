package org.tlpl.statemachine.fluent.statemachine;

import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.fluent.statemachines.IFluentStateMachine;
import org.tlpl.statemachine.fluent.statemachines.initialisation.impl.FluentStateMachineBuilder;
import org.tlpl.statemachine.states.SimpleState;


public class FluentStateMachineTest {
    private IFluentStateMachine stateMachine;
    private IFluentState state;

    @Before
    public void setUp() {
        state = new SimpleState("TestState");
    }

    @Test
    public void fluentApiSmokeTest() {

        FluentStateMachineBuilder fluentStateMachineBuilder = new FluentStateMachineBuilder();

        stateMachine =
                fluentStateMachineBuilder
                        .createStateMachine()
                        .called("TestMachine")
                        .startingWith(state);

        stateMachine
                .startStateMachine()
                .send("TestSignal")
                .send("TestSignal")
                .resetStateMachine()
                .startStateMachine()
                .send("TestSignal")
                .isInEndState();

        stateMachine =
                fluentStateMachineBuilder
                        .createStateMachine()
                        .called("TestMachine")
                        .startingWith(state);

    }
}
