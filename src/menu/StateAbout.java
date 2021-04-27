package menu;

import java.awt.BorderLayout;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

import menu.factories.LabelFactory;
import menu.factories.PanelFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the stateAbout
 */
public class StateAbout implements State{

	private JPanel panel;
	private JPanel centerPanel = new JPanel();
	private PanelFactory panelFactory = new PanelFactory();
	private LabelFactory labelFactory = new LabelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	
	/**
	 * The constructor of the state about,
	 * this state is showed when the button About the game... is pressed.
	 * @param board
	 */
	public StateAbout(Board board) {
		this.panel = this.panelFactory.createPanel(Strings.ABOUT, board);
		this.centerPanel.setOpaque(false);
		this.centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		
		this.centerPanel.add(this.titleFactory.createTitle(Strings.ABOUT_TEXT, Constants.subtitleSize, Constants.colorSubtitle));
		this.centerPanel.add(this.labelFactory.createButton(Strings.MORE_INFO, board, "Center"));
	
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
