package dev.mcdonaldkiosk.page.eatplace;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.page.start.StartPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : EatPlace의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class EatingPlaceKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new PaymentPlacePage(kioskOrderData));
  }

  @Override
  public void loadPreviousPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new StartPage());
  }

  @Override
  public void playSoundOfLoadPage(KioskOrderData kioskOrderData) {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/place.wav" : "sound/place_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage(KioskOrderData kioskOrderData) {
    MainFrame.attachPanel(new EatingPlacePage(kioskOrderData));
  }
}