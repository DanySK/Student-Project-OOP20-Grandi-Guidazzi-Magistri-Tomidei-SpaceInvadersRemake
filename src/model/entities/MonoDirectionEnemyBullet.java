package model.entities;

import java.util.Random;

import model.entitiesutil.EntityDirections;
import model.entitiesutil.EntityType;
import model.entitiesutil.Bullet;
import model.entitiesutil.Entity;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with a single direction
 */
public class MonoDirectionEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_MAX_MU_Y = 0;

	/**
	 * {@link Bullet} with a single direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param type		is the type of this {@link Bullet}
	 */
	protected MonoDirectionEnemyBullet(Pair<Double, Double> pos, EntityType type) {
		Random random = new Random();
		this.create(type, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, 
				0, (random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), EntityDirections.DOWN, 
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
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(entity.getEntityType().equals(EntityType.PLAYER)) {
			this.setLife();
		}
	}

}
