package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.constraints.Constraint;

public interface IEffectSetMediator {

    ITransitionAddedMediator transition();

    IEffectAndTrggerSetMediator triggerdBySignal(String signal);

    IEffectAndTrggerSetMediator triggerdByCall(String signal);

    IEffectAndGuardSetMediator guardedBy(Constraint guard);

}
