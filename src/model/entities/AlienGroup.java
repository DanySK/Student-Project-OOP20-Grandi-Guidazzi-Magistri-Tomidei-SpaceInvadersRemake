package model.entities;

import java.util.Random;

import model.entitiesutil.typeentities.EntityCapableShooting;



public class AlienGroup implements EntityCapableShooting{

	private Random random = new Random();
	
	public AlienGroup(int numAlien) {
		
	}
	
	public void alienGroupDown() {
//		this.model.getAlienList().stream.foreach(i->i.changeDirection());
	}

	@Override
	public void shoot() {
//		this.model.getAlienList().get(random.nextInt(this.model.getAlienList().size())).shot();
		
	}
}
