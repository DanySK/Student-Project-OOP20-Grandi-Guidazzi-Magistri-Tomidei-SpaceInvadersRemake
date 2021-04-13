package model.entitiesutil;

import java.awt.Graphics;
import java.util.List;

import graphics.EntitiesGraphics;
import model.physics.EntityMovement;
import util.Pair;

public abstract class Bullet implements Entity{

	public enum BulletType {


		ENEMY,


		BOSS,


		HERO
	}

	private Pair<Integer,Integer> pos;
	private int width, height, muX, muY;
	private boolean life;
	private List<String> strImgs;
	private EntitiesGraphics graphics;
	private EntityMovement move;
	private EntityDirections direction;
	private EntityType entityType;
	private BulletType bulletType;

	protected void create(BulletType type, Pair<Integer,Integer> pos, int width,int height, int muX, int muY,
			List<String> strImg, EntityDirections dir, EntitiesGraphics graph, EntityMovement move) {
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
		this.entityType = EntityType.BULLET;
		this.bulletType = type;
	}

	@Override
	public Pair<Integer, Integer> getPos() {
		return this.pos;
	}

	@Override
	public void setPos(Pair<Integer, Integer> pos) {
		this.pos = pos;
	}

	@Override
	public int getX() {
		return this.pos.getX();
	}

	@Override
	public int getY() {
		return this.pos.getY();
	}

	@Override
	public void setX(int x) {
		this.pos.setX(x);
	}

	@Override
	public void setY(int y) {
		this.pos.setY(y);
	}

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public int getMuX() {
		return this.muX;
	}

	@Override
	public void setMuX(int mux) {
		this.muX = mux;
	}

	@Override
	public int getMuY() {
		return this.muY;
	}

	@Override
	public void setMuY(int muy) {
		this.muY = muy;
	}

	@Override
	public boolean isLife() {
		return this.life;
	}


	public void destroy() {
		this.life = false;
	}

	@Override
	public List<String> getStrImgs() {
		return this.strImgs;
	}

	@Override
	public EntityMovement getMovement() {
		return this.move;
	}

	@Override
	public EntityDirections getDirection() {
		return this.direction;
	}

	@Override
	public void updateEntity(Graphics g, Entity e) {
		this.updateEntityMovement();
		this.graphics.updateGraphics(g, e);
	}

	protected abstract void updateEntityMovement();

	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}


	public BulletType getBulleType() {
		return this.bulletType;
	}

}
