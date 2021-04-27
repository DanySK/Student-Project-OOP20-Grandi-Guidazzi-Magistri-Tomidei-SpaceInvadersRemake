package menu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import menu.gameview.StateInGameMenu;
import model.entities.Player;
import util.Pair;

/**
 *	A class that contains all the object to create the StateGame
 */
public class StateGame implements State{
	
	private JPanel panel = new JPanel();
	private Player player = new Player(new Pair<>(this.panel.getHeight()/2, this.panel.getWidth()/2));
	
	
	/**
	 * The constructor of the StateGame,
	 * this state is showed when the button Start is pressed.
	 * @param board
	 */
	public StateGame(Board board) {
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
					player.moveRight();
				} else if(key == KeyEvent.VK_LEFT) {
					player.moveLeft();
				} else if(key == KeyEvent.VK_SPACE) {
					//MonoDirectionEnemyBullet shot = new MonoDirectionEnemyBullet(new Pair<>(getX(), getY()), strImages);
					//sparo devo implementarlo da capo anche se cambio solo up al posto di down?
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				/*int key = e.getKeyCode();
				
				if(key == KeyEvent.VK_RIGHT) {
					setX(getX());
				} else if(key == KeyEvent.VK_LEFT) {
					setX(getX());
				}*/
			}
			
		});
		this.panel.setFocusable(true);
	}
	
	@Override
	public JPanel getMainPanel() {
		return this.panel;
	}
	
}
