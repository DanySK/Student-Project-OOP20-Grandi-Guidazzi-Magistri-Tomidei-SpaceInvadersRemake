package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss2 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int SPEED = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private List<String> strImg;
	private BossState state;

	private List<String> bulletStrImg;

	public Boss2(Pair<Integer, Integer> pos) {
		this.strImg = new ArrayList<>();
		this.strImg.add("");
		this.create(EnemyType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X, this.INITIAL_MU_Y,
				this.MAX_HITS, this.strImg, EntityDirections.DOWN, new GraphicsComponentAwt(this.strImg), new EntityMovementImpl());
		this.state = BossState.NORMAL;

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
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			this.getMovement().moveDown(this);
		}
	}

	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/4 - 1, 
				this.getY() + this.getHeight()), this.bulletStrImg));
		(new BossBullet(new Pair<>(this.getX() + this.getWidth()* 3/4 - 1,
				this.getY() + this.getHeight()), this.bulletStrImg));*/
	}

	private void changeState() {
		if(this.getHits() >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
		}
	}
}
