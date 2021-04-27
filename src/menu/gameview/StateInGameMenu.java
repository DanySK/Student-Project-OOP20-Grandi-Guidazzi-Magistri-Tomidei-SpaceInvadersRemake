package menu.gameview;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controller.GameController;
import controller.GameControllerImpl;
import menu.Board;
import menu.State;
import menu.factories.LabelFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 * A class that contains the aspects of the menu in game.
 */
public class StateInGameMenu implements State{

	private LabelFactory labelFactory = new LabelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	private JPanel panel = new JPanel();
	private JPanel centerPanel = new JPanel();
	
	
	public StateInGameMenu(Board board) {
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.centerPanel.setOpaque(false);
		
		this.panel.add(this.titleFactory.createTitle("Game Menu", Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		
		this.centerPanel.add(this.labelFactory.createButton(Strings.RESTART, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.RESUME, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.AUDIO_SETTINGS_IN_GAME, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.GO_BACK_TO_MENU, board, "Center"));
		
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

	
}
