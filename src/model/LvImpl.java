package model;

import java.util.Optional;

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
