package dev.mcdonaldkiosk.page.payment.card;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.util.ImageEdit;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by kimjaehyeon on 2017. 5. 25
 * Class Role : 카드 결제지불 페이지
 */
public class PaymentCardPage extends KioskPage {

  private final int MID_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
  private final int MID_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 3 / 5;

  private final PaymentCardPanel PAYMENT_CARD_PANEL = new PaymentCardPanel();

  public PaymentCardPage() {
    super(KioskPageType.PAYMENT_CARD_PAGE);
    initPage();
    initPaymentCardPanel();
    setListener();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackButton();
  }

  private void initPaymentCardPanel() {
    PAYMENT_CARD_PANEL.setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
    PAYMENT_CARD_PANEL
        .setLocation((MainFrame.FRAME_WIDTH - MID_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT
            / 4);

    this.add(PAYMENT_CARD_PANEL);
  }

  private void setListener() {
    BACK_BUTTON.addActionListener((e) -> currentPage.loadPreviousPage());

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
          currentPage.loadNextPage();
        }
      }

      @Override
      public void mousePressed(MouseEvent e) {
        PAYMENT_CARD_PANEL.getImageLabel().setIcon(ImageEdit.getResizeIcon(
            "image/loding.jpg", MainFrame.FRAME_WIDTH * 3 / 5, MainFrame.FRAME_HEIGHT
                * 2 / 5));
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
