package model.entities;

import java.util.Random;

import model.Model;
import model.entitiesutil.typeentities.EntityCapableOfShooting;

/**
 * The class that create and manage the alien group
 *
 */
public class AlienGroup implements EntityCapableOfShooting{

	private Random random = new Random();
	private Model model;
	
	/**
	 * the constructor of the alien group,
	 * it takes the number of the alien in the group
	 * @param numAlien
	 */
	public AlienGroup(int numAlien, Model model) {
		this.model = model;
	}
	
	/**
	 * The method that moves down all the aliens
	 */
	public void alienGroupDown() {
		this.model.getAlienList().stream.foreach(i->i.changeDirection());
	}

	/**
	 * The method that lets the aliens shoot
	 */
	@Override
	public void shoot() {
		this.model.getAlienList().get(random.nextInt(this.model.getAlienList().size())).shot();
		
	}
}
