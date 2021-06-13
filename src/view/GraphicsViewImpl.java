package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JPanel;

import model.entitiesutil.typeentities.GenericEntity;

/**
 * A class that manages the view.
 */
public class GraphicsViewImpl extends JPanel implements GraphicsView{

	private Map<GenericEntity, Image> genericEntityMap;
	private PlayerImageLoader playerLoader;
	private Graphics graphics;
	private ImageLoader imageLoader;
	
	public GraphicsViewImpl(Set<GenericEntity> entity) {
		super();
		this.imageLoader = new ImageLoader();
		this.genericEntityMap = new HashMap<>();
		entity.forEach(e-> this.genericEntityMap.put(e, imageLoader.createImage(e).get()));
	}

	@Override
	public void paintComponents(Graphics graphics) {
		this.graphics = (Graphics2D)graphics;
		this.genericEntityMap.forEach((entity,image)-> this.graphics.drawImage(image, (int)entity.getX(), (int)entity.getY(), null));
	}
	
	/**
	 * The method that update the images.
	 */
	@Override
	public void updateEntityImages(Set<GenericEntity> entity) {
		entity.forEach(e-> this.genericEntityMap.put(e, imageLoader.createImage(e).get()));
		
	}
}
