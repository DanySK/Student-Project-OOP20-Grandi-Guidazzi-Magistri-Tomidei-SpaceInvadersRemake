package model.entitiesutil;

import java.awt.Graphics;
import java.util.List;

import graphics.EntitiesGraphics;
import model.physics.EntityMovement;
import util.Pair;


public abstract class Enemy implements Entity{

	public enum EnemyType{


		GENERIC_ENEMY,


		BOSS
	}

	private Pair<Integer,Integer> pos;
	private int width, height, muX, muY, hit, maxHits;
	private List<String> strImgs;
	private EntitiesGraphics graphics;
	private EntityMovement move;
	private EntityDirections direction;
	private EntityType entityType;
	private EnemyType enemyType;

	protected void create(EnemyType type, Pair<Integer,Integer> pos, int width,int height, int muX, int muY, int maxHits,
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
		this.hit = 0;
		this.maxHits = maxHits;
		this.entityType = EntityType.ENEMY;
		this.enemyType = type;
		
	}

	@Override
	public Pair<Integer, Integer> getPos() {
		return pos;
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
		return muX;
	}

	@Override
	public void setMuX(int mux) {
		this.muX = mux;
	}

	@Override
	public int getMuY() {
		return muY;
	}

	@Override
	public void setMuY(int muy) {
		this.muY = muy;
	}

	public int getHits() {
		return this.hit;
	}

	public void hit() {
		this.hit++;
	}

	@Override
	public EntityMovement getMovement() {
		return this.move;
	}

	@Override
	public EntityDirections getDirection() {
		return this.direction;
	}


	protected void setDirection(EntityDirections dir) {
		this.direction = dir;
	}


	@Override
	public boolean isLife() {
		return this.hit >= this.maxHits;
	}

	@Override
	public List<String> getStrImgs() {
		return strImgs;
	}

	@Override
	public void updateEntity(Graphics g, Entity e) {
		this.updateEntityMovement();
		this.graphics.updateGraphics(g, e);
	}

	protected abstract void updateEntityMovement();


	public abstract void changeDirection();


	public abstract void  shot();

	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}

	public EnemyType getEnemyType() {
		return this.enemyType;
	}
}

