package model.entities;

import java.util.List;
import java.util.Random;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.Bullet;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;


public class BossBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final int BULLET_INITIAL_MU_X = 0;
	private final int BULLET_INITIAL_MU_Y = 0;
	private final int TOT_BULLET_DIRECTION = 3;

	private List<String> bulletStrImgs;
	private EntityDirections direction;

	protected BossBullet(Pair<Integer,Integer> pos, List<String> strImg) {
		this.randomBulletImg(strImg);
		this.create(pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				this.BULLET_INITIAL_MU_Y, this.bulletStrImgs, this.direction, new GraphicsComponentAwt(this.bulletStrImgs),
				new EntityMovementImpl());
	}

	@Override
	protected void updateEntityMovement() {
		switch(this.getDirection()) {
			case DOWN_LEFT:
				this.getMovement().moveDownLeft(this);
				break;
			case DOWN_RIGHT:
				this.getMovement().moveDownRight(this);
				break;
			default:
				this.getMovement().moveDown(this);
				break;
		}
	}

	private void randomBulletImg(List<String> strImg) {
		Random random = new Random();
		switch(random.nextInt(this.TOT_BULLET_DIRECTION)) {
			case 0:
				this.direction = EntityDirections.DOWN;
				this.bulletStrImgs.add(strImg.get(0));
				break;
			case 1:
				this.direction = EntityDirections.DOWN_LEFT;
				this.bulletStrImgs.add(strImg.get(1));
				break;
				
			case 2:
				this.direction = EntityDirections.DOWN_RIGHT;
				this.bulletStrImgs.add(strImg.get(2));
				break;
		}
	}
}
