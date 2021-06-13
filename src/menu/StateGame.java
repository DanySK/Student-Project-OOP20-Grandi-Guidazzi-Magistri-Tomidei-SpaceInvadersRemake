package menu;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JPanel;

import menu.factories.LabelFactory;
import menu.gameview.StateInGameMenu;
import model.entities.PlayerBullet;
import model.entities.Player;
import model.entitiesutil.EntityDirections;
import util.Pair;
import util.Strings;

/**
 *	A class that contains all the object to create the StateGame
 */
public class StateGame implements State{
	
	private JPanel panel;
	
	
	/**
	 * The constructor of the StateGame,
	 * this state is showed when the button Start is pressed.
	 * @param board
	 */
	public StateGame(Board board) {
		//this.panel = board.getController().getView().getPanel();
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	
	@Override
	public String toString() {
		return "StateGame";
	}
	
}
