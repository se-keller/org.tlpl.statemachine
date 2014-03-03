package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.transition.adding.IEffectSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAndStateSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITriggerSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class TransitionAndStateSetMediator extends AbstractTransitionMediator implements
        ITransitionAndStateSetMediator {

    public TransitionAndStateSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IEffectSetMediator causingEffect(Behavior effect) {
        transition.setEffect(effect);
        return new EffectSetMediator(transition);
    }

    @Override
    public IGuardSetMediator guardedBy(Constraint guard) {
        transition.setGuard(guard);
        return new GuardSetMediator(transition);
    }

    @Override
    public ITriggerSetMediator triggeredByCall(String signal) {
        transition.setTriggerEvent(new CallEvent(signal));
        return new TriggerSetMediator(transition);
    }

    @Override
    public ITriggerSetMediator triggeredBySignal(String signal) {
        transition.setTriggerEvent(new SignalEvent(signal));
        return new TriggerSetMediator(transition);
    }

}
