package view;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import model.entitiesutil.EntityConstants;
import util.Strings;

/**
 * A class that allows to load the image for the player.
 */
public class PlayerImageLoader {
	ArrayList<String> playerImageList = new ArrayList<>();
	Random randomPlayerImage = new Random();
	
	public PlayerImageLoader() {
		this.playerImageList.add(Strings.FEDE_SKIN);
		this.playerImageList.add(Strings.MELI_SKIN);
		this.playerImageList.add(Strings.TANGERINE_SKIN);
		this.playerImageList.add(Strings.NOSE_SKIN);
	}
	
	/**
	 * The method that allows to choose the image if the user choose one of the four playerSkin.
	 * @param playerImage
	 * @return
	 * @throws IOException
	 */
	public Optional<Image> choseImage(String playerImage) throws IOException{
		
		final StringBuilder stringNameBuilder = new StringBuilder();
		stringNameBuilder.append(playerImage);
		Optional<Image> image = Optional.empty();
		
		if(this.playerImageList.contains(playerImage)) {
			image = Optional.of(ImageIO.read(new File(stringNameBuilder.toString())));
			return this.resizeImage(image.get(), EntityConstants.Player.PLAYER_INITIAL_WIDTH, EntityConstants.Player.PLAYER_INITIAL_HEIGHT);
		}
		return image;
	}
	
	/**
	 * The method that resized the image.
	 * @param image
	 * @param width
	 * @param heigth
	 * @return
	 */
	private Optional<Image> resizeImage(Image image, int width, int heigth) {
		return Optional.of(image.getScaledInstance(width, heigth, Image.SCALE_DEFAULT));
	}
	
	/**
	 * The method select randomly one of the four playerImage. 
	 * @throws IOException
	 */
	public void selectRandomSkin() throws IOException {
		int randomItem = this.randomPlayerImage.nextInt(this.playerImageList.size());
		String chooseItem = this.playerImageList.get(randomItem);
		Image randomImage = ImageIO.read(new File(chooseItem));
		this.resizeImage(randomImage, EntityConstants.Player.PLAYER_INITIAL_WIDTH, EntityConstants.Player.PLAYER_INITIAL_HEIGHT);
	}
}
