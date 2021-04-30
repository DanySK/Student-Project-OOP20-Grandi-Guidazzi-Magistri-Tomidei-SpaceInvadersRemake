package model.physics;

import model.entitiesutil.Entity;

/**
 * Interface to check collisions
 */
public interface EntityCollision {

	/**
	 * Possible edges that can collide with {@link Entity}
	 */
	public enum EdgeCollision{

		/**
		 * Left edge
		 */
		LEFT,

		/**
		 * Right edge
		 */
		RIGHT,

		/**
		 * Top edge
		 */
		TOP,

		/**
		 * Bottom edge
		 */
		DOWN
	}

	/**
	 * Check collision between all the entities in the level that is running
	 */
	public void checkCollision();

	/**
	 * Check collision between a specific entity in the level that is running
	 * 
	 * @param e is the {@link Entity} implementation that need to be checked
	 */
	public void checkCollision(Entity e);
	
}
