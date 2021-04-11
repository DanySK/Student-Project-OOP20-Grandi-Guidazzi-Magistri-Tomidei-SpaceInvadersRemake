package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.GraphicsComponentAwt;
import model.physics.EntityMovementImpl;
import util.Pair;

public class BossLevel2 extends Entity implements Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int SPEED = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private List<String> strImg;
	private int hit;

	private List<String> bulletStrImg;

	public BossLevel2(Pair<Integer, Integer> pos) {
		this.strImg = new ArrayList<>();
		this.strImg.add("");
		this.create(pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, this.INITIAL_MU_Y,
				this.strImg, new GraphicsComponentAwt(this.strImg), new EntityMovementImpl());
		this.hit = 0;

		this.bulletStrImg = new ArrayList<>();
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");

	}

	@Override
	public void changeDirection() {
	}

	@Override
	protected void updateEntityMovement() {
		if(this.hit >= this.HITS_2ND_PHASE) {
			this.getMove().moveDown(this);
		}
	}

	@Override
	public void hit() {
		this.hit++;
	}

	public void death() {
		if(this.hit >= this.MAX_HITS) {
			super.setLife(true);
		}
		
	}

	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/4 - 1, 
				this.getY() + this.getHeight()), this.bulletStrImg));
		(new BossBullet(new Pair<>(this.getX() + this.getWidth()* 3/4 - 1,
				this.getY() + this.getHeight()), this.bulletStrImg));*/
	}

	public int getSpeed() {
		return this.SPEED;
	}
}
