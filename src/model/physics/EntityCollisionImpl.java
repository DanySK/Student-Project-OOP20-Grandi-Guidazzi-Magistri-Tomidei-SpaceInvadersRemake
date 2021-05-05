package model.physics;

import java.util.List;
import java.util.stream.Collectors;

import model.entitiesutil.Entity;
import model.entitiesutil.EntityType;

/**
 * Implementation of {@link EntityCollision}
 */
public class EntityCollisionImpl implements EntityCollision{

	private Model model;
	private List<Entity> enemyEntities;
	private List<Entity> playerEntities;
	
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
	public void checkCollision(Entity e) {
		this.enemyEntities = this.model.getEntitiesLevel().stream().
				filter(i -> !i.getEntityType().equals(EntityType.PLAYER)
						|| i.getEntityType().equals(EntityType.PLAYER_BULLET))
				.collect(Collectors.toList());

		this.playerEntities = this.model.getEntitiesLevel().stream().
				filter(i -> i.getEntityType().equals(EntityType.PLAYER)
						|| i.getEntityType().equals(EntityType.PLAYER_BULLET))
				.collect(Collectors.toList());

		if(e.getEntityType().equals(EntityType.PLAYER) ||
				e.getEntityType().equals(EntityType.PLAYER_BULLET)) {
			this.enemyEntities.forEach(enemy -> this.collision(e, enemy));
		}
		else {
			this.playerEntities.forEach(player -> this.collision(e, player));
		}
		this.edgeCollision(e);
	}

	/**
	 * Check collision between two specific entities
	 * 
	 * @param e				is one {@link Entity} to check
	 * @param entityLevel	is one  {@link Entity} to check
	 */
	private void collision(Entity e, Entity entityLevel) {
		if(!e.equals(entityLevel) && e.isAlive() && entityLevel.isAlive() && 
				!e.getEntityType().equals(entityLevel.getEntityType())){

			final double ePosX = e.getX();
			final double ePosY = e.getY();
			final int eWidth = e.getWidth();
			final int eHeight = e.getHeight();
			final double eLevelPosX = entityLevel.getX();
			final double eLevelPosY = entityLevel.getY();
			final int eLevelWidth = entityLevel.getWidth();
			final int eLevelHeight = entityLevel.getHeight();

			if(ePosY < (eLevelPosY + eLevelHeight) && (ePosY + eHeight) > eLevelPosY && 
					ePosX < (eLevelPosX + eLevelWidth) && (ePosX + eWidth) > eLevelPosX) {
				e.doAfterCollisionWith(entityLevel);
				entityLevel.doAfterCollisionWith(e);
			}
		}
	}

	/**
	 * Check collision between an {@link Entity} and the frame Edges
	 * 
	 * @param e is the {@link Entity} to check
	 */
	private void edgeCollision(Entity e) {
		if(e.isAlive()) {
			if(e.getX() < 0) {
				e.doAfterCollisionWith(EdgeCollision.LEFT);
			}
			if(e.getX() + e.getWidth() + e.getMuX() > this.model.getController().getWindowWidth()) {
				e.doAfterCollisionWith(EdgeCollision.RIGHT);
			}
			if(e.getY() < 0) {
				e.doAfterCollisionWith(EdgeCollision.TOP);
			}
			if(e.getY() + e.getHeight() > this.model.getController().getWindowHeight()) {
				e.doAfterCollisionWith(EdgeCollision.DOWN);
			}
		}
		
	}

}
