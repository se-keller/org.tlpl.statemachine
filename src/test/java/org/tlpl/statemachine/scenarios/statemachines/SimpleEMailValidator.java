package org.tlpl.statemachine.scenarios.statemachines;

import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.fluent.statemachines.IFluentStateMachine;
import org.tlpl.statemachine.fluent.statemachines.initialisation.impl.FluentStateMachineBuilder;
import org.tlpl.statemachine.states.SimpleState;

public class SimpleEMailValidator {
    private final IFluentStateMachine emailValidatorMachine;

    public SimpleEMailValidator() {
        IFluentState waitingForAt = new SimpleState("waiting for '@'");
        IFluentState waitingForDot = new SimpleState("waiting for '.'");

        FluentStateMachineBuilder fluentStateMachineBuilder = new FluentStateMachineBuilder();

        emailValidatorMachine =
                fluentStateMachineBuilder
                        .createStateMachine()
                        .called("EMailValidator")
                        .startingWith(waitingForAt);

        waitingForAt
                .transition().to(waitingForDot)
                    .triggeredBySignal("@");

        waitingForDot
                .transition().to(emailValidatorMachine.getEndStateOfStateMachine())
                    .triggeredBySignal(".");

    }

    public boolean validate(String eMailAddress) {
        emailValidatorMachine.startStateMachine();
        for (int i = 0; i < eMailAddress.length(); i++) {
            emailValidatorMachine.send(String.valueOf(eMailAddress.charAt(i)));
        }
        return emailValidatorMachine.isInEndState();
    }
}
