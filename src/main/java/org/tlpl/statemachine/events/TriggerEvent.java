package org.tlpl.statemachine.events;

public abstract class TriggerEvent {

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    public boolean isCompletionEvent() {
        return this.getClass().equals(CompletionEvent.class);
    }

}
