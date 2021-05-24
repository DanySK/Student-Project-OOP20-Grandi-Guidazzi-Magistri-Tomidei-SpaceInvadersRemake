package controller;

public interface GameViewController {

	/**
	 * Start a new game
	 */
	public void startNewGame();

	/**
	 * stop the game
	 */
	public void stop();

	/**
	 * resume the game
	 */
	public void resume();

	/**
	 * restart the game
	 */
	public void restart();

	/**
	 * 
	 */
	public void getView();

}
