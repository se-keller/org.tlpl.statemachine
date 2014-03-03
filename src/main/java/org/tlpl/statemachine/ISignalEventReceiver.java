package org.tlpl.statemachine;

import org.tlpl.statemachine.events.SignalEvent;

public interface ISignalEventReceiver {

    void send(SignalEvent signal);

}
