package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAddedMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAndStateSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class TransitionAddedMediator extends AbstractStateMediator implements
        ITransitionAddedMediator {

    public TransitionAddedMediator(IState state) {
        super(state);
    }

    @Override
    public ITransitionAndStateSetMediator to(IFluentState state) {
        Transition transition = new Transition((IState) state);
        this.state.addTransition(transition);
        return new TransitionAndStateSetMediator(transition);
    }

}
