package model.entities;

import model.entitiesutil.Bullet;
import model.entitiesutil.GenericEntityType;

/**
 * Possible specific type of the {@link GenericEntity}
 */
public enum SpecificEntityType {

	/**
	 * {@link Alien}
	 */
	ALIEN(GenericEntityType.GENERIC_ENEMY, 0),

	/**
	 * {@link Boss1}
	 */
	BOSS_1(GenericEntityType.BOSS, 0),

	/**
	 * {@link Boss2}
	 */
	BOSS_2(GenericEntityType.BOSS, 0),

	/**
	 * {@link Boss3}
	 */
	BOSS_3(GenericEntityType.BOSS, 0),

	/**
	 * {@link Player}
	 */
	PLAYER_1(GenericEntityType.PLAYER),

	/**
	 * {@link Alien}'s {@link Bullet}
	 */
	ALIEN_BULLET(GenericEntityType.ENEMY_BULLET),

	/**
	 * {@link Boss1}'s {@link Bullet}
	 */
	BOSS_1_BULLET(GenericEntityType.ENEMY_BULLET),

	/**
	 * {@link Boss2}'s {@link Bullet}
	 */
	BOSS_2_BULLET(GenericEntityType.ENEMY_BULLET),

	/**
	 * {@link Boss3}'s {@link Bullet}
	 */
	BOSS_3_BULLET(GenericEntityType.ENEMY_BULLET),

	/**
	 * {@link Player}'s {@link Bullet}
	 */
	PLAYER_1_BULLET(GenericEntityType.PLAYER_BULLET);


	private final GenericEntityType type;
	private final int entityValue;

	/**
	 * Possible specific type of the {@link GenericEntity}
	 */
	private SpecificEntityType(GenericEntityType actualType, int entityValue) {
		this.type = actualType;
		this.entityValue = entityValue;
	}

	private SpecificEntityType(GenericEntityType actualType) {
		this.type = actualType;
		this.entityValue = 0;
	}

	/**
	 * Returns the type of entity it belongs to
	 * 
	 * @return a value of {@link GenericEntityType}
	 */
	public GenericEntityType getGenericType() {
		return this.type;
	}

	public int getEntityValue() {
		return this.entityValue;
	}
	
	
}
