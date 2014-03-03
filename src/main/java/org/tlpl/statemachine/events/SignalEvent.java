package org.tlpl.statemachine.events;

public class SignalEvent extends TriggerEvent {
    private final String signal;

    public SignalEvent(String signal) {
        this.signal = signal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 42;
        result = prime * result + ((signal == null) ? 0 : signal.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SignalEvent other = (SignalEvent) obj;
        if (signal == null) {
            if (other.signal != null) {
                return false;
            }
        }
        else
            if (!signal.equals(other.signal)) {
                return false;
            }
        return true;
    }

    @Override
    public String toString() {
        return signal;
    }

}
