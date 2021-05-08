package model.entities;

import model.entitiesutil.Enemy;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.EntityType;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Alien extends Enemy{

	private final int WIDTH = 0;
	private final int HEIGHT = 0;
	private final double MUX = 0;
	private final double MUY = 0;
	private final int MAX_HIT = 1;
	private final AlienGroup alienGroup;
	
	public Alien(Pair<Integer, Integer> pos, AlienGroup alienGroup) {
		this.create(EntityType.ALIEN, pos, this.WIDTH, this.HEIGHT, this.MUX, this.MUY,
					this.MAX_HIT, EntityDirections.LEFT, new EntityMovementImpl());
		this.alienGroup = alienGroup;
	}
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(this.isAlive()) {
			this.hit();
		}
	}

	@Override
	public void doAfterCollisionWith(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			alienGroup.alienGroupDown();
		}
		if(edge.equals(EdgeCollision.DOWN)) {
			//this.model.processGameOver();
		}
		
	}

	@Override
	public void updateEntityPos() {
		if(this.getDirection().equals(EntityDirections.LEFT)){
			this.getMovementImpl().moveLeft(this);
		}
		else {
			this.getMovementImpl().moveRight(this);
		}
	}

	@Override
	protected void changeDirection() {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.LEFT);
		}
		this.getMovementImpl().moveDown(this);
	}

	@Override
	public void shot() {
		/*this.model.getNewEntitiesLevel().add(new MonoDirectionEnemyBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
		this.getY() + this.getHeight()), EntityType.ALIEN_BULLET));*/
	}

}
