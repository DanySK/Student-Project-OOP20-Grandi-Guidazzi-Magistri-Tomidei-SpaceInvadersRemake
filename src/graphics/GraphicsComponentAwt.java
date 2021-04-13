package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import model.entitiesutil.Entity;

public class GraphicsComponentAwt implements EntitiesGraphics {

	private List<String> strImgs;
	private Image img;
	private Graphics graphics;

	public GraphicsComponentAwt(List<String> strImgs) {
		this.strImgs = strImgs;
		this.img = new ImageIcon(getClass().getResource(this.strImgs.get(0))).getImage();
	}

	@Override
	public void updateGraphics(Graphics g, Entity e) {
		this.graphics = (Graphics2D) g;
		this.graphics.drawImage(this.img, e.getX(), e.getY(), null);
	}

	@Override
	public void switchImage(Entity e, String strImg) {
		this.img = new ImageIcon(getClass().getResource(strImg)).getImage();
	}

}
