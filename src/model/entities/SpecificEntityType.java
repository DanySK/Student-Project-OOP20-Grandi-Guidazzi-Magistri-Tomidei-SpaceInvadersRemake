package model.entities;

import model.entitiesutil.Bullet;
import model.entitiesutil.GenericEntityType;

/**
 * Possible specific type of the {@link GenericEntity}
 */
public enum SpecificEntityType {

	ALIEN(GenericEntityType.GENERIC_ENEMY),

	/**
	 * {@link Boss1}
	 */
	BOSS_1(GenericEntityType.BOSS),

	/**
	 * {@link Boss2}
	 */
	BOSS_2(GenericEntityType.BOSS),

	/**
	 * {@link Boss3}
	 */
	BOSS_3(GenericEntityType.BOSS),

	/**
	 * {@link Player}
	 */
	PLAYER_1(GenericEntityType.PLAYER),

	ALIEN_BULLET(GenericEntityType.BULLET),

	/**
	 * {@link Boss1}'s {@link Bullet}
	 */
	BOSS_1_BULLET(GenericEntityType.BULLET),

	/**
	 * {@link Boss2}'s {@link Bullet}
	 */
	BOSS_2_BULLET(GenericEntityType.BULLET),

	/**
	 * {@link Boss3}'s {@link Bullet}
	 */
	BOSS_3_BULLET(GenericEntityType.BULLET),

	/**
	 * {@link Player}'s {@link Bullet}
	 */
	PLAYER_BULLET(GenericEntityType.BULLET);


	private final GenericEntityType type;

	/**
	 * Possible specific type of the {@link GenericEntity}
	 */
	private SpecificEntityType(GenericEntityType actualType) {
		this.type = actualType;
	}

	/**
	 * Returns the type of entity it belongs to
	 * 
	 * @return a value of {@link GenericEntityType}
	 */
	public GenericEntityType getGenericType() {
		return this.type;
	}
	
	
}
