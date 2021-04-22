package model.entitiesutil;

import util.Pair;

import java.awt.Graphics;
import java.util.List;

import model.physics.EntityMovement;

/**
 * Interface that represents any object inside the game.
 */
public interface Entity {

	/**
	 * Possible types of {@link Entity}
	 */
	public enum EntityType{

		/**
		 * {@link Enemy}
		 */
		GENERIC_ENEMY,

		/**
		 * {@link Enemy} boss
		 */
		BOSS,

		/**
		 * Player
		 */
		PLAYER,

		/**
		 * Generic {@link Enemy}'s {@link Bullet}
		 */
		ENEMY_BULLET,

		/**
		 * Player's bullet
		 */
		PLAYER_BULLET,
	}

	/**
	 * Return  the current position (from top left) of the {@link Entity}
	 * 
     * @return the {@link Pair} of Integers which represents the current position of the {@link Entity}
     *        
     */
	public Pair<Integer, Integer> getPos();

	/**
	 * Update the position of the {@link Entity}
	 * 
	 * @param pos is the new position
	 */
	public void setPos(Pair<Integer, Integer> pos);

	/**
	 * Return the current x position (from top left) of the {@link Entity}
	 * 
	 * @return the integer which represents the current {@link Entity}'s x position
	 */
	public int getX();


	/**
	 * Return the current y position (from top) of the {@link Entity}
	 * 
	 * @return the integer which represents {@link Entity}'s y position
	 */
	public int getY();

	/**
	 * Set {@link Entity}'s x position (from left) with the method input value
	 *
	 * @param x integer which represents the new x position (from left) of the {@link Entity}
	 */
	public void setX(int x);

	/**
	 * Set {@link Entity}'s y position (from top) with the method input value
	 * 
	 * @param y integer which represents the new y position (from top) of the {@link Entity}
	 */
	public void setY(int y);

	/**
	 * Return the current width of the {@link Entity}
	 * 
     * @return the integer which represents {@link Entity}'s current width
     */
	public int getWidth();

	/**
	 * Return the current height of the {@link Entity}
	 * 
     * @return the integer which represents {@link Entity}'s current height
     */
	public int getHeight();

	/**
	 * Return the movement unit of the {@link Entity} along x-axis
	 * 
	 * @return the integer which represents {@link Entity}'s movement unit along x-axis
	 */
	public int getMuX();

	/**
	 * Update the movement unit of the {@link Entity} along x-axis with method input value
	 * 
	 * @param mux integer which is the new movement unit of the {@link Entity} along x-axis
	 */
	public void setMuX(int mux);

	/**
	 * Return the movement unit of the {@link Entity} along y-axis
	 * 
	 * @return the integer which represents the movement unit of the {@link Entity} along y-axis
	 */
	public int getMuY();

	/**
	 * Update the movement unit of the {@link Entity} along x-axis
	 * 
	 * @param mux 	new movement unit of the {@link Entity} along x-axis
	 */
	public void setMuY(int muy);

	/**
	 * Return true if {@link Entity} is alive, false otherwise
	 * 
	 * @return a boolean which represents if {@link Entity} is alive
	 */
	public boolean isLive();

	/**
	 * Return the images's paths of the {@link Entity}
	 * 
	 * @return the List of String which represent the {@link Entity}'s images's paths
	 */
	public List<String> getStrImgs();

	/**
	 * Return the implementation of {@link EntityMovement} 
	 * 
	 * @return the object which represents the {@link EntityMovement} implementation
	 */
	public EntityMovement getMovementImpl();

	/**
	 * Return the current directions of the {@link Entity}
	 * 
	 * @return a value of {@link EntityDirections} which represents the {@link Entity}'s current direction
	 */
	public EntityDirections getDirection();

	/**
	 * Update {@link Entity} graphics
	 * 
	 * @param g		type of Graphics for {@link Entity} update
	 * @param e 	Object that need to be update
	 */
	public void updateEntity(Graphics g, Entity e);

	/**
	 * Update {@link Entity} position according its direction
	 */
	public void updateEntityPos();

	/**
	 * Return the types of {@link Entity}
	 * 
	 * @return a value of {@link EntityType} which represents the {@link Entity} type
	 */
	public EntityType getEntityType();

}
