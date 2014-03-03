package org.tlpl.statemachine.transitions;

import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.behaviors.Behavior;
import org.tlpl.statemachine.constraints.Constraint;
import org.tlpl.statemachine.events.CompletionEvent;
import org.tlpl.statemachine.events.TriggerEvent;
import org.tlpl.statemachine.states.pseudo.Join;

public class Transition {

	private static final Behavior NO_EFFECT = Behavior.NO_BEHAVIOR;
	private static final Constraint NO_GUARD = Constraint.TRUE_CONSTRAINT;

	private TriggerEvent triggerEvent;
	private Constraint guard;
	private Behavior effect;
	private IState targetState;
	private IState sourceState;

	public Transition(TriggerEvent triggerEvent, Constraint guard,
			Behavior effect, IState targetState) {
		this.triggerEvent = triggerEvent;
		this.guard = guard;
		this.effect = effect;
		this.targetState = targetState;
	}

	public Transition(TriggerEvent triggerEvent, Constraint guard,
			Behavior effect, Join join) {
		this(triggerEvent, guard, effect, (IState) join);
		join.addWaitForTransition(this);
	}

	public Transition(TriggerEvent triggerEvent, IState targetState) {
		this(triggerEvent, NO_GUARD, NO_EFFECT, targetState);
	}

	public Transition(IState targetState) {
		this(new CompletionEvent(), NO_GUARD, NO_EFFECT, targetState);
	}

	public Transition(Constraint guard, IState targetState) {
		this(new CompletionEvent(), guard, NO_EFFECT, targetState);
	}

	public Transition(Constraint guard, Behavior effect, IState targetState) {
		this(new CompletionEvent(), guard, effect, targetState);
	}

	public Transition(Behavior effect, IState targetState) {
		this(new CompletionEvent(), NO_GUARD, effect, targetState);
	}

	public Transition(TriggerEvent triggerEvent, Constraint guard,
			IState targetState) {
		this(triggerEvent, guard, NO_EFFECT, targetState);
	}

	public Transition(TriggerEvent triggerEvent, Behavior effect,
			IState targetState) {
		this(triggerEvent, NO_GUARD, effect, targetState);
	}

	public Transition(TriggerEvent triggerEvent, Join join) {
		this(triggerEvent, NO_GUARD, NO_EFFECT, join);
	}

	public Transition(Join join) {
		this(new CompletionEvent(), NO_GUARD, NO_EFFECT, join);
	}

	public Transition(Constraint guard, Join join) {
		this(new CompletionEvent(), guard, NO_EFFECT, join);
	}

	public Transition(Constraint guard, Behavior effect, Join join) {
		this(new CompletionEvent(), guard, effect, join);
	}

	public Transition(Behavior effect, Join join) {
		this(new CompletionEvent(), NO_GUARD, effect, join);
	}

	public Transition(TriggerEvent triggerEvent, Constraint guard, Join join) {
		this(triggerEvent, guard, NO_EFFECT, join);
	}

	public Transition(TriggerEvent triggerEvent, Behavior effect, Join join) {
		this(triggerEvent, NO_GUARD, effect, join);
	}

	public Behavior getEffect() {
		return effect;
	}

	public void setEffect(Behavior effect) {
		this.effect = effect;
	}

	public Constraint getGuard() {
		return guard;
	}

	public void setGuard(Constraint guard) {
		this.guard = guard;
	}

	public TriggerEvent getTriggerEvent() {
		return triggerEvent;
	}

	public void setTriggerEvent(TriggerEvent triggerEvent) {
		this.triggerEvent = triggerEvent;
	}

	public IState getTargetState() {
		return targetState;
	}

	public void setTargetState(IState targetState) {
		this.targetState = targetState;
	}

	public void setTargetState(Join join) {
		setTargetState((IState) join);
		join.addWaitForTransition(this);
	}

	public boolean hasTriggerEvent(TriggerEvent triggerEvent) {
		return getTriggerEvent().equals(triggerEvent);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((effect == null) ? 0 : effect.hashCode());
		result = prime * result + ((guard == null) ? 0 : guard.hashCode());
		result = prime * result
				+ ((sourceState == null) ? 0 : sourceState.hashCode());
		result = prime * result
				+ ((targetState == null) ? 0 : targetState.hashCode());
		result = prime * result
				+ ((triggerEvent == null) ? 0 : triggerEvent.hashCode());
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
		Transition other = (Transition) obj;
		if (effect == null) {
			if (other.effect != null) {
				return false;
			}
		} else if (!effect.equals(other.effect)) {
			return false;
		}
		if (guard == null) {
			if (other.guard != null) {
				return false;
			}
		} else if (!guard.equals(other.guard)) {
			return false;
		}
		if (sourceState == null) {
			if (other.sourceState != null) {
				return false;
			}
		} else if (!sourceState.equals(other.sourceState)) {
			return false;
		}
		if (targetState == null) {
			if (other.targetState != null) {
				return false;
			}
		} else if (!targetState.equals(other.targetState)) {
			return false;
		}
		if (triggerEvent == null) {
			if (other.triggerEvent != null) {
				return false;
			}
		} else if (!triggerEvent.equals(other.triggerEvent)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(sourceState);
		builder.append(" --- ");
		builder.append("{");
		if (!triggerEvent.isCompletionEvent()) {
			builder.append(triggerEvent);
		}
		builder.append(" /");
		if (!guard.equals(NO_GUARD)) {
			builder.append(" [");
			builder.append(guard);
			builder.append("] ");
		}

		if (!effect.equals(NO_EFFECT)) {
			builder.append(" ");
			builder.append(effect);
		}

		builder.append(" } ---> ");
		builder.append(targetState);

		return builder.toString();
	}

	public void setSourceState(IState sourceState) {
		this.sourceState = sourceState;
		if (triggerEvent.isCompletionEvent()) {
			((CompletionEvent) triggerEvent).setSenderState(sourceState);
		}
	}

	public IState getSourceState() {
		return sourceState;
	}

}
