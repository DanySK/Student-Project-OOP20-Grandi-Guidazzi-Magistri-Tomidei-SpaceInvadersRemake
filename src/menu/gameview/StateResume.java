package menu.gameview;

import javax.swing.JPanel;

import menu.Board;
import menu.State;
import menu.factories.LabelFactory;
import menu.factories.TitleFactory;

/**
 * A class that contains all the objects to create the StateResume.
 */
public class StateResume implements State{

	private LabelFactory labelFactory = new LabelFactory();
	private TitleFactory titleFactory = new TitleFactory();
	private JPanel panel = new JPanel();
	private JPanel centerPanel = new JPanel();
	
	public StateResume(Board board) {
		
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}

}
