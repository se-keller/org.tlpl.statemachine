package org.tlpl.statemachine.fluent.state.transition.adding;

import org.tlpl.statemachine.fluent.state.IFluentState;

public interface ITransitionAddedMediator {

    ITransitionAndStateSetMediator to(IFluentState state);

}
