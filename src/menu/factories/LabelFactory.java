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
import menu.gameview.StateMenuInGame;
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
	        			//board.setCurrentState(new StateGame(board));
	        			board.setCurrentState(new StateMenuInGame(board));
	        			break;
	        			
	        		case Strings.EXIT:
	        			System.exit(0);
	        			break;
	        		
	        		case Strings.ABOUT:
	        			board.setCurrentState(new StateAbout(board));
	        			break;
	        		
	        		case Strings.OPTIONS:
	        			board.setCurrentState(new StateOptions(board));
	        			break;
	        		
	        		case Strings.CREDITS:
	        			board.setCurrentState(new StateCredits(board));
	        			break;
	        		
	        		case Strings.GO_BACK_TO_MENU:
	        			board.setCurrentState(new StateMenu(board));
	        			break;
	        			
	        		case Strings.RETURN_TO_GAME_MENU:
	        			board.setCurrentState(new StateMenuInGame(board));
	        			break;
	        		
	        		case Strings.LEADERBOARD:
	        			board.setCurrentState(new StateLeaderboard(board));
	        			break;
	        		
	        		case Strings.CHANGE_KEYS:
	        			board.setCurrentState(new StateChangeKeys(board));
	        			break;
	        		
	        		case Strings.AUDIO_SETTINGS:
	        			board.setCurrentState(new StateAudioSettings(board));
	        			break;
	        			
	        		case Strings.AUDIO_SETTINGS_IN_GAME:
	        			board.setCurrentState(new StateAudioSettingsInGame(board));
	        			break;
	       
	        		case Strings.RESTART:
	        			board.setCurrentState(new StateGame(board));
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
