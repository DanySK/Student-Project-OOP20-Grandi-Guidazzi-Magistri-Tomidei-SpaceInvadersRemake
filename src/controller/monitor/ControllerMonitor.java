package controller.monitor;

/**
 * Interface to monitor the status of the {@link GameController}
 */
public interface ControllerMonitor {

	/**
	 * Set the game status equal to running after a game resume
	 */
	public void setResume();

	/**
	 * Set the game status equal to running
	 */
	public void setStart();
}