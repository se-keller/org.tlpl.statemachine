package org.tlpl.statemachine.fluent.state;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.initialisation.IEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAddedMediator;

public interface IFluentState {

    ITransitionAddedMediator transition();

    IEntrySetMediator onEntry(Behavior entryBehavior);

    IExitSetMediator onExit(Behavior exitBehavior);

    IWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior);

}
