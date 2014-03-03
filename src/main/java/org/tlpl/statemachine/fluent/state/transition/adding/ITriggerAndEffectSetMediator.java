package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.constraints.Constraint;

public interface ITriggerAndEffectSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator guardedBy(Constraint guard);

}
