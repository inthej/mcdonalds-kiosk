package dev.mcdonaldkiosk.page.end;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import dev.mcdonaldkiosk.page.start.StartPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : ThankPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class EndPageKioskPageLorder implements KioskPageLoader {

  @Override
  public void loadNextPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new StartPage());
  }

  @Override
  public void loadPreviousPage(KioskOrderData kioskOrderData) {
    // TODO Auto-generated method stub
  }

  @Override
  public void playSoundOfLoadPage(KioskOrderData kioskOrderData) {
    KioskAudioPlayer kioskAudioPlayer = null;
    if (kioskOrderData.getPaymentPlace() == PaymentPlace.COUNTER) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(
              LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav");
    } else if (kioskOrderData.getPaymentPlace() == PaymentPlace.KIOSK) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/end.wav" : "sound/end_eng.wav");
    }
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage(KioskOrderData kioskOrderData) {
    // TODO Auto-generated method stub
  }
}
