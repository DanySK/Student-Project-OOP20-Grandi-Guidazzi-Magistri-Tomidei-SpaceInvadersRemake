package model.entities;

import java.util.List;
import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.Bullet;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with multiple direction
 */
public class MultiDirectionsEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final int BULLET_INITIAL_MU_X = 0;
	private final int BULLET_MAX_MU_Y = 0;

	private List<String> bulletStrImgs;
	private EntityDirections direction;


	/**
	 * {@link Bullet} with multiple direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param strImg	are the images's paths of the {@link Bullet} 
	 */
	protected MultiDirectionsEnemyBullet(Pair<Integer,Integer> pos, List<String> strImg) {
		Random random = new Random();
		this.randomBulletImg(strImg);
		this.create(EntityType.ENEMY_BULLET, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				(random.nextInt(this.BULLET_MAX_MU_Y) + 1), this.bulletStrImgs, this.direction, new EntityGraphicsImpl(this.bulletStrImgs),
				new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		switch(this.getDirection()) {
			case DOWN_LEFT:
				this.getMovementImpl().moveBottomLeft(this);
				break;
			case DOWN_RIGHT:
				this.getMovementImpl().moveBottomRight(this);
				break;
			default:
				this.getMovementImpl().moveDown(this);
				break;
		}
	}

	/**
	 * Method that select a random image's path from an input list,
	 * and change the {@link Bullet} direction
	 * 
	 * @param strImg
	 */
	private void randomBulletImg(List<String> strImg) {
		Random random = new Random();
		switch(random.nextInt(strImg.size())) {
			case 1:
				this.direction = EntityDirections.DOWN_LEFT;
				this.bulletStrImgs.add(strImg.get(1));
				break;

			case 2:
				this.direction = EntityDirections.DOWN_RIGHT;
				this.bulletStrImgs.add(strImg.get(2));
				break;

			default:
				this.direction = EntityDirections.DOWN;
				this.bulletStrImgs.add(strImg.get(0));
				break;
		}
	}
}
