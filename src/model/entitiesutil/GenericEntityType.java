package model.entitiesutil;

import model.entities.Player;
import model.entitiesutil.typeentities.GenericEntity;

/**
 * Possible generic types of the {@link GenericEntity}
 */
public enum GenericEntityType{

	/**
	 * {@link Enemy}
	 */
	GENERIC_ENEMY,

	/**
	 * {@link Enemy} boss
	 */
	BOSS,

	/**
	 * {@link Player}
	 */
	PLAYER,

	/**
	 * {@link Bullet}
	 */
	BULLET,
}