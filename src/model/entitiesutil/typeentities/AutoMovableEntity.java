package model.entitiesutil;

/**
 * Interface that represents all the {@link Entity} that must move automatically
 */
public interface AutoMovableEntity {

	/**
	 * Update {@link AutoMovableEntity} position according its direction
	 */
	void updateEntityPos();

}