package org.tlpl.statemachine.fluent.statemachines.initialisation.impl;

import org.tlpl.statemachine.fluent.statemachines.FluentStateMachine;

public class CreateCalledMediator {

    public NameSetMediator called(String stateMachineName) {
        FluentStateMachine stateMachine = new FluentStateMachine(stateMachineName);
        return new NameSetMediator(stateMachine);
    }

}
