package menu;

import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import view.GraphicsView;


/**
 *	A class that contains all the object to create the StateGame
 */
public class StateGame implements State{
	
	private JPanel panel;
	private Board board;
	
	/**
	 * The constructor of the StateGame,
	 * this state is showed when the button Start is pressed.
	 * @param board
	 * @param skinUri 
	 */
	public StateGame(Board board, String skinUri) {
			this.board = board;
			if(skinUri.isBlank()) {
				//messaggio di errore
				System.exit(1);
			}
			else {
				try {
					this.panel = new GraphicsView(skinUri, board.getController());
				}
				catch (IOException e) {
					e.printStackTrace();
					System.exit(1);
				}

			}
	}
	
	public StateGame(Board board) {
		//this(board, board.getPlayerSkin());
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	

	public void refresh() {
		SwingUtilities.invokeLater(()->this.panel.repaint());
	}

}
