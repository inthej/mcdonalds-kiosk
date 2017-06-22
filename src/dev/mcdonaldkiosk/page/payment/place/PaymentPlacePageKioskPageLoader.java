package dev.mcdonaldkiosk.page.payment.place;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.eatplace.EatingPlacePage;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : PaymentPlacePage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class PaymentPlacePageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new MenuPage(kioskOrderData));
  }

  @Override
  public void loadPreviousPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new EatingPlacePage(kioskOrderData));
  }

  @Override
  public void playSoundOfLoadPage(KioskOrderData kioskOrderData) {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/pay.wav" : "sound/pay_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage(KioskOrderData kioskOrderData) {
    // TODO Auto-generated method stub

  }
}
