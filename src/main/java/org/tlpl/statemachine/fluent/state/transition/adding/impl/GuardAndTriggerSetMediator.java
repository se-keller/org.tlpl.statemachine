package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardAndTriggerSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class GuardAndTriggerSetMediator extends AbstractTransitionMediator implements
        IGuardAndTriggerSetMediator {

    public GuardAndTriggerSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IAddAnotherTransitionMediator causingEffect(Behavior effect) {
        transition.setEffect(effect);
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

}
