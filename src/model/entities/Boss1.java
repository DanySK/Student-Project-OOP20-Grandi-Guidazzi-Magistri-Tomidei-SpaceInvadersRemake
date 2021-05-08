package model.entities;

import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;

/**
 * Generic {@link Enemy} boss
 */
public class Boss1 extends Enemy {

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final double INITIAL_MU_X = 0;
	private final double INITIAL_MU_Y = 0;
	private final int MAX_HITS = 0;

	/**
	 * Generic {@link Enemy} boss
	 * 
	 * @param x is the initial x coordinate
	 * @param y is the initial y coordinate
	 */
	public Boss1(int x, int y) {
		EntityDirections direction = EntityDirections.RIGHT;
		this.create(SpecificEntityType.BOSS_1, x, y, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, 
				this.INITIAL_MU_Y, this.MAX_HITS, direction,
				new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeDirection() {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.LEFT);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPosition() {
		if(this.getDirection().equals(EntityDirections.LEFT)){
			this.getMovementImpl().moveLeft(this);
		}
		else {
			this.getMovementImpl().moveRight(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shoot() {
		/*this.model.getNewEntitiesLevel().add(new MonoDirectionEnemyBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
				this.getY() + this.getHeight()), EntityType.BOSS_1_BULLET));*/
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().equals(SpecificEntityType.PLAYER_BULLET) && this.isAlive()) {
				this.incHit();
		}
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.PLAYER)) {
				//this.model.processGameOver();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEdge(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			this.getMovementImpl().moveDown(this);
			this.changeDirection();
		}
		if(edge.equals(EdgeCollision.DOWN)) {
			//this.model.processGameOver();
		}
	}
}
