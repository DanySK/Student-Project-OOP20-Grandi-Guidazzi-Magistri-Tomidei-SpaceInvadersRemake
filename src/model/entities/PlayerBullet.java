package model.entities;

import model.entitiesutil.Bullet;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityMovementImpl;

public class MonoDirectionPlayerBullet extends Bullet{
	
	public MonoDirectionPlayerBullet(double x, double y) {
		this.create(SpecificEntityType.PLAYER_1_BULLET, x, y, EntityConstants.PlayerBullet.PLAYER_BULLET_INITIAL_WIDTH, 
				EntityConstants.PlayerBullet.PLAYER_BULLET_INITIAL_HEIGHT, EntityConstants.PlayerBullet.PLAYER_BULLET_MU_X, 
				EntityConstants.PlayerBullet.PLAYER_BULLET_MU_Y, EntityDirections.UP, new EntityMovementImpl());
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
