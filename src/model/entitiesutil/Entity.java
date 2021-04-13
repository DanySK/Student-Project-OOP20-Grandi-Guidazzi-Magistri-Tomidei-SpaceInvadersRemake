package model.entitiesutil;

import util.Pair;

import java.awt.Graphics;
import java.util.List;

import graphics.EntitiesGraphics;
import model.physics.EntityMovement;

public interface Entity {


	public Pair<Integer, Integer> getPos();


	public void setPos(Pair<Integer, Integer> pos);


	public int getX();


	public int getY();


	public void setX(int x);


	public void setY(int y);


	public int getWidth();


	public int getHeight();


	public int getMuX();


	public void setMuX(int mux);


	public int getMuY();


	public void setMuY(int muy);


	public boolean isLife();


	public List<String> getStrImgs();


	public EntityMovement getMove();


	public void updateEntity(Graphics g, Entity e);

}
