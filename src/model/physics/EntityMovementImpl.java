package model.physics;

import model.entitiesutil.Entity;

/**
 * Class that implements {@link Entity}'s movements
 */
public class EntityMovementImpl implements EntityMovement{

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveLeft(Entity e) {
		e.setX(e.getX() - e.getMuX());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveRight(Entity e) {
		e.setX(e.getX() + e.getMuX());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveUp(Entity e) {
		e.setY(e.getY() - e.getMuY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveDown(Entity e) {
		e.setY(e.getY() + e.getMuY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveBottomLeft(Entity e) {
		e.setY(e.getY() + e.getMuY());
		e.setX(e.getX() - e.getMuX());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void moveBottomRight(Entity e) {
		e.setY(e.getY() + e.getMuY());
		e.setX(e.getX() + e.getMuX());		
	}

}
