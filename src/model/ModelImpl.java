package model;

import java.util.List;
import java.util.Set;
import controller.GameController;
import model.entities.Alien;
import model.entitiesutil.MappedEntity;
import model.entitiesutil.typeentities.GenericEntity;

/**
 * {@link Model} implementation
 *
 */
public class ModelImpl implements Model {

	private final GameController controller;
	private final World gameWorld;
	
	private final int LAST_LEVEL = 6;
	private final int FIRST_LEVEL = 1;
	
	private int lvlNum;

	/**
	 * {@link Model} implementation
	 *
	 */
	public ModelImpl(GameController controller) {
		this.controller = controller;
		this.gameWorld = new WorldImpl(this);
		this.lvlNum =  this.FIRST_LEVEL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void nextLevel() {
		this.gameWorld.startNextLevel(this.lvlNum++);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Alien> getAlienList() {
		return this.gameWorld.getAlienList();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<MappedEntity> getMappedEntities(){
		return this.gameWorld.getMappedEntities();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityLevel(int cycles) {
		this.gameWorld.updateEntityLevel(cycles);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GameController getController() {
		return this.controller;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<GenericEntity> getNewEntities() {
		return this.gameWorld.getNewEntities();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMaxWorldWidth() {
		return this.gameWorld.getMaxWorldWidth();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMaxWorldHeight() {
		return this.gameWorld.getMaxWorldHeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMinWorldWidth() {
		return this.gameWorld.getMinWorldWidth();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMinWorldHeight() {
		return this.gameWorld.getMinWorldHeight();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public World getWorld() {
		return this.gameWorld;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getScore() {
		return this.gameWorld.getScore();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void processGameOver() {
		this.controller.gameOver();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasNextLevel(){
		return this.lvlNum <= this.LAST_LEVEL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void restartGame() {
		this.lvlNum = FIRST_LEVEL;
		this.restartGame();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLevelNum() {
		return this.lvlNum-1;
	}
	
	
}
