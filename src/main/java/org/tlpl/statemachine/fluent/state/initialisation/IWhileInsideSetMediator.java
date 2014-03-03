package org.tlpl.statemachine.fluent.state.initialisation;

import org.tlpl.statemachine.behaviors.Behavior;

public interface IWhileInsideSetMediator {

    IWhileInsideAndExitSetMediator onExit(Behavior noBehavior);

    IWhileInsideAndEntrySetMediator onEntry(Behavior entryBehavior);

}
