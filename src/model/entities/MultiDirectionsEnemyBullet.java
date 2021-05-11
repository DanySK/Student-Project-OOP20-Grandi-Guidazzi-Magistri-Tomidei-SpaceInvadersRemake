package model.entities;

import java.util.Random;

import model.entitiesutil.Bullet;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityMovementImpl;

/**
 * {@link Bullet} with multiple direction
 */
public class MultiDirectionsEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_INITIAL_MU_X = 0;
	private final double BULLET_MAX_MU_Y = 0;
	private final int POSSIBLE_BULLET_DIRECTION = 3;
	private Random random;

	/**
	 * {@link Bullet} with multiple direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param type		is the type of this {@link Bullet} 
	 */
	protected MultiDirectionsEnemyBullet(double x, double y, SpecificEntityType type) {
		this.random = new Random();
		this.create(type, x, y, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				(this.random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), this.setRandomDirection(), 
				new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPosition() {
		switch(this.getDirection()) {
			case DOWN_LEFT:
				this.getMovementMenager().moveBottomLeft(this);
				break;
			case DOWN_RIGHT:
				this.getMovementMenager().moveBottomRight(this);
				break;
			default:
				this.getMovementMenager().moveDown(this);
				break;
		}
	}

	/**
	 * Selects a possible random direction for this entity and returns it
	 * 
	 * @return a possible random direction for this entity
	 */
	private EntityDirections setRandomDirection() {
		switch(this.random.nextInt(this.POSSIBLE_BULLET_DIRECTION)) {
			case 1:
				return EntityDirections.DOWN_LEFT;
			case 2:
				return EntityDirections.DOWN_RIGHT;
			default:
				return EntityDirections.DOWN;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.PLAYER)) {
			this.setLife();
		}
	}

}
