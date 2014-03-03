package org.tlpl.statemachine.states.pseudo;

import java.util.HashSet;
import java.util.Set;

import org.tlpl.statemachine.transitions.Transition;


public class Join extends PseudoState {

    private final Set<Transition> incomingTransitions;
    private final Set<Transition> enteredTransitions;
    private Transition outGoingTransation;

    public Join() {
        super("JOIN");
        incomingTransitions = new HashSet<Transition>();
        enteredTransitions = new HashSet<Transition>();

    }

    public void addWaitForTransition(Transition transition) {
        incomingTransitions.add(transition);
    }

    @Override
    public void fireStateEntered(Transition fromTransition) {
        enteredTransitions.add(fromTransition);
        if (enteredTransitions.containsAll(incomingTransitions)) {
            transitions.add(outGoingTransation);
            enteredTransitions.clear();
        }
        else {
            transitions.clear();
        }
    }

    @Override
    public void addTransition(Transition transition) {
        // only one!!!
        transitions.clear();
        super.addTransition(transition);
        outGoingTransation = transition;
    }

}
