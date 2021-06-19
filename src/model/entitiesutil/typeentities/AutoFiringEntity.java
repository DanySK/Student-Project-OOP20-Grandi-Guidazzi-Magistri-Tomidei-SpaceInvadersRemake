package model.entitiesutil.typeentities;

public interface AutoFiringEntity extends EntityCapableOfShooting {

	public boolean canShoot(int cycles);
}
