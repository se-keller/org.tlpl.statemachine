package org.tlpl.statemachine.behaviors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.IStateMachine;
import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.eventpools.SynchronousStateMachineEventPool;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.scenarios.statemachines.OneStepToEndStateMachineWithBlinkDoBehavior;


public class InterruptableThreadBehaviorTest {
    private IStateMachineEventPool eventPool;
    private IStateMachine receiverStateMachine;
    private String stateMachineName;

    @Before
    public void setUp() {

        receiverStateMachine = new OneStepToEndStateMachineWithBlinkDoBehavior();
        stateMachineName = OneStepToEndStateMachineWithBlinkDoBehavior.class.getName();
        eventPool = new SynchronousStateMachineEventPool(receiverStateMachine);

    }

    @Test
    public void sendSignalEvent_TO_END_receiverInEndState() {
        receiverStateMachine.start();
        letTheStateMachineCatchUp();
        eventPool.send(new SignalEvent(stateMachineName + ".TO_END"));
        Assert.assertTrue(receiverStateMachine.isInEndState());
    }

    private void letTheStateMachineCatchUp() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException cause) {
            throw new RuntimeException(cause);
        }
    }

}
