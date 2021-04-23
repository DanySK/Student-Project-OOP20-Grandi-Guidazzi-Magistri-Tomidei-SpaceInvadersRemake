package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * Generic {@link Enemy} boss
 */
public class Boss1 extends Enemy {

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int MAX_HITS = 0;

	private EntityDirections direction;
	private List<String> strImgs;

	private List<String> bulletImg;

	/**
	 * Generic {@link Enemy} boss
	 * 
	 * @param pos is the initial position this entity
	 */
	public Boss1(Pair<Integer,Integer> pos) {
		this.strImgs = new ArrayList<>();
		this.create(EntityType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, 
				this.INITIAL_MU_Y, this.MAX_HITS, this.strImgs, this.direction, new EntityGraphicsImpl(this.strImgs),
				new EntityMovementImpl());
		this.direction = EntityDirections.RIGHT;

		this.bulletImg = new ArrayList<>();
		this.bulletImg.add("");
		this.bulletImg.add("");
		this.bulletImg.add("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeDirection() {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.RIGHT);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		if(this.direction.equals(EntityDirections.LEFT)){
			this.getMovementImpl().moveLeft(this);
		}
		if(this.direction.equals(EntityDirections.RIGHT)) {
			this.getMovementImpl().moveRight(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shot() {
		/*this.bullets.add(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
				this.getY() + this.getHeight()), this.bulletImg));*/
	}


}
