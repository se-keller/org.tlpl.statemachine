package org.tlpl.statemachine.fluent.state.initialisation.impl;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.fluent.state.AbstractStateMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideAndEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideAndExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideSetMediator;

public class WhileInsideSetMediator extends AbstractStateMediator implements IWhileInsideSetMediator {

    public WhileInsideSetMediator(IState state) {
        super(state);
    }

    @Override
    public IWhileInsideAndEntrySetMediator onEntry(Behavior entryBehavior) {
        state.setEntryBehavior(entryBehavior);
        return new WhileInsideEntryAndExitSetMediator(state);
    }

    @Override
    public IWhileInsideAndExitSetMediator onExit(Behavior exitBehavior) {
        state.setExitBehavior(exitBehavior);
        return new WhileInsideEntryAndExitSetMediator(state);
    }

}
