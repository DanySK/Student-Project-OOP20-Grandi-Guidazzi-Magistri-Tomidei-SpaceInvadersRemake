package menu;

import javax.swing.JPanel;

/**
 *	A class that contains all the object to create the StateGame
 */
public class StateGame implements State{
	
	private JPanel panel = new JPanel();
	
	/**
	 * The constructor of the StateGame,
	 * this state is showed when the button Start is pressed.
	 * @param board
	 */
	public StateGame(Board board) {
		
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
}
