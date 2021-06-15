package model.entities;

import model.Model;
import model.entitiesutil.Enemy;
import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.bossutil.BossState;
import model.entitiesutil.typeentities.GenericEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovementImpl;

/**
 * {@link Enemy} boss with a lot of life but that moves slowly
 */
public class Boss2 extends Enemy{

	private final Model model;
	private boolean isAlreadyUpset;
	private BossState state;

	/**
	 * {@link Enemy} boss with a lot of life but that moves slowly
	 * 
	 * @param x is the initial x coordinate
	 * @param y is the initial y coordinate
	 */
	public Boss2(int x, int y, Model model) {
		this.create(SpecificEntityType.BOSS_2, x, y, EntityConstants.Boss2.INITIAL_WIDTH, 
				EntityConstants.Boss2.INITIAL_HEIGHT, EntityConstants.Boss2.INITIAL_MU_X, 
				EntityConstants.Boss2.INITIAL_MU_Y, EntityConstants.Boss2.MAX_HITS, EntityDirections.DOWN, 
				new EntityMovementImpl());
		this.state = BossState.NORMAL;
		this.isAlreadyUpset = false;
		this.model = model;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void changeDirection() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityPosition() {
		this.changeState();
		if(this.state.equals(BossState.UPSET)) {
			this.getMovementMenager().moveDown(this);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void shoot() {
		this.model.getNewEntity().add(new MultiDirectionsEnemyBullet( this.getX() + this.getWidth()/4 - 1,
				this.getY() + this.getHeight() + EntityConstants.MultiDirectionEnemyBullet.INITIAL_HEIGHT / 2, 
				SpecificEntityType.BOSS_2_BULLET));
		this.model.getNewEntity().add(new MultiDirectionsEnemyBullet( this.getX() + this.getWidth()* 3/4 - 1,
				this.getY() + this.getHeight() + EntityConstants.MultiDirectionEnemyBullet.INITIAL_HEIGHT / 2, 
				SpecificEntityType.BOSS_2_BULLET));
	}

	/**
	 * Change the state of the boss after it took too many hits 
	 */
	private void changeState() {
		if(this.getHits() >= EntityConstants.Boss2.HITS_2ND_PHASE && !isAlreadyUpset) {
			this.state = BossState.UPSET;
			this.isAlreadyUpset = true;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().equals(SpecificEntityType.PLAYER_1_BULLET) && this.isAlive()) {
			this.incHit();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doAfterCollisionWithEdge(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.DOWN)) {
			this.model.processGameOver();
		}
	}
}
