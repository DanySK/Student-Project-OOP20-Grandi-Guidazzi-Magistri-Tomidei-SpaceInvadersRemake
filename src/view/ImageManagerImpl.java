package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import model.entitiesutil.EntityConstants;
import model.entitiesutil.GenericEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import util.Strings;

public class ImageManagerImpl implements ImageManager, UpdateManager{

	private Image image;
	private Image playerImage;
	private ArrayList<String> playerImageList = new ArrayList<>();
	private Random random = new Random();
	
	public ImageManagerImpl(){
		this.playerImageList.add(Strings.FEDE_SKIN);
		this.playerImageList.add(Strings.MELI_SKIN);
		this.playerImageList.add(Strings.TANGERINE_SKIN);
		this.playerImageList.add(Strings.NOSE_SKIN);
	}
	
	@Override
	public Optional<Image> drawEntity(GenericEntity entity) {
		try {
			return Optional.of(this.image = this.choseImage(entity).get());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Optional.empty();
		
	}
	

	
	/**
	 * The method that allows to choose the image for each entity of the game.
	 * @param entity
	 * @return
	 * @throws IOException
	 */
	private Optional<Image> choseImage(GenericEntity entity) throws IOException{
		
		if(entity.getEntityType().getGenericType().equals(GenericEntityType.PLAYER)) {
			return this.resizeImage(playerImage, entity.getWidth(), entity.getHeight());
		}
		final StringBuilder stringNameBuilder = new StringBuilder();
		stringNameBuilder.append("/res/image/" + entity.getEntityType().toString() + ".png");
		
		Optional<Image> image = Optional.of(ImageIO.read(new File(stringNameBuilder.toString())));

		return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
		
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
	
	public void chosePlayerSKin(String playerImage) throws IOException{
		
		final StringBuilder stringNameBuilder = new StringBuilder();
		stringNameBuilder.append(playerImage);
		
		if(this.playerImageList.contains(playerImage)) {
			this.playerImage = ImageIO.read(new File(stringNameBuilder.toString()));
			this.playerImage = this.resizeImage(this.playerImage, EntityConstants.Player.INITIAL_WIDTH, EntityConstants.Player.INITIAL_HEIGHT).get();
		}
	}
	
	/**
	 * The method select randomly one of the four playerImage. 
	 * @throws IOException
	 */
	public void selectRandomSkin() throws IOException {
		String chooseItem = this.playerImageList.get(this.random.nextInt(this.playerImageList.size()));
		Image randomImage = ImageIO.read(new File(chooseItem));
		this.resizeImage(randomImage, EntityConstants.Player.INITIAL_WIDTH, EntityConstants.Player.INITIAL_HEIGHT);
	}
}
