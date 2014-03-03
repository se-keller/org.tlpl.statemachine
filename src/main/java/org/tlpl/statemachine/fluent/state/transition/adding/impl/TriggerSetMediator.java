package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.fluent.state.transition.adding.ITriggerAndEffectSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITriggerAndGuardSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITriggerSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class TriggerSetMediator extends AbstractTransitionMediator implements ITriggerSetMediator {

    public TriggerSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public ITriggerAndEffectSetMediator causingEffect(Behavior effect) {
        transition.setEffect(effect);
        return new TriggerAndEffectSetMediator(transition);
    }

    @Override
    public ITriggerAndGuardSetMediator guardedBy(Constraint guard) {
        transition.setGuard(guard);
        return new TriggerAndGuardSetMediator(transition);
    }

}
