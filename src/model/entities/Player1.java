package model.entities;

import model.Model;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.Player;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import view.game.GameEvent;

/**
 * The entity with which the user with a generic player.
 */
public class Player1 extends Player{
	
	private final Model model;
	
	/**
	 * The constructor that create the entity.
	 * @param type 		is the type of player
	 * @param x			is the initial x coordinate  
	 * @param y			is the initial y coordinate 
	 * @param model		is the {@link Model}
	 */
	public Player1(SpecificEntityType type, double x, double y, Model model) {
		this.create(type, x, y, EntityConstants.Player.INITIAL_WIDTH, EntityConstants.Player.INITIAL_HEIGHT,
				EntityConstants.Player.INITIAL_MU_X, 0, EntityConstants.Player.MAX_HITS);
		this.model = model;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shoot() {
		this.model.getNewEntity().add(new PlayerBullet(this.getX(), getY() - this.getHeight()/2 - EntityConstants.PlayerBullet.INITIALHEIGHT/2));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.ENEMY_BULLET) && this.isAlive()){
			this.incHits();
		} else if(entity.getEntityType().getGenericType().equals(GenericEntityType.BOSS)
				|| (entity.getEntityType().getGenericType().equals(GenericEntityType.GENERIC_ENEMY))){
			while (this.getHit() <= EntityConstants.Player.MAX_HITS) {
				this.incHits();
			}
		}		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEdge(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			this.setMuX(0);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPosition(GameEvent event) {
		if(event.equals(GameEvent.LEFT)) {
			this.setMuX(-this.getMuX());
		} 
		if (event.equals(GameEvent.RIGHT)){
			this.setMuX(this.getMuX());
		}
		if (event.equals(GameEvent.FIRE)) {
			this.shoot();
		}
		this.setX(this.getX() + this.getMuX());
	}

}
