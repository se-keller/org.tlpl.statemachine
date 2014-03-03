package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IEntryAndExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IEntryAndWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IEntrySetMediator;

public class EntrySetMediator extends AbstractStateMediator implements IEntrySetMediator {

    public EntrySetMediator(IState state) {
        super(state);
    }

    @Override
    public IEntryAndExitSetMediator onExit(Behavior exitBehavior) {
        state.setExitBehavior(exitBehavior);
        return new EntryExitAndWhileInsideSetMediator(state);
    }

    @Override
    public IEntryAndWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior) {
        state.setDoBehavior(doBehavior);
        return new EntryExitAndWhileInsideSetMediator(state);
    }

}
