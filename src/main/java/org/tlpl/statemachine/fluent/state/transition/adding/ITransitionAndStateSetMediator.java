package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;

public interface ITransitionAndStateSetMediator {

    IGuardSetMediator guardedBy(Constraint guard);

    ITriggerSetMediator triggeredBySignal(String signal);

    ITriggerSetMediator triggeredByCall(String signal);

    IEffectSetMediator causingEffect(Behavior noBehavior);

    ITransitionAddedMediator transition();

}
