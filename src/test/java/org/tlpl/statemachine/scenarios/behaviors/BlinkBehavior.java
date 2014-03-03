package org.tlpl.statemachine.scenarios.behaviors;

import java.util.logging.Logger;

import org.tlpl.statemachine.behaviors.InfiniteInterruptableThreadBehavior;

public class BlinkBehavior extends InfiniteInterruptableThreadBehavior {
	private static final Logger LOG = Logger.getLogger(BlinkBehavior.class
			.getCanonicalName());

	@Override
	protected void executeInfinitTillInterrupted() {
		LOG.info("Blink");
		waitABit();
	}

	private void waitABit() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException cause) {
			throw new RuntimeException(cause);
		}
	}

}
