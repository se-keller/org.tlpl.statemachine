package org.tlpl.statemachine.events;

import org.tlpl.statemachine.IState;

public class CompletionEvent extends SignalEvent {

    private IState senderState;

    public CompletionEvent() {
        super("COMPLETION_EVENT");
    }

    public void setSenderState(IState senderState) {
        this.senderState = senderState;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((senderState == null) ? 0 : senderState.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CompletionEvent other = (CompletionEvent) obj;
        if (senderState == null) {
            if (other.senderState != null) {
                return false;
            }
        }
        else
            if (!senderState.equals(other.senderState)) {
                return false;
            }
        return true;
    }

}
