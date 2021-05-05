package model.entitiesutil;

import util.Pair;

import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovement;

/**
 * Interface that represents any object inside the game.
 */
public interface Entity {

	/**
	 * Return  the current position (from top left) of the {@link Entity}
	 * 
     * @return the {@link Pair} of Integers which represents the current position of the {@link Entity}
     *        
     */
	public Pair<Double, Double> getPos();

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
	public double getX();

	/**
	 * Return the current y position (from top) of the {@link Entity}
	 * 
	 * @return the integer which represents {@link Entity}'s y position
	 */
	public double getY();

	/**
	 * Set {@link Entity}'s x position (from left) with the method input value
	 *
	 * @param x integer which represents the new x position (from left) of the {@link Entity}
	 */
	public void setX(double x);

	/**
	 * Set {@link Entity}'s y position (from top) with the method input value
	 * 
	 * @param y integer which represents the new y position (from top) of the {@link Entity}
	 */
	public void setY(double y);

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
	public double getMuX();

	/**
	 * Update the movement unit of the {@link Entity} along x-axis with method input value
	 * 
	 * @param mux integer which is the new movement unit of the {@link Entity} along x-axis
	 */
	public void setMuX(double mux);

	/**
	 * Return the movement unit of the {@link Entity} along y-axis
	 * 
	 * @return the integer which represents the movement unit of the {@link Entity} along y-axis
	 */
	public double getMuY();

	/**
	 * Update the movement unit of the {@link Entity} along x-axis
	 * 
	 * @param mux 	new movement unit of the {@link Entity} along x-axis
	 */
	public void setMuY(double muy);

	/**
	 * Return true if {@link Entity} is alive, false otherwise
	 * 
	 * @return a boolean which represents if {@link Entity} is alive
	 */
	public boolean isAlive();

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
	 * Update {@link Entity} position according its direction
	 */
	public void updateEntityPos();

	/**
	 * {@link Entity} does a specific action based on 
	 * the {@link Entity} it collided with
	 * 
	 * 
	 * @param entity that collided with the {@link Entity}
	 */
	public void doAfterCollisionWith(Entity entity);

	/**
	 * {@link Entity} does a specific action based on 
	 * the edge it collided with
	 * 
	 * @param edge where the {@link Entity} collided
	 */
	public void doAfterCollisionWith(EdgeCollision edge);

	/**
	 * Return the types of {@link Entity}
	 * 
	 * @return a value of {@link EntityType} which represents the {@link Entity} type
	 */
	public EntityType getEntityType();

}
