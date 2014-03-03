package org.tlpl.statemachine.eventpools;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.IStateMachine;
import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.exceptions.EventPoolException;
import org.tlpl.statemachine.scenarios.statemachines.OneStepToEndStateMachine;


public abstract class AbstractStateMachineEventPoolTest {
    private IStateMachineEventPool eventPool;
    private IStateMachine receiverStateMachine;
    private String stateMachineName;

    @Before
    public void setUp() {

        receiverStateMachine = new OneStepToEndStateMachine();
        stateMachineName = OneStepToEndStateMachine.class.getName();
        eventPool = getStateMachineEventPool();
        eventPool.addStateMachine(receiverStateMachine);

    }

    protected abstract IStateMachineEventPool getStateMachineEventPool();

    @Test
    public void sendSignalEvent_TO_END_receiverInEndState() {
        receiverStateMachine.start();
        eventPool.send(new SignalEvent(stateMachineName + ".TO_END"));
        letTheStateMachineCatchUp();
        Assert.assertTrue(receiverStateMachine.isInEndState());
    }

    @Test
    public void sendCallEvent_TO_END_receiverInEndState() {
        receiverStateMachine.start();
        eventPool.send(new CallEvent(stateMachineName + ".toEnd()"));
        letTheStateMachineCatchUp();
        Assert.assertTrue(receiverStateMachine.isInEndState());
    }

    @Test(expected = EventPoolException.class)
    public void sendCallEvent_noStateMachineName_EventPoolExcpetion() {
        eventPool.send(new CallEvent("toEnd()"));
    }

    @Test(expected = EventPoolException.class)
    public void sendSignalEvent_noStateMachineName_EventPoolExcpetion() {
        eventPool.send(new SignalEvent("TO_END"));
    }

    @Test(expected = EventPoolException.class)
    public void sendSignalEvent_unknownStateMachineName_EventPoolExcpetion() {
        eventPool.send(new SignalEvent("unknown.TO_END"));
    }

    @Test(expected = EventPoolException.class)
    public void sendCallEvent_unknownStateMachineName_EventPoolExcpetion() {
        eventPool.send(new CallEvent("unknown.toEnd()"));
    }

    @Test(expected = EventPoolException.class)
    public void sendCallEvent_unknownCallEvent_EventPoolException() {
        receiverStateMachine.start();
        eventPool.send(new CallEvent(stateMachineName + ".unknown()"));
    }

    protected void letTheStateMachineCatchUp() {
        // do nothing
    }
}
