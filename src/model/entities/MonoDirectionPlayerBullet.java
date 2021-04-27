package model.entities;

import java.util.ArrayList;
import java.util.List;

import graphics.EntityGraphicsImpl;
import model.entitiesutil.Bullet;
import model.entitiesutil.EntityDirections;
import model.physics.EntityMovementImpl;
import util.Pair;

public class MonoDirectionPlayerBullet extends Bullet{

	private List<String> strImgs;
	
	private MonoDirectionPlayerBullet(Pair<Integer,Integer> pos, List<String> strImgs) {
		this.strImgs = new ArrayList<>();
		this.create(EntityType.PLAYER_BULLET, pos, 0, 0, 0, 0, EntityDirections.UP, new EntityGraphicsImpl(strImgs), new EntityMovementImpl());
	}
	@Override
	public void updateEntityPos() {
		// TODO Auto-generated method stub
		
	}

}
