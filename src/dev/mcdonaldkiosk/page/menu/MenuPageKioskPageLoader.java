package dev.mcdonaldkiosk.page.menu;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.confirm.ConfirmPage;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : MenuPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
class MenuPageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new ConfirmPage());
  }

  @Override
  public void loadPreviousPage() {
    MainFrame.attachPanel(new PaymentPlacePage());
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    // TODO : OrderConfirmPanel 연동
  }
}
