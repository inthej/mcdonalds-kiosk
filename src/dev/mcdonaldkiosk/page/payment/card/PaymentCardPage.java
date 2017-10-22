package dev.mcdonaldkiosk.page.payment.card;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.Display;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.KioskSettingData;
import dev.mcdonaldkiosk.util.ImageEdit;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Created by kimjaehyeon on 2017. 5. 25
 * Class Role : 카드 결제지불 페이지
 */
public class PaymentCardPage extends KioskPage {

  private final PaymentCardPanel PAYMENT_CARD_PANEL = new PaymentCardPanel();

  public PaymentCardPage() {
    super(new KioskSettingData.Builder()
                              .setAudioPath(LangCheck.isKorean() ? "sound/card.wav" : "sound/card_eng.wav")
                              .setNextPage(KioskPageType.END_PAGE)
                              .setPreviousPage(KioskPageType.CONFIRM_PAGE)
                              .build());

    initPage();
    initPaymentCardPanel();
    setListener();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackBtn();
  }

  private void initPaymentCardPanel() {
    final int PANEL_WIDTH = Display.WINDOWS_WIDTH_HALF * 4 / 5;
    final int PANEL_HEIGHT = Display.AVALIABLE_WINDOW_HEIGHT * 3 / 5;
    PAYMENT_CARD_PANEL.setSize(PANEL_WIDTH, PANEL_HEIGHT);
    PAYMENT_CARD_PANEL
        .setLocation((Display.WINDOWS_WIDTH_HALF - PANEL_WIDTH) / 2, Display.AVALIABLE_WINDOW_HEIGHT / 4);

    this.add(PAYMENT_CARD_PANEL);
  }

  private void setListener() {
    PAYMENT_CARD_PANEL.getImageTextButton().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
            .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/ing.wav" : "sound/ing_eng.wav");
        kioskAudioPlayer.play();

        try {
          Thread.sleep(5000);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        } finally {
          PaymentCardPage.this.loadNextPage();
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        PAYMENT_CARD_PANEL.getImageLabel().setIcon(ImageEdit.getResizeIcon(
            "image/loding.jpg", Display.WINDOWS_WIDTH_HALF * 3 / 5, Display.AVALIABLE_WINDOW_HEIGHT * 2 / 5));
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.ORANGE);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.WHITE);
      }
    });
  }
}
