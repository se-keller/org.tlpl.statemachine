package org.tlpl.statemachine.fluent.state.initialisation;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;

public interface IEntrySetMediator {

    IEntryAndExitSetMediator onExit(Behavior exitBehavior);

    IEntryAndWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior);

}
