package view;

import java.io.IOException;

/**
 * Interface that control the images that the user can choose.
 */
public interface ImageManager{

	/**
	 * Method that gives the possibility to choose the player skin
	 * @param playerImage	is the image that will be placed on the player
	 * @throws IOException
	 */
	void chosePlayerSKin(String playerImage) throws IOException;
	
	/**
	 * Method that gives the possibility to randomly the player skin
	 * @throws IOException
	 */
	void selectRandomSkin() throws IOException;
}
