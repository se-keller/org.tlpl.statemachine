package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IEffectAndGuardSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class EffectAndGuardSetMediator extends AbstractTransitionMediator implements
        IEffectAndGuardSetMediator {

    public EffectAndGuardSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IAddAnotherTransitionMediator triggerdByCall(String signal) {
        transition.setTriggerEvent(new CallEvent(signal));
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

    @Override
    public IAddAnotherTransitionMediator triggerdBySignal(String signal) {
        transition.setTriggerEvent(new SignalEvent(signal));
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

}
