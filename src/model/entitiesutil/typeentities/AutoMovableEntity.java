package model.entitiesutil.typeentities;

import model.physics.EntityMovement;

/**
 * Interface that represents all the {@link GenericEntity} that must move automatically
 */
public interface AutoMovableEntity extends MobileEntity {

	/**
	 * Update {@link AutoMovableEntity} position according its direction
	 */
	void updateEntityPosition();

	/**
	 * Return the implementation of {@link EntityMovement} 
	 * 
	 * @return the object which represents the {@link EntityMovement} implementation
	 */
	public EntityMovement getMovementImpl();
}