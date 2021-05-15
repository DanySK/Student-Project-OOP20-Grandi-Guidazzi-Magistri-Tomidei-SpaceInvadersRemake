package model.entities;

import model.entitiesutil.Enemy;

import model.entitiesutil.EntityDirections;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;

public class Alien extends Enemy{

	private final int WIDTH = 0;
	private final int HEIGHT = 0;
	private final double MUX = 0;
	private final double MUY = 0;
	private final int MAX_HIT = 1;
	private final AlienGroup alienGroup;
	
	public Alien(int x, int y, AlienGroup alienGroup) {
		this.create(SpecificEntityType.ALIEN, x, y, this.WIDTH, this.HEIGHT, this.MUX, this.MUY,
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
