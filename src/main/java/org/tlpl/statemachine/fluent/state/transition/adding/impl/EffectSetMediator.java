package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.transition.adding.IEffectAndGuardSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IEffectAndTrggerSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IEffectSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class EffectSetMediator extends AbstractTransitionMediator implements IEffectSetMediator {

    public EffectSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IEffectAndGuardSetMediator guardedBy(Constraint guard) {
        transition.setGuard(guard);
        return new EffectAndGuardSetMediator(transition);
    }

    @Override
    public IEffectAndTrggerSetMediator triggerdByCall(String signal) {
        transition.setTriggerEvent(new CallEvent(signal));
        return new EffectAndTriggerSetMediator(transition);
    }

    @Override
    public IEffectAndTrggerSetMediator triggerdBySignal(String signal) {
        transition.setTriggerEvent(new SignalEvent(signal));
        return new EffectAndTriggerSetMediator(transition);
    }
}
