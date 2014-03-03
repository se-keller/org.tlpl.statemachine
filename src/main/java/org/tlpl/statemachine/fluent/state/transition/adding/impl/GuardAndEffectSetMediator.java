package org.tlpl.statemachine.fluent.state.transition.adding.impl;

import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.IGuardAndEffectSetMediator;
import org.tlpl.statemachine.transitions.Transition;

public class GuardAndEffectSetMediator extends AbstractTransitionMediator implements
        IGuardAndEffectSetMediator {

    public GuardAndEffectSetMediator(Transition transition) {
        super(transition);
    }

    @Override
    public IAddAnotherTransitionMediator triggeredByCall(String signal) {
        transition.setTriggerEvent(new CallEvent(signal));
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

    @Override
    public IAddAnotherTransitionMediator triggeredBySignal(String signal) {
        transition.setTriggerEvent(new SignalEvent(signal));
        return new AddAnotherTransitionMediator(transition.getSourceState());
    }

}
