package org.tlpl.statemachine.fluent.statemachines;

public class AbstractStateMachineMediator {
    protected FluentStateMachine stateMachine;

    public AbstractStateMachineMediator(FluentStateMachine stateMachine) {
        super();
        this.stateMachine = stateMachine;
    }
}
