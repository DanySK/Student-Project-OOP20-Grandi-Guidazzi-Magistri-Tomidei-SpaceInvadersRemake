package controller;

import java.util.Set;

import model.entitiesutil.MappedEntity;
import view.game.GameViewImpl;

public interface GameViewController {

	/**
	 * Start a new game
	 */
	public void startNewGame();

	/**
	 * Get the game view
	 * 
	 * @return an Object that represent the game view
	 */
	public GameViewImpl getView();

	/**
	 * Get the entities that are in the level, mapped to fit in the game panel
	 * 
	 * @return a set of mapped entities 
	 */
	public Set<MappedEntity> getLevelEntities();

}
