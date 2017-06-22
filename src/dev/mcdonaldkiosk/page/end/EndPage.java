package dev.mcdonaldkiosk.page.end;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * Class Role : 주문이 끝나면 보여지는 KioskPage 이다.
 * ImageTextPanel를 이용하여 이미지 베너와 텍스트를 보여준다.
 * 주문데이터는 초기화 된다.
 *
 * @author Jaehyeon Kim
 * @see ImageTextPanel
 * @since 2017. 05. 19.
 */
public class EndPage extends KioskPage {

  private final ImageTextPanel imageTextPanel = new ImageTextPanel(
      new ImageIcon("image/bg_info3.jpg"),
      LangCheck.isKorean() ? "주문이 완료되었습니다." : "YOUR ORDER IS COMPLETE");

  public EndPage(OrderData orderData) {
    super(KioskPageType.END_PAGE);

    this.orderData = orderData;
    playSound();
    orderData.emptyOrder();

    initImgTextPanel();
    setListener();
  }

  private void playSound() {
    KioskAudioPlayer kioskAudioPlayer = null;
    if (orderData.getPaymentPlace() == PaymentPlace.COUNTER) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(
              LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav");
    } else if (orderData.getPaymentPlace() == PaymentPlace.KIOSK) {
      kioskAudioPlayer = KioskAudioPlayer
          .createKioskAudioPlayer(LangCheck.isKorean() ? "sound/end.wav" : "sound/end_eng.wav");
    }
    kioskAudioPlayer.play();
  }

  private void initImgTextPanel() {
    imageTextPanel.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
    imageTextPanel.setLocation(0, 0);
    imageTextPanel.setTextBackground(Color.BLUE);

    this.add(imageTextPanel);
  }

  private void setListener() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        currentPage.loadNextPage(orderData);
      }
    });
  }
}
