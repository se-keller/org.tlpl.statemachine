package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.behaviors.Behavior;

public interface ITriggerAndGuardSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator causingEffect(Behavior effect);

}
