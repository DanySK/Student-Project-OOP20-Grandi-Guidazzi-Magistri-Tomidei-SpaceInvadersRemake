package model;

import java.util.List;
import java.util.Set;

import controller.GameController;
import model.entities.Alien;
import model.entitiesutil.MappedEntity;
import model.entitiesutil.typeentities.AutoMovableEntity;
import model.entitiesutil.typeentities.GenericEntity;
import model.entitiesutil.typeentities.UserEntity;

public interface Model {

	public Set<GenericEntity> getEntitiesLevel();

	public Set<AutoMovableEntity> getAutoMovableEntitiesLevel();

	public Set<UserEntity> getUserEntity();

	public Set<GenericEntity> getNewEntity();

	public Set<MappedEntity> getMappedEntities();

	public void nextLevel();

	public void updateEntityLevel(int cycles);

	public GameController getController();

	public void processGameOver();

	public List<Alien> getAlienList();

}
