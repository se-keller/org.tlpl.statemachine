package org.tlpl.statemachine;

import org.tlpl.statemachine.events.CallEvent;

public interface ICallEventReceiver {
    void send(CallEvent callEvent);
}
