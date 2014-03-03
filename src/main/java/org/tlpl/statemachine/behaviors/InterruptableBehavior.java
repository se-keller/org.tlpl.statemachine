package org.tlpl.statemachine.behaviors;

import org.tlpl.statemachine.ISignalEventReceiver;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.events.CompletionEvent;

public abstract class InterruptableBehavior extends Behavior {

    public static final InterruptableBehavior INTERRUPTABLE_NO_BEHAVIOR = new EmptyInterruptableBehavior();
    private ISignalEventReceiver signalEventReceiver;
    private IState senderState;

    public void start() {
        executeAndCallCompletionEvent();
    }

    public abstract void interrupt();

    protected void executeAndCallCompletionEvent() {
        execute();
        CompletionEvent completionEvent = new CompletionEvent();
        completionEvent.setSenderState(senderState);
        signalEventReceiver.send(completionEvent);
    }

    public void setSignalEventReceiver(ISignalEventReceiver signalEventReceiver) {
        this.signalEventReceiver = signalEventReceiver;
    }

    public void setSenderState(IState senderState) {
        this.senderState = senderState;
    }

}
