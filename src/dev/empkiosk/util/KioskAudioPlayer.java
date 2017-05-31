package dev.empkiosk.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

import com.sun.istack.internal.NotNull;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author mommoo
 *         <p>
 *         Kiosk 컴포넌트의 오디오 요소를 담당하는 클래스이다.
 *         이미 재생한 오디오 목록은 자체적으로 저장 해놓는다.
 *         <p>
 *         사용자가 이미 재상한 오디오를 호출할 시, 캐시 데이터를 이용하여 자원의 효율성을 높인다.
 *         <p>
 *         사용자는 단순히 플레이어 재생, 플레이어 정지를 이용하면 된다.
 * @version 1.0v
 * @since 2017. 05. 31.
 */

public class KioskAudioPlayer {

    private static HashMap<String, File> audioFilePool = new HashMap<>();
    private final File audioFile;
    private AudioStream audioStream;

    private KioskAudioPlayer(File audioFile) {
        this.audioFile = audioFile;
    }

    public static KioskAudioPlayer createKisokAudioPlayer(@NotNull String audioPath) {
        if (audioFilePool.get(audioPath) == null) createNewAudioFile(audioPath);
        return new KioskAudioPlayer(audioFilePool.get(audioPath));
    }

    private static void createNewAudioFile(String audioPath) {
        File audioFile = new File(audioPath);
        audioFilePool.put(audioPath, audioFile);
    }

    private void createAudioStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.audioFile);
            this.audioStream = new AudioStream(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play() {
        createAudioStream();
        AudioPlayer.player.start(this.audioStream);
    }

    public void stop() {
        AudioPlayer.player.stop(this.audioStream);
    }
}
