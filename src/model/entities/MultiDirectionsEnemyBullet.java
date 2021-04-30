package model.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.Bullet;
import model.entitiesutil.Entity;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.Entity.EntityType;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;
import util.Pair;

/**
 * {@link Bullet} with multiple direction
 */
public class MultiDirectionsEnemyBullet extends Bullet {

	private final int BULLET_INITIAL_WIDTH = 0;
	private final int BULLET_INITIAL_HEIGHT = 0;
	private final double BULLET_INITIAL_MU_X = 0;
	private final double BULLET_MAX_MU_Y = 0;
	private List<String> bulletStrImgs;
	private EntityDirections direction;
	private Random random;

	/**
	 * {@link Bullet} with multiple direction
	 * 
	 * @param pos		is the {@link Bullet} initial position
	 * @param strImg	are the images's paths of the {@link Bullet} 
	 */
	protected MultiDirectionsEnemyBullet(Pair<Double, Double> pos, List<String> strImg) {
		this.random = new Random();
		this.bulletStrImgs = new ArrayList<>();
		this.randomBulletImg(strImg);
		this.create(EntityType.ENEMY_BULLET, pos, this.BULLET_INITIAL_WIDTH, this.BULLET_INITIAL_HEIGHT, this.BULLET_INITIAL_MU_X,
				(this.random.nextInt((int)this.BULLET_MAX_MU_Y) + 1), this.direction, new EntityGraphicsImpl(this.bulletStrImgs),
				new EntityMovementImpl());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPos() {
		switch(this.getDirection()) {
			case DOWN_LEFT:
				this.getMovementImpl().moveBottomLeft(this);
				break;
			case DOWN_RIGHT:
				this.getMovementImpl().moveBottomRight(this);
				break;
			default:
				this.getMovementImpl().moveDown(this);
				break;
		}
	}

	/**
	 * Method that select a random image's path from an input list,
	 * and change the {@link Bullet} direction according to the image's path
	 * 
	 * @param newStrImg is the new image's path of the bullet
	 */
	private void randomBulletImg(List<String> newStrImg) {
		switch(this.random.nextInt(newStrImg.size())) {
			case 1:
				this.direction = EntityDirections.DOWN_LEFT;
				this.bulletStrImgs.add(newStrImg.get(1));
				break;

			case 2:
				this.direction = EntityDirections.DOWN_RIGHT;
				this.bulletStrImgs.add(newStrImg.get(2));
				break;

			default:
				this.direction = EntityDirections.DOWN;
				this.bulletStrImgs.add(newStrImg.get(0));
				break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWith(Entity entity) {
		if(entity.getEntityType().equals(EntityType.PLAYER)) {
			this.setLife();
		}
	}

}
