package model.physics;

import java.util.List;
import java.util.stream.Collectors;

import model.entities.SpecificEntityType;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.entitiesutil.typeentities.MobileEntity;

/**
 * Implementation of {@link EntityCollision}
 */
public class EntityCollisionImpl implements EntityCollision{

	private Model model;
	private List<GenericEntity> enemyEntities;
	private List<GenericEntity> playerEntities;
	
	/**
	 * Implementation of {@link EntityCollision}
	 */
	public EntityCollisionImpl(Model model) {
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkCollision() {	
		this.model.getEntitiesLevel().forEach(e ->{
			this.model.getEntitiesLevel().forEach(eLevel -> this.collision(e, eLevel));
			this.edgeCollision(e);
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void checkCollision(GenericEntity e) {
		this.enemyEntities = this.model.getEntitiesLevel().stream().
				filter(i -> !i.getEntityType().getGenericType().equals(GenericEntityType.PLAYER)
						|| i.getEntityType().equals(GenericEntityType.PLAYER_BULLET))
				.collect(Collectors.toList());

		this.playerEntities = this.model.getEntitiesLevel().stream().
				filter(i -> i.getEntityType().getGenericType().equals(GenericEntityType.PLAYER)
						|| i.getEntityType().equals(GenericEntityType.PLAYER_BULLET))
				.collect(Collectors.toList());

		if(e.getEntityType().getGenericType().equals(GenericEntityType.PLAYER) ||
				e.getEntityType().equals(SpecificEntityType.PLAYER_BULLET)) {
			this.enemyEntities.forEach(enemy -> this.collision(e, enemy));
		}
		else {
			this.playerEntities.forEach(player -> this.collision(e, player));
		}
		this.edgeCollision((MobileEntity)e);
	}

	/**
	 * Check collision between two specific entities
	 * 
	 * @param e				is one {@link GenericEntity} to check
	 * @param entityLevel	is one  {@link GenericEntity} to check
	 */
	private void collision(GenericEntity e, GenericEntity entityLevel) {
		if(!e.equals(entityLevel) && e.isAlive() && entityLevel.isAlive() && 
				!e.getEntityType().equals(entityLevel.getEntityType())){

			final double ePosX = e.getX();
			final double ePosY = e.getY();
			final int eWidth = e.getWidth()/2;
			final int eHeight = e.getHeight()/2;
			final double eLevelPosX = entityLevel.getX();
			final double eLevelPosY = entityLevel.getY();
			final int eLevelWidth = entityLevel.getWidth()/2;
			final int eLevelHeight = entityLevel.getHeight()/2;

			if(ePosY < (eLevelPosY + eLevelHeight) && (ePosY + eHeight) > eLevelPosY && 
					ePosX < (eLevelPosX + eLevelWidth) && (ePosX + eWidth) > eLevelPosX) {
				e.doAfterCollisionWithEntity(entityLevel);
				entityLevel.doAfterCollisionWithEntity(e);
			}
		}
	}

	/**
	 * Check collision between an {@link GenericEntity} and the frame Edges
	 * 
	 * @param e is the {@link GenericEntity} to check
	 */
	private void edgeCollision(MobileEntity e) {
		if(e.isAlive()) {
			if(e.getX() - e.getWidth()/2 < 0) {
				e.doAfterCollisionWithEdge(EdgeCollision.LEFT);
			}
			if(e.getX() + e.getWidth()/2 + e.getMuX() > this.model.getController().getWindowWidth()) {
				e.doAfterCollisionWithEdge(EdgeCollision.RIGHT);
			}
			if(e.getY() - e.getHeight()/2 < 0) {
				e.doAfterCollisionWithEdge(EdgeCollision.TOP);
			}
			if(e.getY() + e.getHeight()/2 > this.model.getController().getWindowHeight()) {
				e.doAfterCollisionWithEdge(EdgeCollision.DOWN);
			}
		}
		
	}

}
