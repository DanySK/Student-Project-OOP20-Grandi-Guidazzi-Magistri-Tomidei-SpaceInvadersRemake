package model.entitiesutil.typeentities;

/**
 * Interface that represents all the {@link GenericEntity} that the user can move
 */
public interface UserEntity extends MobileEntity, EntityCapableOfShooting {

	/**
	 * Update {@link UserEntity} position
	 */
	void updateEntityPosition();
}
