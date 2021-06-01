package menu.factories;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import menu.Board;
import menu.StateInfo;

public class ButtonFactory {

	private JButton button = new JButton();
	private Image resizedImage;
	private Image image;
	
	public JButton createSkinButton(String skinUri, Board board) {
	
		try {
			this.image = ImageIO.read(new File(skinUri));
			this.resizedImage = this.image.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			
			button.setIcon(new ImageIcon(this.resizedImage));
		} catch (Exception ex) {
			System.out.println("Upload error");
		}
		this.button.setMaximumSize(new Dimension(100,100));
		this.button.setOpaque(false);
		this.button.setBackground(Color.black);
		this.button.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		this.button.addActionListener(e->{
			board.getMenuController().changeState(new StateInfo(board));
		});
		
		return this.button;
	}
}


