package model.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss extends Entity implements Enemy {

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int MAX_SPEED = 0;
	private final int MAX_HITS = 0;

	private EntityDirections direction;
	private int speed;
	private int hit;
	private List<String> strImgs;

	private List<String> bulletImg;

	public Boss(Pair<Integer,Integer> pos) {
		this.strImgs = new ArrayList<>();
		this.create(pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, 
				this.INITIAL_MU_Y, this.strImgs, new GraphicsComponentAwt(this.strImgs),
				new EntityMovementImpl());
		this.hit = 0;
		this.speed = 6;
		this.direction = EntityDirections.RIGHT;

		this.bulletImg = new ArrayList<>();
	}

	@Override
	public void changeDirection() {
		this.getMove().moveDown(this);
		if(this.direction.equals(EntityDirections.LEFT)) {
			this.direction = EntityDirections.RIGHT;
		}
		else {
			this.direction = EntityDirections.RIGHT;
		}
		if(this.speed < this.MAX_SPEED) {
			this.speed++;
		}
	}

	@Override
	protected void updateEntityMovement() {
		switch(this.direction) {
			case LEFT:
				this.getMove().moveLeft(this);
				break;
			case RIGHT:
				this.getMove().moveRight(this);
				break;
			case DOWN:
				this.getMove().moveDown(this);
				break;
			default:
				break;
		}
	}

	@Override
	public void hit() {
		this.hit++;
	}

	@Override
	public void death() {
		if(this.hit >= this.MAX_HITS) {
			super.setLife(false);
		}
	}

	@Override
	public void shot() {
		/*this.bullets.add(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
				this.getY() + this.getHeight()), this.bulletImg));*/
	}

	public void bulletDistruction(BossBullet bullet) {
		//this.bullets.remove(bullet);
	}

}
