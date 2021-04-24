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
	private Pair<Double,Double> position;
	private double movimentUnitX;
	private double movimentUnitY;
	private int height;
	private int width;
	private int hit;
	private int maxHits;
	private List<String> strImages;
	private EntityGraphics graphics;
	private EntityMovement move;
	private EntityDirections direction;
	
	/**
	 * The Constractor that create the Player.
	 * @param position
	 */
	public Player(Pair<Integer,Integer> position) {
		this.create(position, this.movimentUnitX, this.movimentUnitY, this.height, this.width, this.hit, 
				this.maxHits, this.strImages, this.graphics, this.move, this.direction);
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
	private void create(Pair<Integer,Integer> pos, double movimentUnitX2, double movimentUnitY2, int height, int width, int hit, int maxHits, 
			List<String> listImages, EntityGraphics graphics, EntityMovement move, EntityDirections dir) {
		this.entityType = EntityType.PLAYER;
		this.position = new Pair<>((double)pos.getX(), (double)pos.getY());
		this.movimentUnitX = movimentUnitX2;
		this.movimentUnitY = movimentUnitY2;
		this.height = height;
		this.width = width;
		this.hit = 0;
		this.maxHits = maxHits;
		this.graphics = graphics;
		this.move = move;
		this.direction = dir;
	}
	
	@Override
	public Pair<Double, Double> getPos() {
		return this.position;
	}

	@Override
	public void setPos(Pair<Integer, Integer> pos) {
		
	}

	@Override
	public double getX() {
		return this.position.getX();
	}

	@Override
	public double getY() {
		return this.position.getY();
	}

	@Override
	public void setX(double x) {
		this.position.setX(x);
	}

	@Override
	public void setY(double y) {
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
	public double getMuX() {
		return this.movimentUnitX;
	}

	@Override
	public void setMuX(double mux) {
		this.movimentUnitX = mux;
	}

	@Override
	public double getMuY() {
		return this.movimentUnitY;
	}

	@Override
	public void setMuY(double muy) {
		this.movimentUnitY = muy;
	}

	@Override
	public boolean isAlive() {
		return this.hit >= this.maxHits;
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

	@Override
	public void setEntityStrImgs(List<String> newEntityStrImg) {
		
	}

	
}
