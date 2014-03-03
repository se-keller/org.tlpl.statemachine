package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.behaviors.Behavior;

public interface IGuardSetMediator {

    ITransitionAddedMediator transition();

    IGuardAndTriggerSetMediator triggeredBySignal(String signal);

    IGuardAndTriggerSetMediator triggeredByCall(String signal);

    IGuardAndEffectSetMediator causingEffect(Behavior effect);

}
