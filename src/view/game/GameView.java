package view.game;

import java.util.List;
import java.util.Set;

import model.entitiesutil.MappedEntity;

public interface GameView {

	/**
	 * 
	 * @return
	 */
	List<GameEvent> getEvents();

	/**
	 * 
	 * @param updates
	 */
	public void updateGui(Set<MappedEntity> updates);

	/**
	 * 
	 */
	public void openGameOver();

	/**
	 * 
	 */
	public void openVictoryScene();

	/**
	 * 
	 * @return
	 */
	public int getWidth();

	/**
	 * 
	 * @return
	 */
	public int getHeight();

}