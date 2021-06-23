package controller;

import java.util.Set;

import model.entitiesutil.MappedEntity;

public interface GameViewController {

	/**
	 * Start a new game
	 */
	public void startNewGame();

	/**
	 * 
	 */
	public void getView();

	/**
	 * Get the entities that are in the level, mapped to fit in the game panel
	 * 
	 * @return a set of mapped entities 
	 */
	public Set<MappedEntity> getLevelEntities();

}
