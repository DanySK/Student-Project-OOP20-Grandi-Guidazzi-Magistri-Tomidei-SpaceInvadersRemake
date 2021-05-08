package model.entities;

import java.util.Random;

import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.bossutil.BossState;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;

/**
 * {@link Enemy} boss that after taking a certain number of hits can teleport and move quickly
 */
public class Boss3 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final double INITIAL_MU_X = 0;
	private final double INITIAL_MU_Y = 0;
	private final int MAX_HITS = 0;
	private final int MAX_SPEED = 0;
	private final int HITS_2ND_PHASE = this.MAX_HITS/2;

	private boolean isAlreadyUpset;
	private boolean teleport;
	private BossState state;
	private Random random;

	/**
	 * {@link Enemy} boss that after taking a certain number of hits can teleport and move quickly
	 * 
	 * @param x is the initial x coordinate
	 * @param y is the initial y coordinate
	 */
	public Boss3(int x, int y) {
		EntityDirections direction = EntityDirections.LEFT;
		super.create(SpecificEntityType.BOSS_3, x, y, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X,this.INITIAL_MU_Y, 
				this.MAX_HITS, direction, 
				new EntityMovementImpl());
		this.isAlreadyUpset = false;
		this.teleport = false;
		this.state = BossState.NORMAL;
		this.random = new Random();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPosition() {
		this.changeState();
		this.teleport();
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
	public void shoot() {
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
		if(this.getHits() >= this.HITS_2ND_PHASE && !this.isAlreadyUpset) {
			this.state = BossState.UPSET;
			this.setMuX(this.MAX_SPEED);
			this.isAlreadyUpset = true;
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
		if(this.state.equals(BossState.UPSET) && 
				this.getHits() % (this.getMaxHits()-this.getHits())== 0 &&
				!this.teleport) {
			/*do {
				x = this.random.nextInt((int)(this.model.getController().getWindowWidth - this.getMuX()));
			}while(x < 0);*/

			this.setX(x);
			this.teleport = true;
		}
	}

	/**
	 * Condition for teleport the boss
	 */
	protected void canTeleport() {
		this.teleport = !this.teleport;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().equals(SpecificEntityType.PLAYER_BULLET)) {
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
