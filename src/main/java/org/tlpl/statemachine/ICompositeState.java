package org.tlpl.statemachine;

public interface ICompositeState extends IState {
    IState getEndState();
}
