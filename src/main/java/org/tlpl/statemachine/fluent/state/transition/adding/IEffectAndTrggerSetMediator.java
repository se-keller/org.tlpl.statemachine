package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.constraints.Constraint;

public interface IEffectAndTrggerSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator guardedBy(Constraint guard);

}
