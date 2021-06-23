package menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	private JButton button = new JButton(Strings.Skins.RANDOM_SKIN);
	private JPanel panel = new PanelBackgroundFactory(Strings.BackgroundImages.PANEL_BACKGROUND);
	private JPanel centerPanel = new JPanel();
	private JPanel gridPanel = new JPanel();
	private JButton fedeButton;
	private JButton meliButton;
	private JButton tangerineButton;
	private JButton noseButton;
	
	/**
	 * The constructor of the StateSelectSkin,
	 * this state gives the possibility to choose the skin of the player
	 * @param board
	 */
	public StateSelectSkin(Board board) {
		this.fedeButton = new ButtonFactory().createSkinButton(Strings.Skins.FEDE_SKIN, board);
		this.meliButton = new ButtonFactory().createSkinButton(Strings.Skins.MELI_SKIN, board);
		this.tangerineButton = new ButtonFactory().createSkinButton(Strings.Skins.TANGERINE_SKIN, board);
		this.noseButton = new ButtonFactory().createSkinButton(Strings.Skins.NOSE_SKIN, board);
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.centerPanel.setOpaque(false);
		
		this.panel.add(this.titleFactory.createTitle("Select your Skin:", Constants.ObjectSize.titleSize, Constants.Colors.colorTitle), BorderLayout.NORTH);
		
		this.gridPanel.setLayout(new GridLayout(0,Constants.LayoutDimension.specificColumns,0,Constants.LayoutDimension.specificRow));
		this.gridPanel.setOpaque(false);
		this.centerPanel.add(this.gridPanel, BorderLayout.CENTER);
		
		this.gridPanel.add(this.fedeButton);
		this.gridPanel.add(this.meliButton);
		this.gridPanel.add(this.tangerineButton);
		this.gridPanel.add(this.noseButton);
		
		this.centerPanel.add(this.button);
		this.button.addActionListener(e->{
//			try {
//				//board.getController().getView().getImageManager().selectRandomSkin();
//			} catch (IOException e1) {
//				JOptionPane.showMessageDialog(board.getFrame(), "Image not found", "Error", JOptionPane.ERROR_MESSAGE);
//			}
			board.setCurrentState(new StateInfo(board));
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

}
