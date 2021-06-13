package view;

import java.util.Set;

import model.entitiesutil.typeentities.GenericEntity;

public interface GraphicsView {

	//public void updateEntityImages();

	/**
	 * The method that update the images.
	 */
	void updateEntityImages(Set<GenericEntity> entitySet);
	
}
