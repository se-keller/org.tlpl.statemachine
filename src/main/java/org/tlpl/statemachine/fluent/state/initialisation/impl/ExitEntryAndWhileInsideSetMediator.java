package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitAndEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitAndWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.impl.AddAnotherTransitionMediator;

public class ExitEntryAndWhileInsideSetMediator extends AbstractStateMediator implements
        IExitAndEntrySetMediator,
        IExitAndWhileInsideSetMediator {

    public ExitEntryAndWhileInsideSetMediator(IState state) {
        super(state);
    }

    @Override
    public IAddAnotherTransitionMediator whileInside(InterruptableBehavior doBehavior) {
        state.setDoBehavior(doBehavior);
        return new AddAnotherTransitionMediator(state);
    }

    @Override
    public IAddAnotherTransitionMediator onEntry(Behavior entryBehavior) {
        state.setEntryBehavior(entryBehavior);
        return new AddAnotherTransitionMediator(state);
    }

}
