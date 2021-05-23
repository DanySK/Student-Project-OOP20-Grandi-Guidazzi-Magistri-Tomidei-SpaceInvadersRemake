package menuController;

import menu.State;

import util.AudioImpl;

public interface menuController {

	/** The method that change the State of the menu
	 * 
	 * @param state
	 */
	void changeState(State state);
	
	/** The method return the audio manager
	 * 
	 * @return the audio manager
	 */
	AudioImpl getAudio();
}
