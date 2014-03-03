package org.tlpl.statemachine.states;

import org.tlpl.statemachine.ICompositeState;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.transitions.Transition;

public class CompositeState extends SimpleState implements ICompositeState {

    private final IState endState;

    public CompositeState(String name, IState initialState) {
        super(name);
        this.endState = new SimpleState(name + "-EndState");
        super.addTransition(new Transition(initialState));
    }

    @Override
    public void addTransition(Transition transition) {
        endState.addTransition(transition);
    }

    @Override
    public IState getEndState() {
        return endState;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
