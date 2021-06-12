package model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import controller.GameController;
import model.entities.Boss1;
import model.entities.Boss2;
import model.entities.Boss3;
import model.entities.MonoDirectionEnemyBullet;
import model.entities.Player;
import model.entities.SpecificEntityType;
import model.entitiesutil.Enemy;
import model.entitiesutil.MappedEntity;
import model.entitiesutil.MappedEntityImpl;
import model.entitiesutil.typeentities.AutoMovableEntity;
import model.entitiesutil.typeentities.GenericEntity;
import model.entitiesutil.typeentities.UserEntity;
import model.physics.EntityCollision;
import model.physics.EntityCollisionImpl;
import util.Pair;


@SuppressWarnings("unused")
public class ModelImpl implements Model {

	public final static int MAX_WIDTH = 700;
	public final static int MAX_HEIGHT = 500;
	public final static int MIN_WIDTH = 0;
	public final static int MIN_HEIGHT = 0;

	private Set<GenericEntity> entities;
	private Set<GenericEntity> newEntity;

	private final EntityCollision collisionManager;
	private final GameController controller;

	public ModelImpl(GameController controller) {
		this.controller = controller;
		this.collisionManager = new EntityCollisionImpl(this);
		this.entities = new HashSet<>();
		this.newEntity = new HashSet<>();
	}

	public void nextLevel() {
//		this.entities.add(new Boss1((ModelImpl.MAX_WIDTH-ModelImpl.MIN_WIDTH)/2,
//				(ModelImpl.MAX_HEIGHT-ModelImpl.MIN_HEIGHT)/2, this));
//		this.entities.add(new Boss2(300, 300, this));
//		this.entities.add(new Boss3((ModelImpl.MAX_WIDTH-ModelImpl.MIN_WIDTH)/2, 80, this));
//		this.entities.add(new MonoDirectionEnemyBullet((ModelImpl.MAX_WIDTH-ModelImpl.MIN_WIDTH)/2,
//				ModelImpl.MAX_HEIGHT - 100 - 7.5 -14 , SpecificEntityType.BOSS_1_BULLET));
//		this.entities.add(new Player((ModelImpl.MAX_WIDTH-ModelImpl.MIN_WIDTH)/2,
//			ModelImpl.MAX_HEIGHT - 100));
	}

	@Override
	public Set<GenericEntity> getEntitiesLevel() {
		return this.entities.stream().filter(e -> e.isAlive()).collect(Collectors.toSet());
	}

	@Override
	public Set<AutoMovableEntity> getAutoMovableEntitiesLevel() {
		Set<AutoMovableEntity> set = new HashSet<>();
		this.entities.forEach(e -> {
			if((e instanceof AutoMovableEntity) && e.isAlive()) {
				set.add((AutoMovableEntity)e);
			}
		});
		return set;
	}

	@Override
	public Set<UserEntity> getUserEntity() {
		Set<UserEntity> set = new HashSet<>();
		this.entities.forEach(e -> {
			if((e instanceof UserEntity) && e.isAlive()) {
				set.add((UserEntity)e);
			}
		});
		return set;
	}

	private Set<Enemy> enemyCapableOfFiring() {
		Set<Enemy> set = new HashSet<>();
		this.getAutoMovableEntitiesLevel().forEach(e -> {
			if((e instanceof Enemy) && e.isAlive()) {
				set.add((Enemy)e);
			}
		});
		return set;
	}

	public Set<MappedEntity> getMappedEntities(){
		Set<MappedEntity> set = new HashSet<>();
		this.entities.stream().filter(e -> e.isAlive()).forEach(e ->{
			Pair<Double,Double> pos = this.getMappedCoordinate(e.getPos());
			set.add(new MappedEntityImpl(e.getEntityType(), pos.getX(), pos.getY(), this.getMapppedWidth(e.getWidth()),
					this.getMappedHeight(e.getHeight())));
		});
		return set;
	}

	private Pair<Double, Double> getMappedCoordinate(Pair<Double, Double> pos){
		double x = 0 + (pos.getX() - MIN_WIDTH) * (this.controller.getWindowWidth() - 0)/
				(MAX_WIDTH - MIN_WIDTH);
		double y = 0 + (pos.getY() - MIN_HEIGHT) * (this.controller.getWindowHeight() - 0)/
				(MAX_HEIGHT - MIN_HEIGHT);
		return new Pair<Double, Double>(x, y);
	}

	private int getMapppedWidth(int width) {
		int min = 0 + (0 - MIN_WIDTH) * (this.controller.getWindowWidth() - 0)/
				(MAX_WIDTH - MIN_WIDTH);
		int max = 0 + (width - MIN_WIDTH) * (this.controller.getWindowWidth() - 0)/
				(MAX_WIDTH - MIN_WIDTH);
		return max - min;
	}

	private int getMappedHeight(int height) {
		int min = 0 + (0 - MIN_HEIGHT) * (this.controller.getWindowHeight() - 0)/
				(MAX_HEIGHT - MIN_HEIGHT);
		int max = 0 + (height - MIN_HEIGHT) * (this.controller.getWindowHeight() - 0)/
				(MAX_HEIGHT - MIN_HEIGHT);
		return max - min;
	}

	@Override
	public void updateEntityLevel(int cycles) {
		if(cycles % 1 == 0 & !this.enemyCapableOfFiring().isEmpty()) {
			this.enemyCapableOfFiring().forEach(e ->e.shoot());
			if(!this.newEntity.isEmpty()) {
				this.entities.addAll(this.newEntity);
				this.newEntity.clear();
			}
		}
		this.getAutoMovableEntitiesLevel().forEach(e -> e.updateEntityPosition());
		this.collisionManager.checkCollision();
		this.entities.removeAll(this.entities.stream()
				.filter(e -> !e.isAlive())
				.collect(Collectors.toSet()));
	}

	@Override
	public GameController getController() {
		return this.controller;
	}

	@Override
	public void processGameOver() {
		
	}

	@Override
	public Set<GenericEntity> getNewEntity() {
		return this.newEntity;
	}
}
