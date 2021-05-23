package controller;

/**
 * Possible state of the {@link GameController}
 */
public enum GameStatus {

	/**
	 * The game loop is running
	 */
	RUNNING,

	/**
	 * The game loop is stopped
	 */
	STOPPED,

	/**
	 * The game loop is paused
	 */
	PAUSED,

	/**
	 * The game loop is resumed
	 */
	RESUMED,

	/**
	 * The game loop is resumed and the game is restarted
	 */
	RESTARTED;
}
