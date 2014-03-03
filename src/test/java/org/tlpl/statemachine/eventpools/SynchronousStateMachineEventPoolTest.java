package org.tlpl.statemachine.eventpools;

import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.eventpools.SynchronousStateMachineEventPool;

public class SynchronousStateMachineEventPoolTest extends AbstractStateMachineEventPoolTest {
    @Override
    protected IStateMachineEventPool getStateMachineEventPool() {
        return new SynchronousStateMachineEventPool();
    }

}
