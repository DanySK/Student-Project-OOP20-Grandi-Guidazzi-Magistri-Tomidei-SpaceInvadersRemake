package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Enemy} boss with a lot of life but that moves slowly
 */
public class Boss2 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private List<String> strImg;
	private BossState state;

	private List<String> bulletStrImg;

	/**
	 * {@link Enemy} boss with a lot of life but that moves slowly
	 * 
	 * @param pos is the initial position of this entity
	 */
	public Boss2(Pair<Integer, Integer> pos) {
		this.strImg = new ArrayList<>();
		this.strImg.add("");
		this.create(EntityType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, this.INITIAL_MU_Y,
				this.MAX_HITS, this.strImg, EntityDirections.DOWN, new EntityGraphicsImpl(this.strImg), new EntityMovementImpl());
		this.state = BossState.NORMAL;

		this.bulletStrImg = new ArrayList<>();
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeDirection() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			this.getMovementImpl().moveDown(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/4 - 1, 
				this.getY() + this.getHeight()), this.bulletStrImg));
		(new BossBullet(new Pair<>(this.getX() + this.getWidth()* 3/4 - 1,
				this.getY() + this.getHeight()), this.bulletStrImg));*/
	}

	/**
	 * Change the state of the boss after it took too many hits 
	 */
	private void changeState() {
		if(this.getHits() >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
		}
	}
}
