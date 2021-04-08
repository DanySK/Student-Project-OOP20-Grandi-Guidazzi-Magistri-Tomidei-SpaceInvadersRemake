package model.physics;

import model.entities.Entity;

public class EntityMovementImpl implements EntityMovement{

	@Override
	public void moveLeft(Entity e) {
		e.setX(e.getX() - e.getMuX());
	}

	@Override
	public void moveRight(Entity e) {
		e.setX(e.getX() + e.getMuX());
	}

	@Override
	public void moveUp(Entity e) {
		e.setY(e.getY() - e.getMuY());
	}

	@Override
	public void moveDown(Entity e) {
		e.setY(e.getY() + e.getMuY());
	}

	@Override
	public void moveDownLeft(Entity e) {
		e.setY(e.getY() + e.getMuY());
		e.setX(e.getX() - e.getMuX());
	}

	@Override
	public void moveDownRight(Entity e) {
		e.setY(e.getY() + e.getMuY());
		e.setX(e.getX() + e.getMuX());		
	}
	
}
