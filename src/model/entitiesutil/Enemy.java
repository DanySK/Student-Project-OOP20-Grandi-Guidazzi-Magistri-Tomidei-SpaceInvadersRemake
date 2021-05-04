package model.entitiesutil;

import model.physics.EntityMovement;
import util.Pair;

/**
 * {@link Entity} that Hero should kill
 */
public abstract class Enemy implements Entity{

	private Pair<Double, Double> pos;
	private double muX, muY;
	private int width, height, hit, maxHits;
	private EntityMovement move;
	private EntityDirections direction;
	private EntityType entityType;

	/**
	 * Create a new {@link Enemy}
	 * 
	 * @param type		is the {@link EnemyType}
	 * @param pos		is the initial position of the {@link Enemy}
	 * @param width		is the initial width of the {@link Enemy}
	 * @param height	is the initial height of the {@link Enemy}
	 * @param muX		is the initial movement unit of the {@link Enemy} along x-axis
	 * @param muY		is the initial movement unit of the {@link Enemy} along y-axis
	 * @param maxHits	is the max number of hits that {@link Enemy} can take before dying
	 * @param dir		is the initial direction of the {@link Enemy}
	 * @param move		is {@link EntityMovement} implementation
	 */
	protected void create(EntityType type, Pair<Integer,Integer> pos, int width,int height, 
			double muX, double muY, int maxHits, EntityDirections dir,
			EntityMovement move) {
		this.width = width;
		this.height = height;
		this.pos = new Pair<>((double)pos.getX(), (double)pos.getY());
		this.muX = muX;
		this.muY = muY;
		this.move = move;
		this.direction = dir;
		this.hit = 0;
		this.maxHits = maxHits;
		this.entityType = type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<Double, Double> getPos() {
		return pos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPos(Pair<Integer, Integer> pos) {
		this.pos.setBoth((double)pos.getX(), (double)pos.getY());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getX() {
		return this.pos.getX();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getY() {
		return this.pos.getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setX(double x) {
		this.pos.setX(x);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setY(double y) {
		this.pos.setY(y);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getWidth() {
		return this.width;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getHeight() {
		return this.height;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMuX() {
		return muX;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuX(double mux) {
		this.muX = mux;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMuY() {
		return muY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuY(double muy) {
		this.muY = muy;
	}

	/**
	 * Return the current number of hits that {@link Enemy} take
	 * 
	 * @return an integer which represent the current number of hits that {@link Enemy} take
	 */
	public int getHits() {
		return this.hit;
	}

	/**
	 * Increment the current number of hits that {@link Enemy} take
	 */
	public void hit() {
		this.hit++;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityMovement getMovementImpl() {
		return this.move;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityDirections getDirection() {
		return this.direction;
	}


	/**
	 * Update the direction of the {@link Enemy}
	 * 
	 * @param dir is the new direction of the {@link Enemy}
	 */
	protected void setDirection(EntityDirections dir) {
		this.direction = dir;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAlive() {
		return this.hit < this.maxHits;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void updateEntityPos();


	/**
	 * Invert the direction of the {@link Enemy}
	 */
	protected abstract void changeDirection();


	/**
	 * Create new {@link Bullet} according to the type of the {@link Enemy}
	 */
	public abstract void  shot();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}
}

