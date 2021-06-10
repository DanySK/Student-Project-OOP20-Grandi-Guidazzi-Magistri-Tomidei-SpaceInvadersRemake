package menu.factories;

import java.awt.Color;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import menu.Board;
import menu.StateInfo;
import util.Constants;
import view.PlayerImageLoader;
/**
 * A class that makes buttons for choose the player image. 
 */
public class ButtonFactory {

	private JButton button = new JButton();
	private Image resizedImage;
	private Image image;
	
	/**
	 * The method create the button with the correct image associated. 
	 * @param skinUri, the string that is connected to the image.
	 * @param board, the main board
	 * @return
	 */
	public JButton createSkinButton(String skinUri, Board board) {
		try {
			this.image = ImageIO.read(new File(skinUri));
			this.resizedImage = this.image.getScaledInstance(Constants.imageDimension, Constants.imageDimension, Image.SCALE_DEFAULT);
			button.setIcon(new ImageIcon(this.resizedImage));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(board.getFrame(), "Update image error", "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.button.setMaximumSize(new Dimension(Constants.imageDimension, Constants.imageDimension));
		this.button.setOpaque(false);
		this.button.setBackground(Color.black);
		this.button.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.button.addActionListener(e->{
			PlayerImageLoader playerImage = new PlayerImageLoader();
			try {
				playerImage.choseImage(skinUri);
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(board.getFrame(), "Update image error", "Error", JOptionPane.ERROR_MESSAGE);
			} 
			board.getMenuController().changeState(new StateInfo(board));
		});
		
		return this.button;
	}
}


