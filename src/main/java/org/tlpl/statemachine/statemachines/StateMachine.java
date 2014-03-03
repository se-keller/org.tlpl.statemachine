package org.tlpl.statemachine.statemachines;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.IStateMachine;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.events.TriggerEvent;
import org.tlpl.statemachine.exceptions.StateMachineException;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.transitions.Transition;

public abstract class StateMachine implements IStateMachine {

	private static final Logger LOG = Logger.getLogger(StateMachine.class
			.getCanonicalName());
	private final String name;
	private final SimpleState endState;
	private final Set<IState> currentStates;
	private final Set<TriggerEvent> actualDefferableTriggerEvents;
	private boolean isStarted;

	public StateMachine(String name) {
		this.name = name;
		this.endState = new SimpleState(name + "-EndState");
		currentStates = Collections.synchronizedSet(new HashSet<IState>());
		actualDefferableTriggerEvents = Collections
				.synchronizedSet(new HashSet<TriggerEvent>());
	}

	@Override
	public Set<IState> getActualStates() {
		checkIfTheStateMachineIsStarted();
		return Collections.unmodifiableSet(currentStates);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isInEndState() {
		checkIfTheStateMachineIsStarted();
		return currentStates.contains(endState);
	}

	@Override
	public void reset() {
		for (IState state : currentStates) {
			state.getDoBehavior().interrupt();
		}
		currentStates.clear();
		currentStates.add(getInitialState());
		isStarted = false;
	}

	@Override
	public void send(SignalEvent signal) {
		processTrigger(signal);
		processNewDeferrableTriggers();
	}

	private void processNewDeferrableTriggers() {
		Set<TriggerEvent> lastDeferrableTriggerEvents = Collections
				.synchronizedSet(new HashSet<TriggerEvent>());
		lastDeferrableTriggerEvents.addAll(actualDefferableTriggerEvents);
		for (TriggerEvent triggerEvent : lastDeferrableTriggerEvents) {
			actualDefferableTriggerEvents.remove(triggerEvent);
			processTrigger(triggerEvent);
		}
	}

	private void processTrigger(TriggerEvent triggerEvent) {
		checkIfTheStateMachineIsStarted();
		Set<Transition> transitionsWithTrueGuardAndTriggerEvent = getTransitionsWithTrueGuardAndTriggerEvent(triggerEvent);
		for (Transition transition : transitionsWithTrueGuardAndTriggerEvent) {
			followTransition(transition);
		}
	}

	private void followTransition(Transition transition) {
		IState sourceState = transition.getSourceState();
		IState targetState = transition.getTargetState();

		sourceState.getDoBehavior().interrupt();
		sourceState.getExitBehavior().execute();

		currentStates.remove(sourceState);
		currentStates.add(targetState);
		LOG.info(name + ": " + transition.toString());
		// TODO not so nice, is it? Workaround for Join
		targetState.fireStateEntered(transition);

		targetState.getEntryBehavior().execute();
		targetState.getDoBehavior().setSignalEventReceiver(this);
		targetState.getDoBehavior().start();

		// TODO execute event at the end?
		transition.getEffect().execute();

		// TODO sematics if is in end-state end-state only?
		if (isInEndState()) {
			currentStates.clear();
			currentStates.add(endState);
		}

	}

	private void checkIfTheStateMachineIsStarted() {
		if (!isStarted) {
			throw new StateMachineException(
					String.format(
							"state-machine '%s' hasn't been started. Call the start-method first.",
							this.name));
		}
	}

	private Set<Transition> getTransitionsWithTrueGuardAndTriggerEvent(
			TriggerEvent triggerEvent) {
		Set<Transition> transitionsWithTrueGuardAndTriggerEvent = new HashSet<Transition>();
		for (IState state : currentStates) {
			if (isDeffered(triggerEvent, state)) {
				actualDefferableTriggerEvents.add(triggerEvent);
			} else {
				addAllTrasitionsWithTrueGuardAndTriggerEventToTrasitionSet(
						triggerEvent, state,
						transitionsWithTrueGuardAndTriggerEvent);
			}
		}
		return transitionsWithTrueGuardAndTriggerEvent;
	}

	private void addAllTrasitionsWithTrueGuardAndTriggerEventToTrasitionSet(
			TriggerEvent triggerEvent, IState state,
			Set<Transition> transitionsWithTrueGuardAndTriggerEvent) {
		for (Transition transtion : state.getTransitions()) {
			if (transtion.getTriggerEvent().equals(triggerEvent)
					&& transtion.getGuard().verify()) {
				transitionsWithTrueGuardAndTriggerEvent.add(transtion);
			}
		}
	}

	private boolean isDeffered(TriggerEvent triggerEvent, IState state) {
		return state.getDeferrableTriggers().contains(triggerEvent);
	}

	@Override
	public void start() {
		reset();
		isStarted = true;
		getInitialState().getEntryBehavior().execute();
		getInitialState().getDoBehavior().setSignalEventReceiver(this);
		getInitialState().getDoBehavior().start();
	}

	@Override
	public IState getEndState() {
		return endState;
	}

	@Override
	public boolean isInState(IState state) {
		return currentStates.contains(state);
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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
		StateMachine other = (StateMachine) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	protected abstract IState getInitialState();

}
