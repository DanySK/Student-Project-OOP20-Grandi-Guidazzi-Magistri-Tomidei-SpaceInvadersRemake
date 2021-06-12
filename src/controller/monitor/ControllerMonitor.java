package controller.monitor;

import controller.GameStatus;

/**
 * Interface to monitor the status of the {@link GameController}
 */
public interface ControllerMonitor {

	/**
	 * Set the {@link GameStatus} equal to stopped
	 */
	public void stop();

	/**
	 * Puts the thread that call this method to wait if the game status is equal to paused
	 */
	public void isGamePaused();

	/**
	 * 
	 * 
	 * @return
	 */
	public GameStatus getGameStatus();

	/**
	 * Set the game status equal to running after a game resume
	 */
	public void setResume();

	/**
	 * Set the game status equal to running
	 */
	public void setStart();

}