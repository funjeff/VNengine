package resources;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;

import main.GameCode;

public class SoundPlayer implements LineListener{
	File soundFile;
	File soundFile2;
	
	private AudioFormat format;
	public SoundPlayer (){
	}
	public boolean playing = false;
	public void play (String songPath, float volume){
		
		soundFile = new File (songPath);
		try {
		AudioInputStream ais;
		ais = AudioSystem.getAudioInputStream(soundFile);
		format = ais.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		GameCode.clip = (Clip) AudioSystem.getLine (info);
		GameCode.clip.addLineListener(this);
		GameCode.clip.open (ais);
		FloatControl gainControl = (FloatControl) GameCode.clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
		GameCode.clip.start();
		GameCode.clip.loop(Clip.LOOP_CONTINUOUSLY);
		playing = true;
		} catch (Exception e){
		System.out.println("whoops (error message) ");
		System.out.println(songPath);
		}
		
	}
	public boolean isPlaying () {
		return playing;
	}
	public void playSoundEffect (float volume, String effectName){
		Clip clip2;
		soundFile2 = new File (effectName);
		try {
			AudioInputStream ais2;
			AudioFormat format2;
		ais2 = AudioSystem.getAudioInputStream(soundFile2);
		format2 = ais2.getFormat();
		DataLine.Info info2 = new DataLine.Info(Clip.class, format2);
		clip2 = (Clip) AudioSystem.getLine (info2);
		clip2.open (ais2);
		FloatControl gainControl2 = (FloatControl) clip2.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl2.setValue(volume);
		clip2.start();
		
		} catch (Exception e){
		System.out.println("whoops (error message) ");
		}
	}
	@Override
	public void update(LineEvent event) {
		if (event.getType() == LineEvent.Type.START){
			playing = true;
		} else {
			if (event.getType() == LineEvent.Type.STOP){
				GameCode.clip.stop ();
				GameCode.clip.flush ();
				GameCode.clip.setFramePosition(0);
				playing = false;
		}
			
		}
		
	}

}
