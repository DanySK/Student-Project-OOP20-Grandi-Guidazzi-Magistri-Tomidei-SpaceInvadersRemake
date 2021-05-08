package model.entitiesutil.typeentities;

import model.entitiesutil.Bullet;

/**
 * Interface that represents all the {@link GenericEntity} that can fire
 */
public interface EntityCapableShooting {

	/**
	 * Create new {@link Bullet} according to the type of the {@link GenericEntity}
	 */
	public void shoot();

}