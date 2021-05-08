package model.entities;

import java.util.Random;

import model.entitiesutil.EntityCapableShooting;

public class AlienGroup implements EntityCapableShooting{

	private Random random = new Random();
	
	public AlienGroup(int numAlien) {
		
	}
	
	@Override
	public void shot() {
//		this.model.getAlienList().get(random.nextInt(this.model.getAlienList().size())).shot();

	}
	
	public void alienGroupDown() {
//		this.model.getAlienList().stream.foreach(i->i.changeDirection());
	}
}
