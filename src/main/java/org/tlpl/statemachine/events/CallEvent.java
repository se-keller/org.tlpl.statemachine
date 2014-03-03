package org.tlpl.statemachine.events;

public class CallEvent extends SignalEvent {

    public CallEvent(String signal) {
        super(signal + "()");
    }

}
