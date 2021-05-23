package menu;

import java.awt.BorderLayout;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import menu.factories.LabelFactory;
import menu.factories.PanelBackgroundFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the StateMenu
 */
public class StateMenu implements State{

	private LabelFactory labelFactory = new LabelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	private JPanel panel = new PanelBackgroundFactory(Strings.PANEL_BACKGROUND);
	private JPanel centerPanel = new JPanel();
	
	/**
	 * The constructor of the StateMenu,
	 * this state is showed at the start of the application or when the button Go back to menu is pressed.
	 * @param board
	 */
	public StateMenu(Board board) {
		this.panel.setOpaque(false);
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.centerPanel.setOpaque(false);
	 
		this.panel.add(this.titleFactory.createTitle("Welcome to Space Invaders Remake", Constants.titleSize, Constants.colorTitle), BorderLayout.NORTH);
		
		this.centerPanel.add(this.labelFactory.createButton(Strings.START, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.OPTIONS, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.CREDITS, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.ABOUT, board, "Center"));
		this.centerPanel.add(this.labelFactory.createButton(Strings.EXIT, board, "Center"));
		
	}

	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	
	@Override
	public String toString() {
		return "StateMenu";
	}
}
