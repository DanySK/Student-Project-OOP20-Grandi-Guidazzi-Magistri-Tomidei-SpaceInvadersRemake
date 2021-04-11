package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.BossState;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class BossLevel3 extends Entity implements Enemy{

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

	private List<String> bulletStrImg;

	public BossLevel3(Pair<Integer, Integer> pos) {
		this.strImg = new ArrayList<>();
		this.strImg.add("");
		super.create(pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X,this.INITIAL_MU_Y, 
				this.strImg, new GraphicsComponentAwt(this.strImg), new EntityMovementImpl());
		this.hit = 0;
		this.speed = 4;
		this.direction = EntityDirections.LEFT;
		this.state = BossState.NORMAL;

		this.bulletStrImg = new ArrayList<>();
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
	}

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

	@Override
	public void changeDirection() {
		if(this.direction == EntityDirections.LEFT) {
			this.direction = EntityDirections.RIGHT;
		}
		else {
			this.direction = EntityDirections.LEFT;
		}
	}

	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 - 1, 
		this.getY() + this.getHeight()), this.bulletStrImg));*/
	}

	@Override
	public void hit() {
		this.hit++;
	}

	@Override
	public void death() {
		if(this.hit >= this.MAX_HITS) {
			this.setLife(false);
		}
	}

	public void changeState() {
		if(this.hit >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
		}
	}

}
