package org.tlpl.statemachine.fluent.state.transition.adding;

public interface IEffectAndGuardSetMediator {

    ITransitionAddedMediator transition();

    IAddAnotherTransitionMediator triggerdBySignal(String signal);

    IAddAnotherTransitionMediator triggerdByCall(String signal);

}
