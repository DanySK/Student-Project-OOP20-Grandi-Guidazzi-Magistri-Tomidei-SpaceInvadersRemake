package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss1 extends Enemy {

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int MAX_SPEED = 0;
	private final int MAX_HITS = 0;

	private EntityDirections direction;
	private int speed;
	private List<String> strImgs;

	private List<String> bulletImg;

	public Boss1(Pair<Integer,Integer> pos) {
		this.strImgs = new ArrayList<>();
		this.create(EnemyType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, 
				this.INITIAL_MU_Y, this.MAX_HITS, this.strImgs, this.direction, new GraphicsComponentAwt(this.strImgs),
				new EntityMovementImpl());
		this.speed = 6;
		this.direction = EntityDirections.RIGHT;

		this.bulletImg = new ArrayList<>();
	}

	@Override
	public void changeDirection() {
		this.getMovement().moveDown(this);
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.RIGHT);
		}
		if(this.speed < this.MAX_SPEED) {
			this.speed++;
		}
	}

	@Override
	protected void updateEntityMovement() {
		switch(this.getDirection()) {
			case LEFT:
				this.getMovement().moveLeft(this);
				break;
			case RIGHT:
				this.getMovement().moveRight(this);
				break;
			case DOWN:
				this.getMovement().moveDown(this);
				break;
			default:
				break;
		}
	}


	@Override
	public void shot() {
		/*this.bullets.add(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 -1,
				this.getY() + this.getHeight()), this.bulletImg));*/
	}


}
