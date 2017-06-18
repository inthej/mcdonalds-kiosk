package dev.mcdonaldkiosk.page.welcome;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.eatplace.EatPlacePage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : WelcomePage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class WelcomePageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new EatPlacePage(KioskPageType.EAT_PLACE_PAGE));
  }

  @Override
  public void loadPreviousPage() {
    // TODO Auto-generated method stub
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(
            LangCheck.isKorean() ? "sound/welcome.wav" : "sound/welcome_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    // TODO Auto-generated method stub
  }
}
