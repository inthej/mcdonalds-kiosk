package dev.mcdonaldkiosk.page.start;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.eatplace.EatingLocationPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : WelcomePage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class StartPageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new EatingLocationPage());
  }

  @Override
  public void loadPreviousPage() {
    // TODO Auto-generated method stub
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(
            LangCheck.isKorean() ? "sound/start.wav" : "sound/start_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    // TODO Auto-generated method stub
  }
}
