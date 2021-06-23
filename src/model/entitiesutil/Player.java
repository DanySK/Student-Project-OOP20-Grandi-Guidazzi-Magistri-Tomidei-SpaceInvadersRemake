package model.entitiesutil;

import model.entities.SpecificEntityType;
import model.entitiesutil.typeentities.UserEntity;
import util.Pair;

/**
 * The entity with which the user can play.
 */
public abstract class Player implements UserEntity{

	private SpecificEntityType entityType;
	private Pair<Double,Double> position;
	private double movimentUnitX;
	private double movimentUnitY;
	private int height;
	private int width;
	private int hit;
	private int maxHits;
	
	/**
	 * Method that generate the entity player.
	 * @param type		is the {@link SpecificEntityType}
	 * @param x			is the initial x coordinate of the {@link Player}
	 * @param y			is the initial y coordinate of the {@link Player}
	 * @param width		is the initial width of the {@link Player}
	 * @param height	is the initial height of the {@link Player}
	 * @param muX		is the initial movement unit of the {@link Player} along x-axis
	 * @param muY		is the initial movement unit of the {@link Player} along y-axis
	 * @param maxHits	is the max number of hits that {@link Player} can take before dying
	 */
	public void create(SpecificEntityType type, double x, double y, int width,int height, 
			double muX, double muY, int maxHits) {
		this.entityType = SpecificEntityType.PLAYER_1;
		this.position = new Pair<>(x, y);
		this.movimentUnitX = muX;
		this.movimentUnitY = muY;
		this.height = height;
		this.width = width;
		this.hit = 0;
		this.maxHits = maxHits;
	}
	
	/**
	 * A method that returns the position of player in a specific moment.
	 */
	public Pair<Double, Double> getPos() {
		return this.position;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPos(double x, double y) {
		this.position.setBoth(x, y);
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
	public boolean isAlive() {
		return this.hit < this.maxHits;
	}
	
	/**
	 * Method that increments the number of hit.
	 */
	public void incHits() {
		this.hit++;
	}

	/**
	 * Method that returns the number of hit suffered by the player.
	 * @return
	 */
	public int getHit() {
		return this.hit;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMuX() {
		return this.movimentUnitX;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuX(double mux) {
		this.movimentUnitY = mux;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuY(double muy) {
		this.movimentUnitY = muy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getX() {
		return this.position.getX();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getY() {
		return this.position.getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setX(double x) {
		this.position.setY(x);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setY(double y) {
		this.position.setY(y);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SpecificEntityType getEntityType() {
		return this.entityType;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getMuY() {
		return this.movimentUnitY;
	}
		
}
	
