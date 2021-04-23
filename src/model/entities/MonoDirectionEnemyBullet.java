package model.entities;

import java.util.List;
import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.Bullet;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with a single direction
 */
public class MonoDirectionEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_INITIAL_MU_X = 0;
	private final double BULLET_MAX_MU_Y = 0;

	private List<String> bulletStrImgs;

	/**
	 * {@link Bullet} with a single direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param strImg	are the images's paths of the {@link Bullet} 
	 * @param type		is the {@link BulletType}
	 */
	protected MonoDirectionEnemyBullet(Pair<Integer,Integer> pos, List<String> strImg) {
		Random random = new Random();
		this.randomBulletImg(strImg);
		this.create(EntityType.ENEMY_BULLET, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				(random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), this.bulletStrImgs, EntityDirections.DOWN, new EntityGraphicsImpl(this.bulletStrImgs),
				new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void updateEntityPos() {
		this.getMovementImpl().moveDown(this);
	}

	/**
	 * Method that select a random image's path from an input list
	 * 
	 * @param strImg is the list that the method takes as an input
	 */
	private void randomBulletImg(List<String> strImg) {
		Random random = new Random();
		switch(random.nextInt(strImg.size())) {
			case 1:
				this.bulletStrImgs.add(strImg.get(1));
				break;
			case 2:
				this.bulletStrImgs.add(strImg.get(2));
				break;
			default:
				this.bulletStrImgs.add(strImg.get(0));
				break;
		}
	}
}
