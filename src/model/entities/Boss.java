package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.EntitiesGraphics;
import graphics.GraphicsComponentAwt;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovement;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss extends Entity implements Enemy {

	private final int BOSS_INITIAL_WIDTH = 0;
	private final int BOSS_INITIAL_HEIGHT = 0;
	private final int BOSS_INITIAL_BOSS_MU_X = 0;
	private final int BOSS_INITIAL_BOSS_MU_Y = 0;
	private final int BOSS_MAX_SPEED = 0;

	private EntityDirections direction;
	private int speed;
	private List<String> strImgs;

	public Boss(Pair<Integer,Integer> pos) {
		this.strImgs = new ArrayList<>();
		this.create(pos, this.BOSS_INITIAL_WIDTH, this.BOSS_INITIAL_HEIGHT, this.BOSS_INITIAL_BOSS_MU_X, 
				this.BOSS_INITIAL_BOSS_MU_Y, this.strImgs, new GraphicsComponentAwt(this.strImgs),
				new EntityMovementImpl());
		this.speed = 6;
		this.direction = EntityDirections.LEFT;
	}

	@Override
	public void changeDirection() {
		if(this.direction == EntityDirections.LEFT) {
			this.direction = EntityDirections.RIGHT;
		}
		else {
			this.direction = EntityDirections.RIGHT;
		}
		if(this.speed < this.BOSS_MAX_SPEED) {
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

}
