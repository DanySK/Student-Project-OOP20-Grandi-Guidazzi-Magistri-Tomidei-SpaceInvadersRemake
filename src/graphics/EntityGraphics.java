package graphics;

import java.awt.Graphics;
import java.util.List;

import model.entitiesutil.Entity;

/**
 * Interface for {@link Entity} update
 */
public interface EntityGraphics {

	/**
	 * Update the entity's graphics 
	 * 
	 * @param g is the type of graphics used for draw the {@link Entity}'s image
	 * @param e is the {@link Entity} that need to be updated
	 */
	public void updateGraphics(Graphics g, Entity e);

	/**
	 * Set the images's paths of the {@link Entity}
	 * 
	 * @param newEntityStrImg is the new images's path of the entity
	 */
	public void setEntityStrImgs(List<String> newEntityStrImg);

}
