package spaceIndaversRemakeTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import model.entities.PlayerBullet;
import util.Pair;

public class playerBulletTest {

	@Test
	public void playerBulletTest() {
		final PlayerBullet testBullet = new PlayerBullet(0, 0);
	    assertNotNull(testBullet);
	    final Pair<Double, Double> position = testBullet.getPos();
	    testBullet.setMuX(10);
	    testBullet.setMuY(10);
	    testBullet.updateEntityPosition();
	    assertEquals(position, new Pair<>(testBullet.getX(), testBullet.getY()));
	}
}
