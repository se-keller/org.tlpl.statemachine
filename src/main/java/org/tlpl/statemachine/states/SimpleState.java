package org.tlpl.statemachine.states;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.behaviors.InterruptableBehavior;
import org.tlpl.statemachine.events.TriggerEvent;
import org.tlpl.statemachine.fluent.state.IFluentState;
import org.tlpl.statemachine.fluent.state.initialisation.IEntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.IWhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.impl.EntrySetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.impl.ExitSetMediator;
import org.tlpl.statemachine.fluent.state.initialisation.impl.WhileInsideSetMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.ITransitionAddedMediator;
import org.tlpl.statemachine.fluent.state.transition.adding.impl.TransitionAddedMediator;
import org.tlpl.statemachine.transitions.Transition;


public class SimpleState implements IState, IFluentState {
    private static final Behavior NO_BEHAVIOR = Behavior.NO_BEHAVIOR;
    private static final InterruptableBehavior INTERRUPTABLE_NO_BEHAVIOR = InterruptableBehavior.INTERRUPTABLE_NO_BEHAVIOR;

    private final String name;
    protected Set<Transition> transitions;
    private final Set<TriggerEvent> deferrabelTriggers;
    private InterruptableBehavior doBehavior;
    private Behavior entryBehavior;
    private Behavior exitBehavior;

    public SimpleState(String name) {
        this.name = name;
        this.transitions = Collections.synchronizedSet(new HashSet<Transition>());
        this.deferrabelTriggers = Collections.synchronizedSet(new HashSet<TriggerEvent>());
        entryBehavior = NO_BEHAVIOR;
        exitBehavior = NO_BEHAVIOR;
        doBehavior = INTERRUPTABLE_NO_BEHAVIOR;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public InterruptableBehavior getDoBehavior() {
        doBehavior.setSenderState(this);
        return doBehavior;
    }

    @Override
    public void setDoBehavior(InterruptableBehavior doBehavior) {
        this.doBehavior = doBehavior;
    }

    @Override
    public Behavior getEntryBehavior() {
        return entryBehavior;
    }

    @Override
    public void setEntryBehavior(Behavior entryBehavior) {
        this.entryBehavior = entryBehavior;
    }

    @Override
    public void setExitBehavior(Behavior exitBehavior) {
        this.exitBehavior = exitBehavior;
    }

    @Override
    public Behavior getExitBehavior() {
        return exitBehavior;
    }

    @Override
    public void addTransition(Transition transition) {
        transition.setSourceState(this);
        transitions.add(transition);
    }

    @Override
    public void addDeferrableTrigger(TriggerEvent deferrableTriggerEvent) {
        this.deferrabelTriggers.add(deferrableTriggerEvent);
    }

    @Override
    public Set<TriggerEvent> getDeferrableTriggers() {
        return Collections.unmodifiableSet(deferrabelTriggers);
    }

    @Override
    public Set<Transition> getTransitions() {
        return Collections.unmodifiableSet(transitions);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SimpleState other = (SimpleState) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else
            if (!name.equals(other.name)) {
                return false;
            }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void fireStateEntered(Transition fromTransition) {
        // do nothing
    }

    // BEGIN FLUENT API

    @Override
    public IEntrySetMediator onEntry(Behavior entryBehavior) {
        setEntryBehavior(entryBehavior);
        return new EntrySetMediator(this);
    }

    @Override
    public IExitSetMediator onExit(Behavior exitBehavior) {
        setExitBehavior(exitBehavior);
        return new ExitSetMediator(this);
    }

    @Override
    public ITransitionAddedMediator transition() {
        return new TransitionAddedMediator(this);
    }

    @Override
    public IWhileInsideSetMediator whileInside(InterruptableBehavior doBehavior) {
        setDoBehavior(doBehavior);
        return new WhileInsideSetMediator(this);
    }

    // END FLUENT API
}
