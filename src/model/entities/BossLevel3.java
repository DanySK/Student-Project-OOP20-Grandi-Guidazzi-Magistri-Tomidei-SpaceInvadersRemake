package model.entities;

import java.util.List;

import model.entitiesutil.BossState;
import model.entitiesutil.EntityDirections;

public class BossLevel3 extends Entity{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int MAX_SPEED = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private List<String> strImg;
	private int hit;
	private int speed;
	private EntityDirections direction;
	private BossState state;

	@Override
	protected void updateEntityMovement() {
		if(this.state == BossState.UPSET) {
			this.speed = this.MAX_SPEED;
		}
		if(this.direction == EntityDirections.LEFT) {
			this.getMove().moveLeft(this);
		}
		else {
			this.getMove().moveRight(this);
		}
	}

}
