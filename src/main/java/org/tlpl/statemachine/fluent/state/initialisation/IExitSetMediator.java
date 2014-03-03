package org.tlpl.statemachine.fluent.state.initialisation;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;

public interface IExitSetMediator {

    IExitAndEntrySetMediator onEntry(Behavior entryBehavior);

    IExitAndWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior);

}
