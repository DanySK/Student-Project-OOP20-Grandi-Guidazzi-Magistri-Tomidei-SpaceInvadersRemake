package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.entitiesutil.Entity;

/**
 * Implementation of {@link EntityGraphics}
 */
public class EntityGraphicsImpl implements EntityGraphics {

	private Image img;
	private Graphics graphics;

	/**
	 * Implementation of {@link EntityGraphics}
	 * 
	 * @param strImgs is the image's path of the entity
	 */
	public EntityGraphicsImpl(List<String> strImgs) {
		this.img = new ImageIcon(getClass().getResource(strImgs.get(0))).getImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGraphics(Graphics g, Entity e) {
		this.graphics = (Graphics2D) g;
		this.graphics.drawImage(this.img, e.getX(), e.getY(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void switchImage(Entity e, String strImg) {
		this.img = new ImageIcon(getClass().getResource(strImg)).getImage();
	}

}
