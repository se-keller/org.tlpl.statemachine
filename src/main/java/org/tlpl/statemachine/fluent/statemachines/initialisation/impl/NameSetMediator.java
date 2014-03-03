package org.tlpl.statemachine.fluent.statemachines.initialisation.impl;

import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.fluent.statemachines.AbstractStateMachineMediator;
import org.tlpl.statemachine.fluent.statemachines.FluentStateMachine;
import org.tlpl.statemachine.fluent.statemachines.IFluentStateMachine;

public class NameSetMediator extends AbstractStateMachineMediator {

    public NameSetMediator(FluentStateMachine stateMachine) {
        super(stateMachine);
    }

    public IFluentStateMachine startingWith(IFluentState state) {
        stateMachine.setInitialState(state);
        return stateMachine;
    }

}
