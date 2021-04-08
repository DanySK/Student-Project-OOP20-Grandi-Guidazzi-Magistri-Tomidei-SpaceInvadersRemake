package model.entities;

import java.util.List;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;


public class BossBullet extends Entity {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final int BULLET_INITIAL_MU_X = 0;
	private final int BULLET_INITIAL_MU_Y = 0;

	private List<String> bulletStrImgs;
	private EntityDirections direction;

	protected BossBullet(Pair<Integer,Integer> pos, List<String> strImg) {
		this.create(pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				this.BULLET_INITIAL_MU_Y, this.bulletStrImgs, new GraphicsComponentAwt(this.bulletStrImgs),
				new EntityMovementImpl());
	}

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
