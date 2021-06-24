package controller;

import java.util.Set;

import controller.gameStatusManager.ViewGameStatusManager;
import model.entitiesutil.MappedEntity;
import view.game.GameView;

public interface ViewGameController {

	/**
	 * Start a new game
	 */
	public void startNewGame();

	/**
	 * Get the game view
	 * 
	 * @return an Object that represent the game view
	 */
	public GameView getView();

	/**
	 * Get the entities that are in the level, mapped to fit in the game panel
	 * 
	 * @return a set of mapped entities 
	 */
	public Set<MappedEntity> getLevelEntities();

	/**
	 * Get the object that manage the game status
	 * 
	 * @return
	 */
	public ViewGameStatusManager getViewStatusManager();

}
