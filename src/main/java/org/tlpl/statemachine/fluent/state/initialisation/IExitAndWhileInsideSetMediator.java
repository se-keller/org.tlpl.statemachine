package org.tlpl.statemachine.fluent.state.initialisation;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.fluent.state.transition.adding.IAddAnotherTransitionMediator;

public interface IExitAndWhileInsideSetMediator {

    IAddAnotherTransitionMediator onEntry(Behavior entryBehavior);

}
