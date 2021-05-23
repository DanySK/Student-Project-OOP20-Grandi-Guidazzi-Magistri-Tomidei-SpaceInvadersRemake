package menu.factories;

import java.awt.Color;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import menu.*;
import menu.gameview.StateAudioSettingsInGame;
import menu.gameview.StateInGameMenu;
import util.Audio;
import util.AudioImpl;
import util.AudioTrack;
//import util.AudioPlayer;
import util.Constants;
import util.Strings;

/**
 * A simple LabelFactory to avoid the repetitions.
*/
public class LabelFactory {
	
	private Audio audioPlayer = new AudioImpl();
	
	/**
	 * Create a new label made from the input parameters and with action listeners.
	 * 
	 * @param buttonType
	 * @param board
	 * @param position
	 * @return the label built
	 */
	public JLabel createButton(String buttonType, Board board, String position) {
		JLabel label = new JLabel(buttonType);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setMaximumSize(Constants.maxLabelDimension);
		label.setVisible(true);
		label.setForeground(Color.white);
		label.setFont(new Font("sans", Font.BOLD, 25));

		if(position.equals("Center")) {
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		
		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
	            label.setForeground(Color.red);
	        }
			
	        public void mouseExited(MouseEvent e) {
	            label.setForeground(Color.white);
	        }
	        
	        public void mouseClicked(MouseEvent e) {
	        	audioPlayer.play(AudioTrack.BUTTON_PRESSED, Constants.NOT_IN_LOOP);
	        	switch(label.getText()) {
	        	
	        		case Strings.START:
//	        			board.setCurrentState(new GameControllerImpl().getView());
//	        			board.getMenuController().changeState(new StateGame(board));
	        			board.setCurrentState(new StateWin(board, 10));
	        			break;
	        			
	        		case Strings.EXIT:
	        			System.exit(0);
	        			break;
	        		
	        		case Strings.ABOUT:
	        			board.getMenuController().changeState(new StateAbout(board));
	        			break;
	        		
	        		case Strings.OPTIONS:
	        			board.getMenuController().changeState(new StateOptions(board));
	        			break;
	        		
	        		case Strings.CREDITS:
	        			board.getMenuController().changeState(new StateCredits(board));
	        			break;
	        		
	        		case Strings.GO_BACK_TO_MENU:
	        			board.getMenuController().changeState(new StateMenu(board));
	        			break;
	        			
	        		case Strings.RETURN_TO_GAME_MENU:
	        			board.getMenuController().changeState(new StateInGameMenu(board));
	        			break;
	        		
	        		case Strings.LEADERBOARD:
	        			board.getMenuController().changeState(new StateLeaderboard(board));
	        			break;
	        		
	        		case Strings.CHANGE_KEYS:
	        			board.getMenuController().changeState(new StateChangeKeys(board));
	        			break;
	        		
	        		case Strings.AUDIO_SETTINGS:
	        			board.getMenuController().changeState(new StateAudioSettings(board));
	        			break;
	        			
	        		case Strings.AUDIO_SETTINGS_IN_GAME:
	        			board.getMenuController().changeState(new StateAudioSettingsInGame(board));
	        			break;
	       
	        		case Strings.RESTART:
	        			board.getMenuController().changeState(new StateGame(board));
	        			break;
	        			
	        		case Strings.RESUME:
//	        			board.getGameController().resume();
	        			break;
	        		
	        		case Strings.MORE_INFO:
	        			try {
							Desktop.getDesktop().browse(java.net.URI.create(Strings.MORE_INFO_LINK));
						} catch (IOException e1) {
							System.out.println("Link not found");
						}
	        			break;
	        	}
			}
		};
		label.addMouseListener(mouseAdapter);
		label.addMouseMotionListener(mouseAdapter);
		return label;
	}
	
	
	
}
