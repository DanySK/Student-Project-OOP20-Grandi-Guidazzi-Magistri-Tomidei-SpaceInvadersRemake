package controller.monitor;

/**
 * Interface to monitor the status of the {@link GameController}
 */
public interface ControllerMonitor {

	/**
	 * Puts the thread that call this method to wait if the game status is equal to paused
	 */
	public void isGamePaused();

	/**
	 * Returns true if the game status is equal to stopped, otherwise it returns false
	 * 
	 * @return true if the game status is equal to stopped, otherwise it returns false
	 */
	public boolean isGameStopped();

	/**
	 * Returns true if the game status is equal to resumed, otherwise it returns false
	 * 
	 * @return true if the game status is equal to resumed, otherwise it returns false
	 */
	public boolean isGameResumed();

	/**
	 * Set the game status equal to running
	 */
	public void setResume();

}