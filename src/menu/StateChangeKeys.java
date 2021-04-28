package menu;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import menu.factories.PanelFactory;
import menu.factories.TitleFactory;
import util.Constants;
import util.Strings;

/**
 *	A class that contains all the object to create the StateChangeKeys
 */
public class StateChangeKeys implements State{

	private JPanel panel;
	private JPanel centerPanel = new JPanel();
	private TitleFactory titleFactory = new TitleFactory();
	private PanelFactory panelFactory = new PanelFactory();
	
	/**
	 * The constructor of the StateChangeKeys,
	 * this state is showed when the button Change keys is pressed.
	 * @param board
	 */
	public StateChangeKeys(Board board) {
		this.panel = this.panelFactory.createPanel(Strings.CHANGE_KEYS, board);
		this.panel.add(this.centerPanel, BorderLayout.CENTER);
		
		this.centerPanel.setLayout(new BorderLayout());
		this.centerPanel.setOpaque(false);
		
		this.centerPanel.add(this.titleFactory.createTitle("COMING SOON...", Constants.titleSize, Constants.colorSubtitle), BorderLayout.CENTER);
		
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
