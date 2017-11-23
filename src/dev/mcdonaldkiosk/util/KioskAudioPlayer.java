package dev.mcdonaldkiosk.util;

import com.sun.istack.internal.NotNull;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Class Role : 프로그램의 오디오 실행을 담당한다.
 *
 * 생성된 사운드는 audioFilePool에 저장된다.
 * 이미 생성된 사운드를 다시 재생할 시, audioFilePool에 저장된 사운드를 사용한다. (캐시 데이터 사용으로 리소스 사용의 효율성을 높인다.)
 * 사용자는 단순히 플레이어 재생을 이용하면 된다.
 *
 * @author Jaehyeon Kim
 */
public class KioskAudioPlayer {

  private static final Map<String, File> audioFilePool = new HashMap<>();
  private static Clip clip;
  private final File audioFile;

  private AudioInputStream audioInputStream;

  private KioskAudioPlayer(File audioFile) {
    this.audioFile = audioFile;
  }

  /**
   * 오디오 재생이 가능한 플레이어를 생성한다.
   * @return 오디오 경로에 해당하는 KioskAudioPlayer
   */
  public static KioskAudioPlayer newInstance(@NotNull String audioPath) {
    if (audioFilePool.get(audioPath) == null) {
      putNewAudioFile(audioPath);
    }
    return new KioskAudioPlayer(audioFilePool.get(audioPath));
  }

  /**
   * audioFilePool에 새로운 오디오 파일을 넣는다.
   */
  private static void putNewAudioFile(String audioPath) {
    audioFilePool.put(audioPath, createNewAudioFile(audioPath));
  }

  /**
   * 오디오 경로에 해당하는 파일을 생성한다.
   */
  private static File createNewAudioFile(String audioPath) {
    return new File(audioPath);
  }

  /**
   * 오디오 플레이어를 실행한다.
   */
  public void play() {
    stopSound();
    createAudioInputStream();
    playSound();
  }

  /**
   * 소리 재생을 중지한다.
   */
  private void stopSound() {
    if (clip != null) {
      clip.stop();
    }
  }

  /**
   * 오디오 파일을 통해서 AudioInputStream 을 생성한다.
   */
  private void createAudioInputStream() {
    try {
      audioInputStream = AudioSystem.getAudioInputStream(audioFile);
    } catch (UnsupportedAudioFileException | IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 소리를 재생한다.
   */
  private void playSound() {
    try {
      clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
    } catch (LineUnavailableException | IOException e) {
      e.printStackTrace();
    }
  }
}
