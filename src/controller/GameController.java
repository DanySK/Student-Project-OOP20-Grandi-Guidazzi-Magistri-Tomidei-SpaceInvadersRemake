package controller;

/**
 * Interface of the game controller
 */
public interface GameController {

	/**
	 * Start a new game loop
	 */
	public void startNewGame();

	/**
	 * Stop the game loop 
	 */
	public void stopGameLoop();

	/**
	 * Return the state of the game loop.
	 * 
	 * @return true if the game loop is running, false otherwise
	 */
	public boolean isRunning();

	/**
	 * Stop the game loop and open the game over window
	 */
	public void gameOver();

	/**
	 * Stop the game loop and open the victory window
	 */
	public void victory();

}
