package util;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import menu.Board;


public class AudioImpl implements Audio{
	
	private Clip clip;
	private File file;
	private AudioInputStream audioIn;
	private float gain;
	private float volume;

	/**
	 * The constructor creates a new Audio for each audio track.
	 */
    public AudioImpl() {
    	this.volume = Constants.VOLUME_LEVEL_START;
    }
    
	@Override
	public void play(AudioTrack music, boolean inLoop) {
		this.file = new File(music.getPath());
			try {
				audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
				this.clip = AudioSystem.getClip();
				this.clip.open(audioIn);
				this.clip.start();
				if(inLoop) {
					this.clip.loop(Clip.LOOP_CONTINUOUSLY);
				}
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				System.out.println("error in the sound files");
			}	
	}

	@Override
	public void stop() {
		this.clip.stop();	
	}

	@Override
	public void setVolume(float volume) {
			FloatControl floatControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float range = floatControl.getMaximum() - floatControl.getMinimum();
			this.gain = (range * volume) + floatControl.getMinimum();
			floatControl.setValue(gain);
	}

	@Override
	public float getVolume() {
		return this.volume;
	}


}
