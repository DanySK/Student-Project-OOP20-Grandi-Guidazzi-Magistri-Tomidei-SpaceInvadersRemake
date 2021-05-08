package controller.monitor;

import controller.GameStatus;

/**
 * Interface for setting the {@link GameStatus}
 */
public interface ViewMonitor {

	/**
	 * Set the {@link GameStatus} equal to paused
	 */
	public void pause();

	/**
	 * Set the {@link GameStatus} equal to resumed
	 */
	public void resume();

	/**
	 * Set the {@link GameStatus} equal to stopped
	 */
	public void stop();

}