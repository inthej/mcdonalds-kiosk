package dev.empkiosk.page;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public final class KioskVoice {
	
	private static Clip clip = null;

	private KioskVoice() {
	}
	
	// 소리재생
	public synchronized static void playSound(String path) {
		if (clip != null)
			clip.stop(); // 소리중지

		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
