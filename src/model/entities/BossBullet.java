package model.entities;

import model.entitiesutil.EntityDirections;

public class BossBullet extends Entity {

	private EntityDirections direction;

	@Override
	protected void updateEntityMovement() {
		switch(this.direction) {
			case DOWN_LEFT:
				this.getMove().moveDownLeft(this);
				break;
			case DOWN_RIGHT:
				this.getMove().moveDownRight(this);
				break;
			default:
				this.getMove().moveDown(this);
				break;
		}
	}

}
