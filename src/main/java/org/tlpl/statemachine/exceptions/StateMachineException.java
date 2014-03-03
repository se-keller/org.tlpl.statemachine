package org.tlpl.statemachine.exceptions;

public class StateMachineException extends RuntimeException {

    private static final long serialVersionUID = 1432920856130661116L;

    public StateMachineException(String message) {
        super(message);
    }

    public StateMachineException(String msg, Exception cause) {
        super(msg, cause);
    }
}
