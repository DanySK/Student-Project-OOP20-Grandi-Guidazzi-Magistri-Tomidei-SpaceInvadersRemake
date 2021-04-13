package menu;


import java.awt.Color;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import util.AudioPlayer;
import util.Constants;
import util.Strings;

/**
 * class that manages the change and creation of all the various states.
 */
public class Board {

	private JFrame frame = new JFrame();
	private State currentState;
	private AudioPlayer audioPlayer = new AudioPlayer();
	
	/**
	 * the constructor of the first state in the project, it contains all the frame characteristics.
	 */
	public Board() {
		this.frame.setTitle("Space Invaders Remake");
		this.frame.setPreferredSize(Constants.preferDimension);
		this.frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		this.frame.pack();
		this.frame.setLocationRelativeTo(null);
		this.frame.setVisible(true);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.audioPlayer.startAudio(Strings.MENU_SONG, Constants.IN_LOOP);
		
		setCurrentState(new StateMenu(this));
	}
	
	/**
	 * it take the new state in input and it shows the state on the frame repainting it and removing all the object of the last state.
	 * @param newState
	 */
	public void setCurrentState(State newState){
		if(newState.toString().contains("StateGame")) {
			this.audioPlayer.stopAudio();
		}
		this.frame.getContentPane().removeAll();
		this.frame.repaint();
		this.currentState = newState;
		this.frame.getContentPane().add(currentState.getMainPanel());
		this.frame.getContentPane().setBackground(Color.black);
		this.frame.pack();
	}
	
}
