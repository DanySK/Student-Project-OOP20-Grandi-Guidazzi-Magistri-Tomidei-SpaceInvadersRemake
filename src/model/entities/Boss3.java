package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.GraphicsComponentAwt;
import model.entitiesutil.BossState;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class Boss3 extends Enemy{

	private final int INITIAL_WIDTH = 0;
	private final int INITIAL_HEIGHT = 0;
	private final int INITIAL_MU_X = 0;
	private final int INITIAL_MU_Y = 0;
	private final int MAX_SPEED = 0;
	private final int HITS_2ND_PHASE = 0;
	private final int MAX_HITS = 0;

	private List<String> strImg;
	private int speed;
	private EntityDirections direction;
	private BossState state;
	private Random random;

	private List<String> bulletStrImg;

	public Boss3(Pair<Integer, Integer> pos) {
		this.strImg = new ArrayList<>();
		this.strImg.add("");
		super.create(EnemyType.BOSS, pos, this.INITIAL_WIDTH, this.INITIAL_HEIGHT, this.INITIAL_MU_X,this.INITIAL_MU_Y, 
				this.MAX_HITS, this.strImg, this.direction, new GraphicsComponentAwt(this.strImg), new EntityMovementImpl());
		this.speed = 4;
		this.direction = EntityDirections.LEFT;
		this.state = BossState.NORMAL;
		this.random = new Random();

		this.bulletStrImg = new ArrayList<>();
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
		this.bulletStrImg.add("");
	}

	@Override
	protected void updateEntityMovement() {
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			this.speed = this.MAX_SPEED;
		}
		if(this.direction.equals(EntityDirections.LEFT)) {
			this.getMovement().moveLeft(this);
		}
		else {
			this.getMovement().moveRight(this);
		}
	}

	@Override
	public void changeDirection() {
		this.getMovement().moveDown(this);
		if(this.direction.equals(EntityDirections.LEFT)) {
			this.setDirection(EntityDirections.RIGHT);
		}
		else {
			this.setDirection(EntityDirections.LEFT);
		}
	}

	@Override
	public void shot() {
		/*(new BossBullet(new Pair<>(this.getX() + this.getWidth()/2 - 1, 
		this.getY() + this.getHeight()), this.bulletStrImg));*/
	}

	private void changeState() {
		if(this.getHits() >= this.HITS_2ND_PHASE) {
			this.state = BossState.UPSET;
		}
	}

	public void teleport(int minX, int maxX) {
		int x;

		if(this.state.equals(BossState.UPSET)) {

			do {
				x = this.random.nextInt(maxX);
			}while(x <= minX + this.getWidth());

			this.setX(x);
		}
		this.updateEntityMovement();
	}

	public int getSpeed() {
		return this.speed;
	}

}
