package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardAndEffectSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardAndTriggerSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class GuardSetMediator extends AbstractTransitionMediator implements IGuardSetMediator {

    public GuardSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IGuardAndEffectSetMediator causingEffect(Behavior effect) {
        transition.setEffect(effect);
        return new GuardAndEffectSetMediator(transition);
    }

    @Override
    public IGuardAndTriggerSetMediator triggeredByCall(String signal) {
        transition.setTriggerEvent(new CallEvent(signal));
        return new GuardAndTriggerSetMediator(transition);
    }

    @Override
    public IGuardAndTriggerSetMediator triggeredBySignal(String signal) {
        transition.setTriggerEvent(new SignalEvent(signal));
        return new GuardAndTriggerSetMediator(transition);
    }

}
