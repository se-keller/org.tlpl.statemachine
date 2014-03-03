package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideAndEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideAndExitSetMediator;

public class WhileInsideEntryAndExitSetMediator extends AbstractStateMediator implements
        IWhileInsideAndEntrySetMediator, IWhileInsideAndExitSetMediator {

    public WhileInsideEntryAndExitSetMediator(IState state) {
        super(state);
    }

    @Override
    public void onExit(Behavior exitBehavior) {
        state.setExitBehavior(exitBehavior);
    }

    @Override
    public void onEntry(Behavior entryBehavior) {
        state.setEntryBehavior(entryBehavior);
    }

}
