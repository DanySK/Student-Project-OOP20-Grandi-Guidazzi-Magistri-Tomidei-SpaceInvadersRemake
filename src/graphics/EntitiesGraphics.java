package graphics;

import model.entities.Entity;

public interface EntitiesGraphics {

	public void updateGraphics(Entity e);

	public void switchImage(Entity e, String strImg);
	
}
