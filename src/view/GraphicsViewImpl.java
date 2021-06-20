package view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.entitiesutil.typeentities.GenericEntity;

/**
 * A class that manages the view.
 */
public class GraphicsViewImpl extends JPanel implements GraphicsView{

	private static final long serialVersionUID = 1L;
	private Set<GenericEntity> genericEntitySet;
	private UpdateManager imageManager;
	
	/**
	 * The constructor that create the objects to manage the images.
	 */
	public GraphicsViewImpl(){
		super();
		this.genericEntitySet = new HashSet<>();
		this.imageManager = new ImageManagerImpl();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintComponents(Graphics graphics) {
		this.genericEntitySet.forEach(e->{
			Optional<Image> image = this.imageManager.drawEntity(e);
			if(image.equals(Optional.empty())) {
				JOptionPane.showMessageDialog(this, "Image not found", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				graphics.drawImage(image.get(), (int)e.getX(), (int)e.getY(), null);
			}
		});
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateEntityImages(Set<GenericEntity> entitySet) {
		this.genericEntitySet.clear();
		this.genericEntitySet = entitySet;
		SwingUtilities.invokeLater(()->this.repaint());
		
	}
}
