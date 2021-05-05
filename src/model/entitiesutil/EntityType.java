package model.entitiesutil;

import model.entities.Boss1;
import model.entities.Boss2;
import model.entities.Boss3;
import model.entities.Player;

/**
 * Possible types of {@link Entity}
 */
public enum EntityType{

	/**
	 * {@link Enemy}
	 */
	GENERIC_ENEMY,

	/**
	 * {@link Boss1}
	 */
	BOSS_1,

	/**
	 * {@link Boss2}
	 */
	BOSS_2,

	/**
	 * {@link Boss3}
	 */
	BOSS_3,

	/**
	 * {@link Player}
	 */
	PLAYER,

	/**
	 * Generic {@link Enemy}'s {@link Bullet}
	 */
	ENEMY_BULLET,

	/**
	 * {@link Boss1}'s {@link Bullet}
	 */
	BOSS_1_BULLET,

	/**
	 * {@link Boss2}'s {@link Bullet}
	 */
	BOSS_2_BULLET,

	/**
	 * {@link Boss3}'s {@link Bullet}
	 */
	BOSS_3_BULLET,

	/**
	 * {@link Player}'s {@link Bullet}
	 */
	PLAYER_BULLET,
}