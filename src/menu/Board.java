package menu;


import java.awt.Color;

import javax.swing.BoxLayout;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import util.AudioImpl;
import util.AudioTrack;
import util.Constants;

/**
 * class that manages the change and creation of all the various states.
 */
public class Board {

	private JFrame frame = new JFrame();
	private State currentState;
	private AudioImpl audioPlayer = new AudioImpl();
	private boolean isReturningFromGame = false;
	private boolean isReturningFromMenuGame = true;
	
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
		this.audioPlayer.play(AudioTrack.SOUND_TRACK, Constants.IN_LOOP);
		setCurrentState(new StateMenu(this));
	}
	
	/**
	 * it take the new state in input and it shows the state on the frame repainting it and removing all the object of the last state.
	 * @param newState
	 */
	public void setCurrentState(State newState){
		if(newState.toString().contains("StateGame")) {
			if(this.isReturningFromMenuGame == true) {
				this.audioPlayer.stop();
				this.audioPlayer.play(AudioTrack.GAME_TRACK, Constants.IN_LOOP);
				this.isReturningFromGame = true;
				this.isReturningFromMenuGame = false;
			}
		} else if(newState.toString().contains("StateMenu")) {
			if(this.isReturningFromGame == true) {
				this.audioPlayer.stop();
				this.audioPlayer.play(AudioTrack.SOUND_TRACK, Constants.IN_LOOP);
				this.isReturningFromGame = false;
				this.isReturningFromMenuGame = true;
			}
			
		}
		
		this.frame.getContentPane().removeAll();
		this.currentState = newState;
		this.frame.getContentPane().add(currentState.getMainPanel());
		this.frame.getContentPane().setBackground(Color.black);
		this.frame.pack();
	}
	
	public AudioImpl getAudio() {
		return this.audioPlayer;
	}
	
}
