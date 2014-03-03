package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.behaviors.Behavior;

public interface IGuardAndTriggerSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator causingEffect(Behavior effect);

}
