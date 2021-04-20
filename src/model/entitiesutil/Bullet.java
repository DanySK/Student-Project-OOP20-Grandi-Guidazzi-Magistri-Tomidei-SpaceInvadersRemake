package model.entitiesutil;

import java.awt.Graphics;
import java.util.List;

import graphics.EntityGraphics;
import model.physics.EntityMovement;
import util.Pair;

/**
 * Object which is throw
 */
public abstract class Bullet implements Entity{

	private Pair<Integer,Integer> pos;
	private int width, height, muX, muY;
	private boolean life;
	private List<String> strImgs;
	private EntityGraphics graphics;
	private EntityMovement move;
	private EntityDirections direction;
	private EntityType entityType;

	/**
	 * Create a new {@link Bullet}
	 * 
	 * @param type		is the {@link BulletType}
	 * @param pos		is the initial position of the {@link Bullet}
	 * @param width		is the initial width of the {@link Bullet}
	 * @param height	is the initial height of the {@link Bullet}
	 * @param muX		is the initial movement unit of the {@link Bullet} along x-axis 
	 * @param muY		is the initial movement unit of the {@link Bullet} along y-axis 
	 * @param strImg	is the images's path of {@link Bullet}
	 * @param dir		is the initial direction of the {@link Bullet}
	 * @param graph		is the {@link EntityGraphics} implementation
	 * @param move		is {@link EntityMovement} implementation
	 */
	protected void create(EntityType type, Pair<Integer,Integer> pos, int width,int height, int muX, int muY,
			List<String> strImg, EntityDirections dir, EntityGraphics graph, EntityMovement move) {
		this.width = width;
		this.height = height;
		this.pos = pos;
		this.muX = muX;
		this.muY = muY;
		this.strImgs = strImg;
		this.graphics = graph;
		this.move = move;
		this.direction = dir;
		this.life = true;
		this.entityType = type;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Pair<Integer, Integer> getPos() {
		return this.pos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setPos(Pair<Integer, Integer> pos) {
		this.pos = pos;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getX() {
		return this.pos.getX();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getY() {
		return this.pos.getY();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setX(int x) {
		this.pos.setX(x);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setY(int y) {
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
	public int getMuX() {
		return this.muX;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuX(int mux) {
		this.muX = mux;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMuY() {
		return this.muY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMuY(int muy) {
		this.muY = muy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLife() {
		return this.life;
	}

	/**
	 * Set the life of the {@link Bullet} to false
	 */
	public void setLife() {
		this.life = false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getStrImgs() {
		return this.strImgs;
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
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntity(Graphics g, Entity e) {
		this.graphics.updateGraphics(g, e);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public abstract void updateEntityPos();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}

}
