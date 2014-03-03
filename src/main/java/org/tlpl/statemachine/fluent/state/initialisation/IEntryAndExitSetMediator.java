package org.tlpl.statemachine.fluent.state.initialisation;

import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;

public interface IEntryAndExitSetMediator {

    IAddAnotherTransitionMediator whileInside(InterruptableBehavior doBehavior);

}
