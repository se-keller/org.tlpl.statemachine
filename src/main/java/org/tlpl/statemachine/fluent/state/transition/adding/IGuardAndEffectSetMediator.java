package org.tlpl.statemachine.fluent.state.transition.adding;

public interface IGuardAndEffectSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator triggeredBySignal(String signal);

    IAddAnotherTransitionMediator triggeredByCall(String signal);

}
