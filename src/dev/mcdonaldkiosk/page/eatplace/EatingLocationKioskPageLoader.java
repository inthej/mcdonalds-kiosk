package dev.mcdonaldkiosk.page.eatplace;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.page.start.StartPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : EatPlace의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class EatingLocationKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new PaymentPlacePage());
  }

  @Override
  public void loadPreviousPage() {
    MainFrame.attachPanel(new StartPage());
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/place.wav" : "sound/place_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    MainFrame.attachPanel(new EatingLocationPage());
  }
}
