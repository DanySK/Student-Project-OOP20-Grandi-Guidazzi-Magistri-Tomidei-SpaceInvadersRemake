package model.entities;

import model.entitiesutil.Bullet;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityMovementImpl;

public class MonoDirectionPlayerBullet extends Bullet{

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_MAX_MU_Y = 0;
	
	public MonoDirectionPlayerBullet(double x, double y) {
		this.create(SpecificEntityType.PLAYER_BULLET, BULLET_MAX_MU_Y, BULLET_MAX_MU_Y, BULLET_INITIAL_WIDTH, BULLET_INITIAL_HEIGHT, 
				BULLET_MAX_MU_Y, BULLET_MAX_MU_Y, EntityDirections.UP, new EntityMovementImpl());
	}

	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.GENERIC_ENEMY) 
				|| entity.getEntityType().getGenericType().equals(GenericEntityType.BOSS)) {
			this.setLife();
		} 
	}

	@Override
	public void updateEntityPosition() {
		this.getMovementMenager().moveUp(this);
	}

}
