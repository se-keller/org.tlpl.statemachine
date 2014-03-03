package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAddedMediator;
import org.tlpl.statemachine.transitions.Transition;

public abstract class AbstractTransitionMediator {
    protected Transition transition;

    public AbstractTransitionMediator(Transition transition) {
        super();
        this.transition = transition;
    }

    public ITransitionAddedMediator transition() {
        return new TransitionAddedMediator(transition.getSourceState());
    }

}
