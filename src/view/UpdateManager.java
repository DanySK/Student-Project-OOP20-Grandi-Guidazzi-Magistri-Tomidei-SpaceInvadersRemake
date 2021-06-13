package view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Optional;

import model.entitiesutil.typeentities.GenericEntity;

public interface UpdateManager {

	Optional<Image> drawEntity(GenericEntity entity);

}