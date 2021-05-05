package model.entities;

import java.util.Random;

import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.EntityType;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Enemy} boss that after taking a certain number of hits can teleport and move quickly
 */
public class Boss3 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final double INITIAL_MU_X = 0;
	private final double INITIAL_MU_Y = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;
	private final int MAX_SPEED = 0;

	private BossState state;
	private Random random;

	/**
	 * {@link Enemy} boss that after taking a certain number of hits can teleport and move quickly
	 * 
	 * @param pos is the initial position of this entity
	 */
	public Boss3(Pair<Integer, Integer> pos) {
		EntityDirections direction = EntityDirections.LEFT;
		super.create(EntityType.BOSS_3, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X,this.INITIAL_MU_Y, 
				this.MAX_HITS, direction, 
				new EntityMovementImpl());
		this.state = BossState.NORMAL;
		this.random = new Random();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		this.changeState();
		this.teleport();
		if(this.state.equals(BossState.UPSET)) {
			this.setMuX(this.MAX_SPEED);
		}
		if(this.getDirection().equals(EntityDirections.LEFT)) {
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
	protected void changeDirection() {
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
	public void shot() {
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			/*this.model.getNewEntitiesLevel().add(new MultiDirectionsEnemyBullet(
					new Pair<>(this.getX() + this.getWidth()/4 - 1, this.getY() + this.getHeight()), 
					EntityType.BOSS_3_BULLET));
			this.model.getNewEntitiesLevel().add(new MultiDirectionsEnemyBullet(
					new Pair<>(this.getX() + this.getWidth()/2 - 1, this.getY() + this.getHeight()), 
					EntityType.BOSS_3_BULLET));
			this.model.getNewEntitiesLevel().add(new MultiDirectionsEnemyBullet(
					new Pair<>(this.getX() + this.getWidth()* 3/4 - 1, this.getY() + this.getHeight()), 
					EntityType.BOSS_3_BULLET));
		}
		else {
			this.model.getNewEntitiesLevel().add(new MonoDirectionEnemyBullet(
					new Pair<>(this.getX() + this.getWidth()/2 -1, this.getY() + this.getHeight()), 
					EntityType.BOSS_3_BULLET));*/
		}
	}

	/**
	 * Change the state of the boss after it took too many hits 
	 */
	private void changeState() {
		if(this.getHits() >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
			this.setMuX(this.MAX_SPEED);
		}
	}

	/**
	 * Teleport the boss in a range took from input
	 * 
	 * @param minX is the minimum value of the range
	 * @param maxX is the maximum value of the range
	 */
	private void teleport() {
		double x = 0;
		if(this.state.equals(BossState.UPSET) && (this.getHits() % this.random.nextInt(2) + 2 == 0)) {
			/*do {
				x = this.random.nextInt((int)(this.model.getController().getWindowWidth - this.getMuX()));
			}while(x < 0);*/

			this.setX(x);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(entity.getEntityType().equals(EntityType.PLAYER_BULLET)) {
			this.hit();
		}
		if(entity.getEntityType().equals(EntityType.PLAYER)) {
			//this.model.processGameOver();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			this.getMovementImpl().moveDown(this);
			this.changeDirection();
		}
		if(edge.equals(EdgeCollision.DOWN)) {
			//this.model.processGameOver();
		}
	}
}
