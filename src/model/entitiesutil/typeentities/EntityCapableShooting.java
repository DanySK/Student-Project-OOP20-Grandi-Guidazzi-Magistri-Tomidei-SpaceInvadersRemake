package model.entitiesutil;

/**
 * Interface that represents all the {@link Entity} that can fire
 */
public interface EntityCapableShooting {

	/**
	 * Create new {@link Bullet} according to the type of the {@link Entity}
	 */
	public void shot();

}