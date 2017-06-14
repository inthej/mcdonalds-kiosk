package dev.mcdonaldkiosk.page.thank;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.menu.OrderPlace;
import dev.mcdonaldkiosk.page.payment.place.PayPlace;
import dev.mcdonaldkiosk.page.welcome.WelcomePage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : ThankPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
class ThankPageKioskPageLorder implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new WelcomePage());
  }

  @Override
  public void loadPreviousPage() {
    // TODO Auto-generated method stub
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = null;

    String orderPlace = OrderPlace.getInstance().getPayPlace();
    if (orderPlace == PayPlace.COUNTER.toString()) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(
              LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav");
    } else if (orderPlace == PayPlace.KIOSK.toString()) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/thank.wav" : "sound/thank_eng.wav");
    }

    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    // TODO Auto-generated method stub
  }
}
