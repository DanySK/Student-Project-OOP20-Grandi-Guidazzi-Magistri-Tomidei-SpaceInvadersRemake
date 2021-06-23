package menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import menu.factories.ButtonFactory;
import menu.factories.PanelBackgroundFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;
/**
 * A class that allow to choose the skin for player.
 */
public class StateSelectSkin implements State{

	private TitleFactory titleFactory = new TitleFactory();
	private JButton button = new JButton(Strings.RANDOM_SKIN);
	private JPanel panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private JPanel centerPanel = new JPanel();
	private JPanel gridPanel = new JPanel();
	private JButton fedeButton;
	private JButton meliButton;
	private JButton tangerineButton;
	private JButton noseButton;
	private Random random = new Random();
	
	/**
	 * The constructor of the StateSelectSkin,
	 * this state gives the possibility to choose the skin of the player
	 * @param board
	 */
	public StateSelectSkin(Board board) {
		this.fedeButton = new ButtonFactory().createSkinButton(Strings.FEDE_SKIN, board);
		this.meliButton = new ButtonFactory().createSkinButton(Strings.MELI_SKIN, board);
		this.tangerineButton = new ButtonFactory().createSkinButton(Strings.TANGERINE_SKIN, board);
		this.noseButton = new ButtonFactory().createSkinButton(Strings.NOSE_SKIN, board);
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.centerPanel.setOpaque(false);
		
		this.panel.add(this.titleFactory.createTitle("Select your Skin:", Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		
		this.gridPanel.setLayout(new GridLayout(0,Constants.specificColumns,0,Constants.specificRow));
		this.gridPanel.setOpaque(false);
		this.centerPanel.add(this.gridPanel, BorderLayout.CENTER);
		
		this.gridPanel.add(this.fedeButton);
		this.gridPanel.add(this.meliButton);
		this.gridPanel.add(this.tangerineButton);
		this.gridPanel.add(this.noseButton);
		
		this.centerPanel.add(this.button);
		this.button.addActionListener(e->{
			//board.setPlayerSkin(this.selectRandomSkin());
			//board.setCurrentState(new StateGame(board, board.getPlayerSkin));
			JOptionPane.showMessageDialog(null, "Welcome to Space Invaders Remix!"
					+ "\n\nTHINGS TO KNOW:"
					+ "\n\n- Use left/right arrow keys to move\n- Press spacebar to shoot"
                    + "\n- BOSS after each level\n- Shoot enemies to collect points and achieve high scores, but don't miss any shot!"
                    + "\n- Press R to restart the game while you're in the game menu"
                    + "\n- Press ESC to pause the game"
                    + "\n- Press ESC to resume the game while you're in the game menu"
                    + "\n- Press S to stop the game while you're in the game menu"
                    + "\n- All pixel art is original\n- PLAY WITH SOUND\n\nHAVE FUN!");
			
			board.setCurrentState(new StateInfo(board));
			board.getController().startNewGame();
		});
		this.button.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	
	/**
	 * The method select randomly one of the four playerImage. 
	 */
	private String selectRandomSkin() {
		List<String> playerImageList = new ArrayList<>();
		playerImageList.add(Strings.FEDE_SKIN);
		playerImageList.add(Strings.MELI_SKIN);
		playerImageList.add(Strings.TANGERINE_SKIN);
		playerImageList.add(Strings.NOSE_SKIN);
		String chooseItem = playerImageList.get(this.random.nextInt(playerImageList.size()));
		return chooseItem;
	}

}
