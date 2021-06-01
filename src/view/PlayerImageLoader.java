package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.imageio.ImageIO;

import model.entities.SpecificEntityType;
import model.entitiesutil.typeentities.GenericEntity;
import util.Strings;

public class PlayerImageLoader {
	ArrayList<String> playerImageList = new ArrayList<>();
	Random randomPlayerImage = new Random();
	
	public PlayerImageLoader() {
		this.playerImageList.add(Strings.FEDE_SKIN);
		this.playerImageList.add(Strings.MELI_SKIN);
		this.playerImageList.add(Strings.TANGERINE_SKIN);
		this.playerImageList.add(Strings.NOSE_SKIN);
	}
	
	public Optional<Image> choseImage(String playerImage) throws IOException{
		
		Optional<Image> image = Optional.empty();
		if(this.playerImageList.contains(playerImage)) {
			image = Optional.of(ImageIO.read(new File(playerImage)));
			return this.resizeImage(image.get(), 0, 0);
		}
		return image;
	}
	
	private Optional<Image> resizeImage(Image image, int width, int heigth) {
		return Optional.of(image.getScaledInstance(width, heigth, Image.SCALE_DEFAULT));
	}
	
	public Optional<Image> selectRandomSkin() throws IOException {
		int randomItem = this.randomPlayerImage.nextInt(this.playerImageList.size());
		String chooseItem = this.playerImageList.get(randomItem);
		Image randomImage = ImageIO.read(new File(chooseItem));
		return this.resizeImage(randomImage, SpecificEntityType.PLAYER_1, SpecificEntityType.PLAYER_1); //luc mettere quello che manca 
	}
}
