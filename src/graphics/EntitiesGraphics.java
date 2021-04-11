package graphics;

import java.awt.Graphics;

import model.entities.Entity;

public interface EntitiesGraphics {

	public void updateGraphics(Graphics g, Entity e);

	public void switchImage(Entity e, String strImg);
	
}
