package org.tlpl.statemachine.eventpools;

import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.eventpools.AsynchronousFixedStateMachineEventPool;

public class AsynchronousFixedStateMachineEventPoolTest extends AbstractStateMachineEventPoolTest {

    @Override
    protected IStateMachineEventPool getStateMachineEventPool() {
        return new AsynchronousFixedStateMachineEventPool(10);
    }

    @Override
    protected void letTheStateMachineCatchUp() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException cause) {
            throw new RuntimeException(cause);
        }
    }
}
