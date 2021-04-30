package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.Entity.EntityType;
import model.entitiesutil.Bullet;
import model.entitiesutil.Entity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with a single direction
 */
public class MonoDirectionEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_MAX_MU_Y = 0;
	private List<String> strImgs;
	private Random random;

	/**
	 * {@link Bullet} with a single direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param strImg	are the images's paths of the {@link Bullet} 
	 * @param type		is the {@link BulletType}
	 */
	protected MonoDirectionEnemyBullet(Pair<Double, Double> pos, List<String> strImg) {
		this.random = new Random();
		this.strImgs = new ArrayList<>();
		this.randomBulletImg(strImg);
		this.create(EntityType.ENEMY_BULLET, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, 
				0, (this.random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), EntityDirections.DOWN, 
				new EntityGraphicsImpl(this.strImgs), new EntityMovementImpl());
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
	private void randomBulletImg(List<String> newStrImg) {
		switch(this.random.nextInt(newStrImg.size())) {
			case 1:
				this.strImgs.add(newStrImg.get(1));
				break;
			case 2:
				this.strImgs.add(newStrImg.get(2));
				break;
			default:
				this.strImgs.add(newStrImg.get(0));
				break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(entity.getEntityType().equals(EntityType.PLAYER)) {
			this.setLife();
		}
	}

}
