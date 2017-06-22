package dev.mcdonaldkiosk.page.confirm;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.end.EndPage;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPage;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : ConfirmPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class ConfirmPageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage(KioskOrderData kioskOrderData) {
    if (kioskOrderData.getPaymentPlace() == PaymentPlace.COUNTER) {
      MainFrame.attachPanel(new EndPage(kioskOrderData));
    } else if (kioskOrderData.getPaymentPlace() == PaymentPlace.KIOSK) {
      MainFrame.attachPanel(new PaymentCardPage(kioskOrderData));
    }
  }

  @Override
  public void loadPreviousPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new MenuPage(kioskOrderData));
  }

  @Override
  public void playSoundOfLoadPage(KioskOrderData kioskOrderData) {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/check.wav" : "sound/check_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage(KioskOrderData kioskOrderData) {
    // TODO Auto-generated method stub
  }
}
