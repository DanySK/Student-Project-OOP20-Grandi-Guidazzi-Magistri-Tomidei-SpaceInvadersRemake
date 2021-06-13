package model.entities;

import model.entitiesutil.Enemy;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;

public class Alien extends Enemy{

	private final int MAX_HIT = 1;
	private final AlienGroup alienGroup;
	
	public Alien(int x, int y, AlienGroup alienGroup) {
		this.create(SpecificEntityType.ALIEN, x, y, EntityConstants.Alien.INITIAL_WIDTH, EntityConstants.Alien.INITIAL_HEIGHT, 
				EntityConstants.Alien.INITIAL_MU_X, EntityConstants.Alien.INITIAL_MU_Y,
					this.MAX_HIT, EntityDirections.LEFT, new EntityMovementImpl());
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
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			alienGroup.alienGroupDown();
		}
		if(edge.equals(EdgeCollision.DOWN)) {
			//this.model.processGameOver();
		}
	}
	
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(this.isAlive()) {
			this.incHit();
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
		/*this.model.getNewEntitiesLevel().add(new MonoDirectionEnemyBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
		this.getY() + this.getHeight()), EntityType.ALIEN_BULLET));*/
		
	}

}
