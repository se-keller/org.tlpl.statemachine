package org.tlpl.statemachine;

import java.util.Set;

import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.events.TriggerEvent;
import org.tlpl.statemachine.transitions.Transition;


public interface IState {
    String getName();

    void addTransition(Transition transition);

    void setEntryBehavior(Behavior entryBehavior);

    void setDoBehavior(InterruptableBehavior doBehavior);

    void setExitBehavior(Behavior exitBehavior);

    void addDeferrableTrigger(TriggerEvent deferrableTrigger);

    Set<TriggerEvent> getDeferrableTriggers();

    Set<Transition> getTransitions();

    Behavior getEntryBehavior();

    InterruptableBehavior getDoBehavior();

    Behavior getExitBehavior();

    void fireStateEntered(Transition fromTransition);
}
