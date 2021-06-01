package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import model.entitiesutil.typeentities.GenericEntity;
import util.Strings;

public class ImageLoader {

	ArrayList<String> playerImageList = new ArrayList<>();
	Random randomPlayerImage = new Random();
	
	public ImageLoader(GenericEntity entity) throws IOException {
		this.choseImage(entity);
	}
	
	public Optional<Image> choseImage(GenericEntity entity) throws IOException{
		
		Optional<Image> image = Optional.empty();
		
		switch(entity.getEntityType()) {
		
		case BOSS_1:
				image = Optional.of(ImageIO.read(new File(Strings.BOSS_1)));
				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
				
		case BOSS_2:
				image = Optional.of(ImageIO.read(new File(Strings.BOSS_2)));
				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
			
		case BOSS_3:
				image = Optional.of(ImageIO.read(new File(Strings.BOSS_3)));
				return this.resizeImage(image.get(), entity.getWidth(), entity.getHeight());
			
		case ALIEN:
				Image alien = ImageIO.read(new File(Strings.ALIEN_SKIN));
				return this.resizeImage(alien, entity.getWidth(), entity.getHeight());
			
		case ALIEN_BULLET:
			Image alienBullet = ImageIO.read(new File(Strings.ALIEN_BULLET));
			return this.resizeImage(alienBullet, entity.getWidth(), entity.getHeight());
			
		case BOSS_1_BULLET:
				Image bossBullet = ImageIO.read(new File(Strings.BOSS_BULLET));
				return this.resizeImage(bossBullet, entity.getWidth(), entity.getHeight());
			
		case BOSS_2_BULLET:
				Image boss2Bullet = ImageIO.read(new File(Strings.BOSS_BULLET));
				return this.resizeImage(boss2Bullet, entity.getWidth(), entity.getHeight());
			
		case BOSS_3_BULLET:
				Image boss3Bullet = ImageIO.read(new File(Strings.BOSS_BULLET));
				return this.resizeImage(boss3Bullet, entity.getWidth(), entity.getHeight());
			
		case PLAYER_1_BULLET:
				Image playerBullet = ImageIO.read(new File(Strings.PLAYER_BULLET));
				return this.resizeImage(playerBullet, entity.getWidth(), entity.getHeight());
				
		default:
			return image;
		}
		
	}
	
	private Optional<Image> resizeImage(Image image, int width, int heigth) {
		return Optional.of(image.getScaledInstance(width, heigth, Image.SCALE_DEFAULT));
	}

}
