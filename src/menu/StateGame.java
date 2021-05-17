package menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import menu.gameview.StateInGameMenu;
import model.entities.MonoDirectionPlayerBullet;
import model.entities.Player;
import model.entitiesutil.EntityDirections;
import util.Pair;

/**
 *	A class that contains all the object to create the StateGame
 */
public class StateGame implements State{
	
	private JPanel panel;
	private Player player = new Player(this.panel.getHeight()/2, this.panel.getWidth()/2);
	
	
	/**
	 * The constructor of the StateGame,
	 * this state is showed when the button Start is pressed.
	 * @param board
	 */
	public StateGame(Board board) {
		this.panel = board.getController().getView();
		
		this.panel.addKeyListener(new KeyListener(){

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_ESCAPE) {
					board.setCurrentState(new StateInGameMenu(board));
				} else if(key == KeyEvent.VK_RIGHT) {
					player.updateEntityPosition(EntityDirections.RIGHT);
				} else if(key == KeyEvent.VK_LEFT) {
					player.updateEntityPosition(EntityDirections.LEFT);
				} else if(key == KeyEvent.VK_SPACE) {
					player.shoot();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
					player.setMuX(0);
				}
				
			}
			
		});
		
		this.panel.setFocusable(true);
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	
}
