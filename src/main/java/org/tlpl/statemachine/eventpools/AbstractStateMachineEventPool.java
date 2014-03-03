package org.tlpl.statemachine.eventpools;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.tlpl.statemachine.IStateMachine;
import org.tlpl.statemachine.IStateMachineEventPool;
import org.tlpl.statemachine.events.CallEvent;
import org.tlpl.statemachine.events.SignalEvent;
import org.tlpl.statemachine.exceptions.EventPoolException;


public abstract class AbstractStateMachineEventPool implements IStateMachineEventPool {
    protected final Map<String, IStateMachine> stateMachines;

    public AbstractStateMachineEventPool(IStateMachine... stateMachines) {
        this.stateMachines = Collections.synchronizedMap(new HashMap<String, IStateMachine>());
        for (IStateMachine stateMachine : stateMachines) {
            addStateMachine(stateMachine);
        }
    }

    @Override
    public void addStateMachine(IStateMachine stateMachine) {
        stateMachines.put(stateMachine.getName(), stateMachine);
    }

    @Override
    public void send(CallEvent callEvent) {

        String stateMachineName = extractStateMachineName(callEvent.toString());
        String methodName = extractMethodName(callEvent.toString());
        IStateMachine stateMachine = stateMachines.get(stateMachineName);
        callMethodOnStateMachineToOverride(methodName, stateMachine);

    }

    protected abstract void callMethodOnStateMachineToOverride(String methodName,
            IStateMachine stateMachine);

    protected void callMethodOnStateMachine(String methodName, IStateMachine stateMachine) {
        try {
            stateMachine.getClass().getMethod(methodName).invoke(stateMachine);
        } catch (Exception cause) {
            throw new EventPoolException(String.format(
                    "Unknown call-event: The state-machine '%s' has no method called '%s'",
                    stateMachine, methodName), cause);
        }
    }

    @Override
    public void send(SignalEvent signalEvent) {
        String stateMachineName = extractStateMachineName(signalEvent.toString());
        String signalName = extractMethodName(signalEvent.toString());
        sendSignalToStateMachineToOverride(stateMachineName, signalName);
    }

    protected abstract void sendSignalToStateMachineToOverride(String stateMachineName,
            String signalName);

    protected void sendSignalToStateMachine(String stateMachineName, String signalName) {
        stateMachines.get(stateMachineName).send(new SignalEvent(signalName));
    }

    protected String extractMethodName(String string) {
        return string.substring(string.lastIndexOf(".") + 1).replace("()", "");
    }

    protected String extractStateMachineName(String string) {
        if (!string.contains(".")) {
            throw new EventPoolException(
                    String
                            .format(
                                    "The call '%s' has no state-machine name. Call should look like this '<STATE_MACHINE_NAME>.<METHOD_NAME>'",
                                    string));
        }
        String stateMachineName = string.substring(0, string.lastIndexOf("."));
        if (!stateMachines.containsKey(stateMachineName)) {
            throw new EventPoolException(String.format(
                    "The state-machine '%s' is unknown in the event pool '%s'", stateMachineName,
                    this));
        }
        return stateMachineName;
    }
}
