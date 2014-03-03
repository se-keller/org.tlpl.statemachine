package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAddedMediator;

public class AddAnotherTransitionMediator extends AbstractStateMediator implements
        IAddAnotherTransitionMediator {

    public AddAnotherTransitionMediator(IState state) {
        super(state);
    }

    @Override
    public ITransitionAddedMediator transition() {
        return new TransitionAddedMediator(state);
    }

}
