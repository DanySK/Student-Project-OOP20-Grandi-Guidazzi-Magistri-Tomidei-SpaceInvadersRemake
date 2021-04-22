package util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A simple class to handle music and sounds.
 */
public class AudioPlayer {

	private Clip clip;
	private File file;
	private AudioInputStream audioIn;
	
	/**
	 * A method to start music or sounds.
	 * @param uri
	 * @param loop
	 */
	public void startAudio(String uri, boolean loop) {
		this.file = new File(uri);
		try {
			audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
			this.clip = AudioSystem.getClip();
			this.clip.open(audioIn);
			this.clip.start();
			if(loop) {
				this.clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("error in the sound files");
		}      
	}
	
	/**
	 * A method to stop music or sounds.
	 */
	public void stopAudio() {
		this.clip.stop();
	}
}
