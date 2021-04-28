package model.entities;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import graphics.EntityGraphics;
import menu.Board;
import model.entitiesutil.Entity;
import model.entitiesutil.Entity.EntityType;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovement;
import util.Pair;

public class Player{

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
	
	/**
	 * The Constractor that create the Player.
	 * @param position
	 */
	public Player(Pair<Integer,Integer> position) {
		this.create(position, this.movimentUnitX, this.movimentUnitY, this.height, this.width, this.hit, 
				this.maxHits, this.strImages, this.graphics, this.move);
	}
	
	/**
	 * The Method create a new object Player.
	 * @param pos
	 * @param movimentUnitX2
	 * @param movimentUnitY2
	 * @param height
	 * @param width
	 * @param hit
	 * @param maxHits
	 * @param listImages
	 * @param graphics
	 * @param move
	 * @param dir
	 */
	private void create(Pair<Integer,Integer> pos, int movimentUnitX2, int movimentUnitY2, int height, int width, int hit, int maxHits, 
			List<String> listImages, EntityGraphics graphics, EntityMovement move) {
		this.entityType = EntityType.PLAYER;
		this.position = new Pair<>(pos.getX(), pos.getY());
		this.movimentUnitX = movimentUnitX2;
		this.movimentUnitY = movimentUnitY2;
		this.height = height;
		this.width = width;
		this.hit = 0;
		this.maxHits = maxHits;
		this.graphics = graphics;
		this.move = move;
	}
	
	
	public Pair<Integer, Integer> getPos() {
		return this.position;
	}

	
	public void setPos(Pair<Integer, Integer> pos) {
		pos.setBoth(pos.getX(), pos.getY());
	}

	
	public int getX() {
		return this.position.getX();
	}

	
	public int getY() {
		return this.position.getY();
	}

	
	public void setX(int x) {
		this.position.setX(x);
	}

	
	public void setY(int y) {
		this.position.setY(y);
	}

	
	public int getWidth() {
		return this.width;
	}

	
	public int getHeight() {
		return this.height;
	}

	
	public int getMuX() {
		return this.movimentUnitX;
	}

	
	public void setMuX(int mux) {
		this.movimentUnitX = mux;
	}

	
	public double getMuY() {
		return this.movimentUnitY;
	}

	
	public void setMuY(int muy) {
		this.movimentUnitY = muy;
	}

	
	public boolean isAlive() {
		return this.hit >= this.maxHits;
	}


	
	public EntityMovement getMovementImpl() {
		return this.move;
	}


	
	public void updateEntity(Graphics g, Entity e) {
		this.graphics.updateGraphics(g, e);
	}



	public EntityType getEntityType() {
		return this.entityType;
	}

	
	public void setEntityStrImgs(List<String> newEntityStrImg) {
		
	}
	
	public void moveRight() {
		this.setX(this.getX() + this.getMuX()); //setMuX(5)
	}
	
	public void moveLeft() {
		this.setX(this.getX() - this.getMuX());//setMux(-5)
	}
	
}
