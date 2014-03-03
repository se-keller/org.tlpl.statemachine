package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitAndEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitAndWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitSetMediator;

public class ExitSetMediator extends AbstractStateMediator implements IExitSetMediator {

    public ExitSetMediator(IState state) {
        super(state);
    }

    @Override
    public IExitAndEntrySetMediator onEntry(Behavior entryBehavior) {
        state.setEntryBehavior(entryBehavior);
        return new ExitEntryAndWhileInsideSetMediator(state);
    }

    @Override
    public IExitAndWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior) {
        state.setDoBehavior(doBehavior);
        return new ExitEntryAndWhileInsideSetMediator(state);
    }

}
