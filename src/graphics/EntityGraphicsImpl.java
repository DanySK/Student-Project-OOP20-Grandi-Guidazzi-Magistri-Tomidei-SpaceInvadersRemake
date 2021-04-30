package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.entitiesutil.Entity;
import model.entitiesutil.Entity.EntityType;

/**
 * Implementation of {@link EntityGraphics}
 */
public class EntityGraphicsImpl implements EntityGraphics {

	private Image img;
	private Graphics graphics;
	private List<String> strImgs;

	/**
	 * Implementation of {@link EntityGraphics}
	 * 
	 * @param strImgs is the image's path of the entity
	 */
	public EntityGraphicsImpl(EntityType type) {
		switch(type) {
			case BOSS_1:
				break;
			case BOSS_2:
				break;
			case BOSS_3:
				break;
			case GENERIC_ENEMY:
				break;
			case PLAYER:
				break;
			case BOSS_1_BULLET:
				break;
			case BOSS_2_BULLET:
				break;
			case BOSS_3_BULLET:
				break;
			case ENEMY_BULLET:
				break;
			case PLAYER_BULLET:
				break;
			default:
				break;
			
		}
		this.img = new ImageIcon(getClass().getResource(this.strImgs.get(0))).getImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGraphics(Graphics g, Entity e) {
		this.graphics = (Graphics2D) g;
		this.graphics.drawImage(this.img, (int)e.getX(), (int)e.getY(), null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setEntityStrImgs(List<String> newEntityStrImg) {
		this.strImgs = newEntityStrImg;
	}


}
