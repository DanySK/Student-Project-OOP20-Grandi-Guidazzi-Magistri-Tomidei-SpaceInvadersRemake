package model;

import java.util.Optional;

import model.entities.SpecificEntityType;

/**
 * {@link Level} implementation
 *
 */
public class LvImpl implements Level{
		
	private Optional<String> bossType;
	private int aliens;
	
	/**
	 * {@link Level} implementation
	 * @param boss
	 * @param aliens
	 */
	public LvImpl(String boss, int aliens) {
		this.bossType = Optional.ofNullable(boss); //if bossType is null it contains an optional empty else a string
		this.aliens= aliens;
	}
	
	public LvImpl(int levelNum) {
		switch(levelNum) {
			case 2:
				this.bossType = Optional.ofNullable(SpecificEntityType.BOSS_1.toString());
				break;
			case 4:
				this.bossType = Optional.ofNullable(SpecificEntityType.BOSS_2.toString());
				break;
			case 6:
				this.bossType = Optional.ofNullable(SpecificEntityType.BOSS_3.toString());
				break;
			default:
				this.bossType = Optional.empty();
				this.aliens = 30;
				break;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getAliens() {
		return this.aliens;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<String> getBoss() {
		return this.bossType;
	}
	
}
