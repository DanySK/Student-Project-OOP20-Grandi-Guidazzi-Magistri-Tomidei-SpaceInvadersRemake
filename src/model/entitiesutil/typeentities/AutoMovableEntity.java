package model.entitiesutil.typeentities;


/**
 * Interface that represents all the {@link GenericEntity} that must move automatically
 */
public interface AutoMovableEntity extends MobileEntity {

	/**
	 * Update {@link AutoMovableEntity} position according its direction
	 */
	public void updateEntityPosition();


	/**
	 * Return the implementation of {@link EntityMovement} 
	 * 
	 * @return the object which represents the {@link EntityMovement} implementation
	 */
	public EntityMovement getMovementMenager();
=======
>>>>>>> b3813f813a63a3a18648ae96cf61084397c06ea0
}