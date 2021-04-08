package model.entities;

import util.Pair;

import java.awt.Graphics;
import java.util.List;

import graphics.EntitiesGraphics;
import model.physics.EntityMovement;

public abstract class Entity {

	private Pair<Integer,Integer> pos;
	private int width, height, muX, muY;
	private boolean life;
	private List<String> strImgs;
	private EntitiesGraphics graphics;
	private EntityMovement move;

	protected void create(Pair<Integer,Integer> pos, int width,int height, int muX, int muY,
			List<String> liststr, EntitiesGraphics graph, EntityMovement move) {
		this.width = width;
		this.height = height;
		this.pos = pos;
		this.muX = muX;
		this.muY = muY;
		this.strImgs = liststr;
		this.graphics = graph;
		this.move = move;
		this.life = true;
	}

	public Pair<Integer, Integer> getPos() {
		return pos;
	}

	public void setPos(Pair<Integer, Integer> pos) {
		this.pos = pos;
	}

	public int getX() {
		return this.pos.getX();
	}

	public int getY() {
		return this.pos.getY();
	}

	public void setX(int x) {
		this.pos.setX(x);
	}

	public void setY(int y) {
		this.pos.setY(y);
	}

	public int getWidth() {
		return this.width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMuX() {
		return muX;
	}

	public void setMuX(int mux) {
		this.muX = mux;
	}

	public int getMuY() {
		return muY;
	}

	public void setMuY(int muy) {
		this.muY = muy;
	}

	public boolean isLife() {
		return life;
	}

	public void setLife(boolean life) {
		this.life = life;
	}

	public List<String> getStrImgs() {
		return strImgs;
	}

	public void addStrImg1(String strImg1) {
		this.strImgs.add(strImg1);
	}

	public EntityMovement getMove() {
		return this.move;
	}

	public void updateEntity(Graphics g, Entity e) {
		this.updateEntityMovement();
		this.graphics.updateGraphics(g, e);
	}

	protected abstract void updateEntityMovement();
}
