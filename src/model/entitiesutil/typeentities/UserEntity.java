package model.entitiesutil.typeentities;

import model.entitiesutil.EntityDirections;

/**
 * Interface that represents all the {@link GenericEntity} that the user can move
 */
public interface UserEntity extends MobileEntity, EntityCapableShooting {

	/**
	 * Update {@link UserEntity} position according its direction
	 */
	void updateEntityPosition(EntityDirections direction);
}
