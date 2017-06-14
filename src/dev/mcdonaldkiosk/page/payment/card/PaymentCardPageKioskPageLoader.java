package dev.mcdonaldkiosk.page.payment.card;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.confirm.ConfirmPage;
import dev.mcdonaldkiosk.page.thank.ThankPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : PaymentCardPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
class PaymentCardPageKioskPageLoader implements KioskPageLoader {

  @Override
  public void loadNextPage() {
    MainFrame.attachPanel(new ThankPage());
  }

  @Override
  public void loadPreviousPage() {
    MainFrame.attachPanel(new ConfirmPage());
  }

  @Override
  public void playSoundOfLoadPage() {
    KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
        .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/card.wav" : "sound/card_eng.wav");
    kioskAudioPlayer.play();
  }

  @Override
  public void refreshPage() {
    // TODO Auto-generated method stub
  }
}
