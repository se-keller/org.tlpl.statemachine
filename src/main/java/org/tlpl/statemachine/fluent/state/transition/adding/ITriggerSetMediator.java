package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;

public interface ITriggerSetMediator {

    ITransitionAddedMediator transition();

    ITriggerAndGuardSetMediator guardedBy(Constraint guard);

    ITriggerAndEffectSetMediator causingEffect(Behavior effect);

}
