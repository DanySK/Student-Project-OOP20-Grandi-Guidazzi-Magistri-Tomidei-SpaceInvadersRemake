package model.entities;

import model.entitiesutil.EntityConstants;
import model.entitiesutil.EntityDirections;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import model.entitiesutil.typeentities.UserEntity;
import model.physics.EntityCollision.EdgeCollision;
import model.physics.EntityMovement;
import util.Pair;

/**
 * A class that create the player entity.
 */
public class Player implements UserEntity{

	private SpecificEntityType entityType;
	private Pair<Double,Double> position;
	private EntityDirections direction;
	private double movimentUnitX;
	private double movimentUnitY;
	private int height;
	private int width;
	private int hit;
	private int maxHits;
	
	/**
	 * The Constractor that create the Player.
	 * @param position
	 */
	public Player(int x, int y) {
		this.entityType = SpecificEntityType.PLAYER_1;
		this.position = new Pair<>((double)x, (double)y);
		this.movimentUnitX = EntityConstants.Player.PLAYER_INITIAL_MU_X;
		this.movimentUnitY = EntityConstants.Player.PLAYER_INITIAL_MU_Y;
		this.height = EntityConstants.Player.PLAYER_INITIAL_HEIGHT;
		this.width = EntityConstants.Player.PLAYER_INITIAL_WIDTH;
		this.hit = 0;
		this.maxHits = EntityConstants.Player.PLAYER_MAX_HITS;
	}
	
	public Pair<Double, Double> getPos() {
		return this.position;
	}

	public void setPos(Pair<Integer, Integer> pos) {
		pos.setBoth(pos.getX(), pos.getY());
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public boolean isAlive() {
		return this.hit < this.maxHits;
	}
	
	public void incHits() {
		this.hit++;
	}

	@Override
	public double getMuX() {
		return this.movimentUnitX;
	}

	@Override
	public void setMuX(double mux) {
		this.movimentUnitY = mux;
	}

	@Override
	public void setMuY(double muy) {
		this.movimentUnitY = muy;
	}

	@Override
	public EntityDirections getDirection() {
		return this.direction;
	}

	@Override
	public void setDirection(EntityDirections direction) {
		this.direction = direction;
	}

	@Override
	public void doAfterCollisionWithEdge(EdgeCollision edge) {
		if(edge.equals(EdgeCollision.LEFT) || edge.equals(EdgeCollision.RIGHT)) {
			this.setPos(new Pair<>((int)this.getX(), (int)this.getY()));
		}
	}

	@Override
	public double getX() {
		return this.position.getX();
	}

	@Override
	public double getY() {
		return this.position.getY();
	}

	@Override
	public void setX(double x) {
		this.position.setY(x);
		
	}

	@Override
	public void setY(double y) {
		this.position.setY(y);
		
	}

	@Override
	public void doAfterCollisionWithEntity(GenericEntity entity) {
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.ENEMY_BULLET) && this.isAlive()){
			this.incHits();
		} /*else if( !this.isAlive()) {
			//this.model.processGameOver();
		}*/
	}

	@Override
	public SpecificEntityType getEntityType() {
		return this.entityType;
	}

	@Override
	public void shoot() {
		/*this.model.getNewEntitiesLvel().add(new MonoDirectionPlayerBullet(this.getX(), getY() - this.height/2),
				SpecificEntityType.PLAYER_BULLET);*/
		
	}


	@Override
	public double getMuY() {
		return this.movimentUnitY;
	}

	@Override
	public void setPos(int x, int y) {
		this.position.setBoth((double)x-this.width/2, (double)y-this.height/2);
		
	}

	@Override
	public void updateEntityPosition(EntityDirections direction) {
		if(this.getDirection().equals(EntityDirections.LEFT)) {
			this.setX(this.getX() - this.getMuX());
		} else {
			this.setX(this.getX() + this.getMuX());
			}
		this.setX(this.getX() + this.getMuX());
		}
		
	}
	
