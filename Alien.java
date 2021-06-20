package model.entities;

import model.Model;

import model.entitiesutil.Enemy;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
/**
 * 
 * A class that models the entity alien.
 *
 */
public class Alien extends Enemy{

	private final AlienGroup alienGroup;
	private final Model model;
	
	/**
	 * The constructor of the entity alien.
	 * @param x
	 * @param y
	 * @param alienGroup
	 * @param model
	 * @param type
	 */
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
		if(this.isAlive()) {
			this.incHits();
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

	@Override
	public boolean canShoot(int cycles) {
		int x = EntityConstants.Alien.CYCLES_TO_SHOOT;
		return (x == 0) ? true : 
			(cycles % x == 0) ? true : false;
	}

}
