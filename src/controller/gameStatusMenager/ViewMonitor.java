package controller.gameStatusMenager;

import controller.GameStatus;

/**
 * Interface for setting the {@link GameStatus}
 */
public interface ViewMonitor {

	/**
	 * pause the game loop if the game is running
	 */
	public void pause();

	/**
	 * resume the game loop if the game is paused
	 */
	public void resume();

	/**
	 * restart the game loop if the game is paused
	 */
	public void restart();

	/**
	 * stop the game loop
	 */
	public void stop();

}