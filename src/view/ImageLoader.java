package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import model.entitiesutil.typeentities.GenericEntity;
import util.Strings;
/**
 * A class that allows to load the entity's image.
 */
public class ImageLoader {

	Random randomPlayerImage = new Random();
	
	/**
	 * he method that allows to choose the image for each entity of the game.
	 * @param entity
	 * @return
	 * @throws IOException
	 */
	private Optional<Image> choseImage(GenericEntity entity) throws IOException{
		
		final StringBuilder stringNameBuilder = new StringBuilder();
		stringNameBuilder.append("/res/image/" + entity.getEntityType().toString() + ".png");
		
		Optional<Image> image = Optional.of(ImageIO.read(new File(stringNameBuilder.toString())));

		return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
		
//		switch(entity.getEntityType()) {
//		
//		case BOSS_1:
//				image = Optional.of(ImageIO.read(new File(Strings.BOSS_1)));
//				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//				
//		case BOSS_2:
//				image = Optional.of(ImageIO.read(new File(Strings.BOSS_2)));
//				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//			
//		case BOSS_3:
//				image = Optional.of(ImageIO.read(new File(Strings.BOSS_3)));
//				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//			
//		case ALIEN:
//				image =  Optional.of(ImageIO.read(new File(Strings.ALIEN_SKIN)));
//				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//			
//		case ALIEN_BULLET:
//			image =  Optional.of(ImageIO.read(new File(Strings.ALIEN_BULLET)));
//			return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//			
//		case BOSS_1_BULLET:
//			image =  Optional.of(ImageIO.read(new File(Strings.BOSS_BULLET)));
//				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
//			
//		case BOSS_2_BULLET:
//				Image boss2Bullet = ImageIO.read(new File(Strings.BOSS_BULLET));
//				return this.resizeImage(boss2Bullet, entity.getWidth(), entity.getHeight());
//			
//		case BOSS_3_BULLET:
//				Image boss3Bullet = ImageIO.read(new File(Strings.BOSS_BULLET));
//				return this.resizeImage(boss3Bullet, entity.getWidth(), entity.getHeight());
//			
//		case PLAYER_1_BULLET:
//				Image playerBullet = ImageIO.read(new File(Strings.PLAYER_BULLET));
//				return this.resizeImage(playerBullet, entity.getWidth(), entity.getHeight());
//				
//		default:
//			return image;
//		}
		
	}
	
	public Optional<Image> createImage(GenericEntity entity) {
		Optional<Image> image = Optional.empty();
		try {
			image = this.choseImage(entity);
		} catch (IOException e) {
			//JOptionPane.showMessageDialog(board.getFrame(), "Link not found", "Error", JOptionPane.ERROR_MESSAGE);
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
}
