package view;

import java.awt.Image;
import java.util.Optional;

import model.entitiesutil.typeentities.GenericEntity;

/**
 * Interface that controls the update of the images.
 */
public interface UpdateManager {

	/**
	 * Method that associates its image with the entity
	 * @param entity	is the entity to which the image will be associated
	 * @return			the image associated
	 */
	Optional<Image> drawEntity(GenericEntity entity);

}