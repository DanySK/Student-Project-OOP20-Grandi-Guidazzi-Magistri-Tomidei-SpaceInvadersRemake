package model.entities;

import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.Bullet;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with multiple direction
 */
public class MultiDirectionsEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_INITIAL_MU_X = 0;
	private final double BULLET_MAX_MU_Y = 0;
	private EntityDirections direction;
	private Random random;

	/**
	 * {@link Bullet} with multiple direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param strImg	are the images's paths of the {@link Bullet} 
	 */
	protected MultiDirectionsEnemyBullet(Pair<Double, Double> pos, EntityType type) {
		this.random = new Random();
		this.randomBulletImg();
		this.create(type, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				(this.random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), this.direction, 
				new EntityGraphicsImpl(type), new EntityMovementImpl());
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
	 * and change the {@link Bullet} direction according to the image's path
	 * 
	 * @param newStrImg is the new image's path of the bullet
	 */
	private void randomBulletImg() {
		switch(this.random.nextInt()) {
			case 1:
				this.direction = EntityDirections.DOWN_LEFT;
				break;

			case 2:
				this.direction = EntityDirections.DOWN_RIGHT;
				break;

			default:
				this.direction = EntityDirections.DOWN;
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
