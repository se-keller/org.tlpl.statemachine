package org.tlpl.statemachine.eventpools;

import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.eventpools.AsynchronousCachedStateMachineEventPool;

public class AsynchronousCachedStateMachineEventPoolTest extends AbstractStateMachineEventPoolTest {

    @Override
    protected IStateMachineEventPool getStateMachineEventPool() {
        return new AsynchronousCachedStateMachineEventPool();
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
