package model.entities;

import java.awt.Graphics;
import java.util.List;

import graphics.EntityGraphics;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovement;
import util.Pair;

public class Player implements Entity{

	private EntityType entityType;
	private Pair<Integer,Integer> position;
	private int movimentUnitX;
	private int movimentUnitY;
	private int height;
	private int width;
	private int hit;
	private int maxHits;
	private List<String> strImages;
	private EntityGraphics graphics;
	private EntityMovement move;
	private EntityDirections direction;
	
	
	public Player(Pair<Integer,Integer> position) {
		this.create(position, this.movimentUnitX, this.movimentUnitY, this.height, this.width, this.hit, 
				this.maxHits, this.strImages, this.graphics, this.move, this.direction);
	}
	
	private void create(Pair<Integer,Integer> pos, int movimentUnitX, int movimentUnitY, int height, int width, int hit, int maxHits, 
			List<String> listImages, EntityGraphics graphics, EntityMovement move, EntityDirections dir) {
		this.entityType = EntityType.PLAYER;
		this.movimentUnitX = movimentUnitX;
		this.movimentUnitY = movimentUnitY;
		this.height = height;
		this.width = width;
		this.hit = 0;
		this.maxHits = maxHits;
		this.graphics = graphics;
		this.move = move;
		this.direction = dir;
	}
	
	@Override
	public Pair<Integer, Integer> getPos() {
		return this.position;
	}

	@Override
	public void setPos(Pair<Integer, Integer> pos) {
		
	}

	@Override
	public int getX() {
		return this.position.getX();
	}

	@Override
	public int getY() {
		return this.position.getY();
	}

	@Override
	public void setX(int x) {
		this.position.setX(x);
	}

	@Override
	public void setY(int y) {
		this.position.setY(y);
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
		return this.movimentUnitX;
	}

	@Override
	public void setMuX(int mux) {
		this.movimentUnitX = mux;
	}

	@Override
	public int getMuY() {
		return this.movimentUnitY;
	}

	@Override
	public void setMuY(int muy) {
		this.movimentUnitY = muy;
	}

	@Override
	public boolean isLife() {
		return this.hit >= this.maxHits;
	}

	@Override
	public List<String> getStrImgs() {
		return this.strImages;
	}

	@Override
	public EntityMovement getMovementImpl() {
		return this.move;
	}

	@Override
	public EntityDirections getDirection() {
		return this.direction;
	}

	@Override
	public void updateEntity(Graphics g, Entity e) {
		this.graphics.updateGraphics(g, e);
	}

	@Override
	public void updateEntityPos() {
		
	}

	@Override
	public EntityType getEntityType() {
		return this.entityType;
	}

	
}
