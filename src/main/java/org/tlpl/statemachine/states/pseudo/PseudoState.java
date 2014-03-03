package org.tlpl.statemachine.states.pseudo;

import java.util.UUID;

import org.tlpl.statemachine.states.SimpleState;


public abstract class PseudoState extends SimpleState {

    private final UUID uuid;

    public PseudoState(String name) {
        super(name);
        uuid = UUID.randomUUID();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
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
        PseudoState other = (PseudoState) obj;
        if (uuid == null) {
            if (other.uuid != null) {
                return false;
            }
        }
        else
            if (!uuid.equals(other.uuid)) {
                return false;
            }
        return true;
    }

}
