package model.entitiesutil;

/**
 * Interface that represents all the {@link Entity} that the user can move
 */
public interface UserEntity {

	/**
	 * Update {@link UserEntity} position according its direction
	 */
	void updateEntityPos(EntityDirections direction);
}
