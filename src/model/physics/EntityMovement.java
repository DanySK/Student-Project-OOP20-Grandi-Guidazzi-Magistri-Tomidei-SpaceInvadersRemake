package model.physics;

import model.entities.Entity;

public interface EntityMovement {

	public void moveLeft(Entity e);

	public void moveRight(Entity e);

	public void moveUp(Entity e);

	public void moveDown(Entity e);

}
