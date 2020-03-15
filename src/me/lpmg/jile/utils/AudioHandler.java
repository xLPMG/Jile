package me.lpmg.jile.utils;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.BooleanControl;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import javax.sound.sampled.Mixer;

import javazoom.jl.player.Player;
import me.lpmg.jile.Handler;

public class AudioHandler {

	private Thread audioThread;
	private Player playMP3;
	private Settings settings;
	
	public AudioHandler(Settings settings) {
		this.settings = settings;
	}

	public synchronized void playSound(final String url, boolean repeat) {

		if (audioThread != null) {
			if (audioThread.isAlive()) {
				stopPlaying();
			}
		}
		
		audioThread = new Thread(new Runnable() {
			public void run() {
				if (url.endsWith("wav")) {
					try {
						Clip clip = AudioSystem.getClip();
						AudioInputStream inputStream = AudioSystem
								.getAudioInputStream(AudioHandler.class.getResource(url));
						clip.open(inputStream);
						clip.start();
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				} else {

					try {
						String respath = url;
						InputStream in = AudioHandler.class.getResourceAsStream(respath);
						if (in == null)
							throw new Exception("resource not found: " + respath);
						playMP3 = new Player(in);

						playMP3.play();
						if(playMP3.isComplete()) {
							if(repeat) {
							playSound(url, repeat);
							}else {
						    stopPlaying();
							}
						}

					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
		});
		audioThread.start();
		if (settings != null && settings.SOUND_ON) {
			mute(true);
		}
	}

	public void stopPlaying() {
		audioThread.interrupt();
		playMP3.close();
	}

	public void mute(boolean mute) {
		Mixer.Info[] infos = AudioSystem.getMixerInfo();
		for (Mixer.Info info : infos) {
			Mixer mixer = AudioSystem.getMixer(info);
			Line[] lines = mixer.getSourceLines();
			for (Line line : lines) {
				BooleanControl bc = (BooleanControl) line.getControl(BooleanControl.Type.MUTE);
				if (bc != null) {
					bc.setValue(mute);
				}
			}
		}

	}
}
