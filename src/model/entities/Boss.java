package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.EntitiesGraphics;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovement;
import util.Pair;

public class Boss extends Entity implements Enemy {

	private final int WIDTH = 0;
	private final int HEIGHT = 0;
	private final int BOSS_MU_X = 0;
	private final int BOSS_MU_Y = 0;
	private final int BOSS_MAX_SPEED = 0;

	private EntityDirections direction;
	private int speed;
	private List<String> strImgs;

	public Boss(Pair<Integer,Integer> pos, EntitiesGraphics graph, EntityMovement move) {
		strImgs = new ArrayList<>();
		super.create(pos, this.WIDTH, this.HEIGHT, this.BOSS_MU_X, this.BOSS_MU_Y,
				this.strImgs, graph, move);
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
