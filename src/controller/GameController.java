package controller;

import java.util.Set;

import model.entitiesutil.MappedEntity;

/**
 * Interface of the game controller
 */
public interface GameController {

	/**
	 * Return the state of the game loop.
	 * 
	 * @return true if the game loop is running, false otherwise
	 */
	public boolean isRunning();

	/**
	 * Return if the player win.
	 * 
	 * @return true if the player win, false otherwise
	 */
	public boolean gameOver();

	public int getWindowWidth();

	public int getWindowHeight();

	public Set<MappedEntity> getEntitiesLevel();

	/**
	 * 
	 */
	public void stop();

}
