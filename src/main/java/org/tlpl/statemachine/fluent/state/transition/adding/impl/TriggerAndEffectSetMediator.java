package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITriggerAndEffectSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class TriggerAndEffectSetMediator extends AbstractTransitionMediator implements
        ITriggerAndEffectSetMediator {

    public TriggerAndEffectSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IAddAnotherTransitionMediator guardedBy(Constraint guard) {
        transition.setGuard(guard);
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

}
