package model.entities;

import model.Model;

import model.entitiesutil.Enemy;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
public class Alien extends Enemy{

	private final AlienGroup alienGroup;
	private final Model model;
	
	public Alien(int x, int y, AlienGroup alienGroup, Model model, SpecificEntityType type) {
		this.model = model;
		this.create(type, x, y, EntityConstants.Alien.INITIAL_WIDTH, EntityConstants.Alien.INITIAL_HEIGHT, 
				EntityConstants.Alien.INITIAL_MU_X, EntityConstants.Alien.INITIAL_MU_Y,
				EntityConstants.Alien.MAX_HIT, EntityDirections.LEFT, new EntityMovementImpl());
		this.alienGroup = alienGroup;
	}
	
	@Override
	protected void changeDirection() {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.LEFT);
		}
		this.getMovementMenager().moveDown(this);
	}
	
	@Override
	public void doAfterCollisionWithEdge(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT)){ 
			alienGroup.alienGroupDown(EdgeCollision.LEFT);
		} else if(edge.equals(EdgeCollision.RIGHT)) {
			alienGroup.alienGroupDown(EdgeCollision.RIGHT);
		} else if(edge.equals(EdgeCollision.DOWN)) {
			this.model.processGameOver();
		}
	}
	
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().equals(SpecificEntityType.PLAYER_1_BULLET)) {
			if(this.isAlive()) {
				this.incHit();
			}
		}
	}
	
	@Override
	public void updateEntityPosition() {
		if(this.getDirection().equals(EntityDirections.LEFT)){
			this.getMovementMenager().moveLeft(this);
		}
		else {
			this.getMovementMenager().moveRight(this);
		}
	}
	
	@Override
	public void shoot() {
		this.model.getNewEntity().add(new MonoDirectionEnemyBullet(this.getX(),
		this.getY() + EntityConstants.MonoDirectionEnemyBullet.INITIAL_WIDTH + this.getHeight(), SpecificEntityType.ALIEN_BULLET));
		
	}

}
