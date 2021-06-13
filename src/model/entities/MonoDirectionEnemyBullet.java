package model.entities;

import java.util.Random;

import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.entitiesutil.Bullet;
import model.entitiesutil.EntityConstants;
import model.physics.EntityMovementImpl;

/**
 * {@link Bullet} with a single direction
 */
public class MonoDirectionEnemyBullet extends Bullet {

	/**
	 * {@link Bullet} with a single direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param type		is the type of this {@link Bullet}
	 */
	protected MonoDirectionEnemyBullet(double x,double y, SpecificEntityType type) {
		Random random = new Random();
		this.create(type, x, y, EntityConstants.MonoDirectionEnemyBullet.INITIAL_WIDTH, 
				EntityConstants.MonoDirectionEnemyBullet.INITIAL_HEIGHT, 
				0, (random.nextInt((int)EntityConstants.MonoDirectionEnemyBullet.MAX_MU_Y) + 1), 
				EntityDirections.DOWN, new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}}
	 */
	@Override
	public void updateEntityPosition() {
		this.getMovementMenager().moveDown(this);
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
