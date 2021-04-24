package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
	private BufferedReader reader;
	private BufferedWriter writer;

	/**
	 * The constructor creates a new Audio for each audio track.
	 */
    public AudioImpl() {
    	try {
			this.reader = new BufferedReader(new FileReader(Strings.VOLUME_URI));
			String level = this.reader.readLine().strip();
			this.volume = Float.parseFloat(level);
		} catch (IOException | NullPointerException e1) {
			this.volume = Constants.VOLUME_LEVEL_START;
			System.out.println("error in the sound files");
		}
    }
    
	@Override
	public void play(AudioTrack music, boolean inLoop) {
		this.file = new File(music.getPath());
			try {
				audioIn = AudioSystem.getAudioInputStream(file.toURI().toURL());
				this.clip = AudioSystem.getClip();
				this.clip.open(audioIn);
				this.clip.start();
				this.setVolume(this.volume);
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
			this.volume = volume;
			floatControl.setValue(gain);
			try {
				this.writer = new BufferedWriter(new FileWriter(Strings.VOLUME_URI));
				this.writer.write("" + this.getVolume());
				this.writer.close();
			} catch (IOException e1) {
				System.out.println("can't find the volume file");
			}
	}

	@Override
	public float getVolume() {
		return this.volume;
	}
	
}
