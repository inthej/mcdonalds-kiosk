package dev.mcdonaldkiosk.util;

import com.sun.istack.internal.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import javax.sound.sampled.Clip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author mommoo
 *         <p>
 *         Kiosk 컴포넌트의 오디오 요소를 담당하는 클래스이다. 이미 재생한 오디오 목록은 자체적으로 저장 해놓는다.
 *         <p>
 *         사용자가 이미 재상한 오디오를 호출할 시, 캐시 데이터를 이용하여 자원의 효율성을 높인다.
 *         <p>
 *         사용자는 단순히 플레이어 재생, 플레이어 정지를 이용하면 된다.
 * @version 1.0v
 * @since 2017. 05. 31.
 */

public class KioskAudioPlayer {

	private static final HashMap<String, File> audioFilePool = new HashMap<>();
	private final File audioFile;
	private AudioStream audioStream;
	

	// 오디오파일 필수
	private KioskAudioPlayer(File audioFile) {
		this.audioFile = audioFile;
	}

	/**
	 * 분석 
	 * audioPath를 key로 사용을 하며 filePoll에 입력된 키의 값이 null이면 createNewAudioFile을 호출한다. 
	 * return 으로는 해당경로의 파일을 가지고 있는 KioskAudioPlayer를 리턴한다
	 * <p>
	 * 해당메서드를 다른쪽에서 사용할 수 있도록 공개하여서 필요하면 실행가능한 KioskAudioPlayer를 얻을수 있다.
	 */
	public static KioskAudioPlayer createKioskAudioPlayer(@NotNull String audioPath) {
		if (audioFilePool.get(audioPath) == null) {
			createNewAudioFile(audioPath);
		}
		return new KioskAudioPlayer(audioFilePool.get(audioPath));
	}

	/**
	 * 분석 
	 * 입력된 오디오경로를 통해서 파일을 생성하고 FilePool에 Key:경로명, Value:파일을 등록한다.
	 */
	private static void createNewAudioFile(String audioPath) {
		File audioFile = new File(audioPath);
		audioFilePool.put(audioPath, audioFile);
	}

	/**
	 * 분석 
	 * KioskAudioPlay 자신이 가지고있는 파일객체를 통해서 AudioStream을 생성한다.
	 */
	private void createAudioStream() {
		try {
			FileInputStream fileInputStream = new FileInputStream(this.audioFile);
			this.audioStream = new AudioStream(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 분석 오디오를 실행한다. 
	 * 다른곳에서 사용할 수 있도록 한다.
	 */
	public void play() {
		createAudioStream();
		AudioPlayer.player.start(this.audioStream);
	}

	/**
	 * 분석 오디오를 중지한다. 
	 * TODO (jaehyeon) : 중지 로직 구현
	 */
	public void stop() {
		AudioPlayer.player.stop(this.audioStream);
	}
}
