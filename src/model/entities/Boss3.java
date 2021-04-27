package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss3 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final double INITIAL_MU_X = 0;
	private final double INITIAL_MU_Y = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;
	private final int MAX_SPEED = 0;

	private BossState state;
	private Random random;

	private List<String> bulletStrImg;

	public Boss3(Pair<Integer, Integer> pos) {
		List<String> strImg = new ArrayList<>();
		strImg.add("");
		EntityDirections direction = EntityDirections.LEFT;
		super.create(EntityType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X,this.INITIAL_MU_Y, 
				this.MAX_HITS, direction, new EntityGraphicsImpl(strImg), new EntityMovementImpl());
		this.state = BossState.NORMAL;
		this.random = new Random();

		this.bulletStrImg = new ArrayList<>();
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		this.changeState();
		this.teleport(0, 1);
		if(this.state.equals(BossState.UPSET)) {
			this.setMuX(this.MAX_SPEED);
		}
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.getMovementImpl().moveLeft(this);
		}
		if(this.getDirection().equals(EntityDirections.RIGHT)) {
			this.getMovementImpl().moveRight(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void changeDirection() {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.LEFT);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 - 1, 
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

	/**
	 * Teleport the boss in a range took from input
	 * 
	 * @param minX is the minimum value of the range
	 * @param maxX is the maximum value of the range
	 */
	private void teleport(int minX, int maxX) {
		double x;
		if(this.state.equals(BossState.UPSET) && (this.getHits() % this.random.nextInt(2) + 2 == 0)) {
			do {
				x = this.random.nextInt((int)(maxX - this.getMuX()));
			}while(x < minX);

			this.setX(x);
		}
	}
}
