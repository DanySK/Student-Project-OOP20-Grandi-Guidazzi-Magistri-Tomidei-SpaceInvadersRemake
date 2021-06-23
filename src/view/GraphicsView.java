package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.JPanel;

import controller.ViewGameController;

/**
 * A class that manages the view.
 */
public class GraphicsView extends JPanel{

	private static final long serialVersionUID = 1L;
	private UpdateManager imageManager;
	private final ViewGameController controller;
	
	/**
	 * The constructor that create the objects to manage the images.
	 */
	public GraphicsView(String uriSkin, ViewGameController ctrl) throws IOException{
		this.controller = ctrl;
		this.imageManager = new ImageManagerImpl(uriSkin);
		this.setBackground(Color.BLACK);
	}

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics g2D = (Graphics2D)graphics;
		
		this.controller.getLevelEntities().forEach(e -> {
			Image image;
			try {
				image = this.imageManager.drawEntity(e);
				g2D.drawImage(image, (int)e.getX()-e.getWidth()/2, (int)e.getY()-e.getHeight()/2, null);
			} catch (IOException e1) {
				System.exit(1);
			}
		});
	}

}
