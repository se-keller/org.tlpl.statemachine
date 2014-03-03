package org.tlpl.statemachine.exceptions;

public class EventPoolException extends StateMachineException {

    private static final long serialVersionUID = 6154300753013234011L;

    public EventPoolException(String msg) {
        super(msg);
    }

    public EventPoolException(String msg, Exception cause) {
        super(msg, cause);
    }
}
