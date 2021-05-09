package model.entitiesutil.typeentities;


/**
 * Interface that represents all the {@link GenericEntity} that must move automatically
 */
public interface AutoMovableEntity extends MobileEntity {

	/**
	 * Update {@link AutoMovableEntity} position according its direction
	 */
	void updateEntityPosition();

}