package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IEntryAndExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IEntryAndWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.impl.AddAnotherTransitionMediator;

public class EntryExitAndWhileInsideSetMediator extends AbstractStateMediator implements
        IEntryAndExitSetMediator,
        IEntryAndWhileInsideSetMediator {

    public EntryExitAndWhileInsideSetMediator(IState state) {
        super(state);
    }

    @Override
    public IAddAnotherTransitionMediator whileInside(InterruptableBehavior doBehavior) {
        state.setDoBehavior(doBehavior);
        return new AddAnotherTransitionMediator(state);
    }

    @Override
    public IAddAnotherTransitionMediator onExit(Behavior exitBehavior) {
        state.setExitBehavior(exitBehavior);
        return new AddAnotherTransitionMediator(state);
    }

}
