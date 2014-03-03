package org.tlpl.statemachine.statemachines;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.IState;
import org.tlpl.statemachine.IStateMachine;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.exceptions.StateMachineException;
import org.tlpl.statemachine.statemachines.EmptyStateMachine;
import org.tlpl.statemachine.states.SimpleState;
import org.tlpl.statemachine.states.pseudo.Fork;
import org.tlpl.statemachine.states.pseudo.Join;
import org.tlpl.statemachine.transitions.Transition;


public class StateMachineTest {
    private static final SignalEvent TEST_SIGNAL = new SignalEvent("TEST_SIGNAL");
    private static final SignalEvent UNKNOWN_SIGNAL = new SignalEvent("UNKNOWN_SIGNAL");
    private IState firstState;
    private IState secondState;
    private IState thirdState;
    private IStateMachine stateMachine;

    @Before
    public void setUp() {
        this.firstState = new SimpleState("First");
        this.secondState = new SimpleState("Second");
        this.thirdState = new SimpleState("Third");

        this.stateMachine = new EmptyStateMachine("TestMachine", firstState);
    }

    @Test
    public void oneState_noTrigger_isInEndState() {
        firstState.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test
    public void twoStates_noTriggers_isInEndState() {
        firstState.addTransition(new Transition(secondState));
        secondState.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test
    public void oneState_oneTriggers_triggerSent_isInEndState() {
        firstState.addTransition(new Transition(TEST_SIGNAL, stateMachine.getEndState()));
        secondState.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        stateMachine.send(TEST_SIGNAL);
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test
    public void oneState_oneTriggers_noTriggerSent_staysInState() {
        firstState.addTransition(new Transition(TEST_SIGNAL, stateMachine.getEndState()));
        secondState.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine
                .isInState(firstState));
    }

    @Test
    public void oneState_oneTriggers_unknownTriggerSent_staysInState() {
        firstState.addTransition(new Transition(TEST_SIGNAL, stateMachine.getEndState()));
        secondState.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        stateMachine.send(UNKNOWN_SIGNAL);
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine
                .isInState(firstState));
    }

    @Test
    public void threeStates_ForkedAndJoined_noTriggers_isInEndState() {
        Fork fork = new Fork();
        Join join = new Join();
        firstState.addTransition(new Transition(fork));
        fork.addTransition(new Transition(secondState));
        fork.addTransition(new Transition(thirdState));
        secondState.addTransition(new Transition(join));
        thirdState.addTransition(new Transition(join));
        join.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test
    public void threeStates_ForkedAndJoined_oneTrigger_oneFallThrough_noTriggerSent_isNotInEndState() {
        Fork fork = new Fork();
        Join join = new Join();
        firstState.addTransition(new Transition(fork));
        fork.addTransition(new Transition(secondState));
        fork.addTransition(new Transition(thirdState));
        secondState.addTransition(new Transition(join));
        thirdState.addTransition(new Transition(TEST_SIGNAL, join));
        join.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        Assert.assertFalse(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test
    public void threeStates_ForkedAndJoined_oneTrigger_oneFallThrough_triggerSent_isInEndState() {
        Fork fork = new Fork();
        Join join = new Join();
        firstState.addTransition(new Transition(fork));
        fork.addTransition(new Transition(secondState));
        fork.addTransition(new Transition(thirdState));
        secondState.addTransition(new Transition(join));
        thirdState.addTransition(new Transition(TEST_SIGNAL, join));
        join.addTransition(new Transition(stateMachine.getEndState()));
        stateMachine.start();
        stateMachine.send(TEST_SIGNAL);
        Assert.assertTrue(stateMachine.getActualStates().toString(), stateMachine.isInEndState());
    }

    @Test(expected = StateMachineException.class)
    public void isInEndState_noStartCalled_StateMachineException() {
        stateMachine.isInEndState();
    }

    @Test(expected = StateMachineException.class)
    public void getActualStates_noStartCalled_StateMachineException() {
        stateMachine.getActualStates();
    }

    @Test(expected = StateMachineException.class)
    public void send_noStartCalled_StateMachineException() {
        stateMachine.send(UNKNOWN_SIGNAL);
    }

    @Test
    public void defferedTriggerEvent_firstAndSecondStateDefferedAndThirdStatesProcesses_isInEndState() {
        SignalEvent deferrableTrigger = new SignalEvent("defferrable");
        firstState.addDeferrableTrigger(deferrableTrigger);
        secondState.addDeferrableTrigger(deferrableTrigger);

        firstState.addTransition(new Transition(TEST_SIGNAL, secondState));
        secondState.addTransition(new Transition(TEST_SIGNAL, thirdState));
        thirdState.addTransition(new Transition(deferrableTrigger, stateMachine.getEndState()));
        stateMachine.start();
        stateMachine.send(deferrableTrigger);
        // no change
        Assert.assertTrue(stateMachine.isInState(firstState));
        stateMachine.send(TEST_SIGNAL);
        Assert.assertTrue(stateMachine.isInState(secondState));
        stateMachine.send(TEST_SIGNAL);
        // transition to third state and jumping to end state because of deferrable trigger
        Assert.assertTrue("Should be in Endstate not in : " + stateMachine.getActualStates(),
                stateMachine.isInEndState());
    }

    @Test
    public void defferedTriggerEventLost_firstStateDefferedSecondDoesNotDeferAndThirdStatesDefersAgain_isNotInEndState() {
        SignalEvent deferrableTrigger = new SignalEvent("defferrable");
        firstState.addDeferrableTrigger(deferrableTrigger);
        thirdState.addDeferrableTrigger(deferrableTrigger);

        firstState.addTransition(new Transition(TEST_SIGNAL, secondState));
        secondState.addTransition(new Transition(TEST_SIGNAL, thirdState));
        thirdState.addTransition(new Transition(deferrableTrigger, stateMachine.getEndState()));
        stateMachine.start();
        stateMachine.send(deferrableTrigger);
        // no change
        Assert.assertTrue(stateMachine.isInState(firstState));
        stateMachine.send(TEST_SIGNAL);
        Assert.assertTrue(stateMachine.isInState(secondState));
        stateMachine.send(TEST_SIGNAL);
        // transition to third state and jumping to end state because of deferrable trigger
        Assert.assertTrue(stateMachine.isInState(thirdState));
        Assert.assertFalse(stateMachine.isInEndState());
    }
}
