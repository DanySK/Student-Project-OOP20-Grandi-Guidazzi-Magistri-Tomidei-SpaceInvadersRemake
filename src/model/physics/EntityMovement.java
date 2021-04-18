package model.physics;

import model.entitiesutil.Entity;

/**
 * Interface that represent {@link Entity}'s movements
 */
public interface EntityMovement {

	/**
	 * Method that move the {@link Entity} to the left
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveLeft(Entity e);

	/**
	 * Method that move the {@link Entity} to the right
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveRight(Entity e);

	/**
	 * Method that move the {@link Entity} up
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveUp(Entity e);

	/**
	 * Method that move the {@link Entity} down
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveDown(Entity e);

	/**
	 * Method that move the {@link Entity} to the bottom left
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveBottomLeft(Entity e);

	/**
	 * Method that move the {@link Entity} to the bottom right
	 * 
	 * @param e	is the {@link Entity} that needs to be moved
	 */
	public void moveBottomRight(Entity e);


}
