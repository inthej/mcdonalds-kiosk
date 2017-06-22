package dev.mcdonaldkiosk.page.menu.order;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 장바구니 패널의 선택메뉴정보 확인 패널
 */
class OrderConfirmPanel extends JPanel {

  private final JLabel ORDER_TEXT_LABEL = new JLabel();
  private final JLabel ORDER_DATA_LABEL = new JLabel();
  private final JButton CANCLE_BUTTON = new JButton();
  private final JButton PAYMENT_BUTTON = new JButton();

  private final Color BACKGROUND_COLOR = Color.WHITE;
  private final Color CANCLE_BTN_COLOR = Color.GRAY;
  private final Color PAYMENT_BTN_COLR = Color.ORANGE;

  private final KioskPageLoader kioskPageLoader;
  private final OrderData orderData;

  OrderConfirmPanel(KioskPageLoader kioskPageLoader, OrderData orderData) {
    this.kioskPageLoader = kioskPageLoader;
    this.orderData = orderData;

    initOrderConfirmPanel();

    initTextLabel();
    initDataLabel();
    initButton();

    setListener();
  }

  private void initOrderConfirmPanel() {
    this.setLayout(new GridLayout(0, 4));
    this.setBackground(BACKGROUND_COLOR);
    this.add(ORDER_TEXT_LABEL);
    this.add(ORDER_DATA_LABEL);
    this.add(CANCLE_BUTTON);
    this.add(PAYMENT_BUTTON);
  }

  private void initTextLabel() {
    ORDER_TEXT_LABEL.setText(LangCheck.isKorean()
        ? "<html>주문수량<br>주문금액<br>총 칼로리</html>"
        : "<html>Order quantity<br>Order amount<br>Total calories</html>");
    ORDER_TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);
  }

  private void initDataLabel() {
    ORDER_DATA_LABEL.setText("<html>" + orderData.getCalculator().getOrderQuantity() +
        "<br>" + orderData.getCalculator().getOrderAmount() +
        "<br>" + orderData.getCalculator().getOrderKCal() + "</html>");
    ORDER_DATA_LABEL.setHorizontalAlignment(JLabel.CENTER);
  }

  private void initButton() {
    CANCLE_BUTTON.setText(LangCheck.isKorean() ? "주문취소" : "CANCEL ORDER");
    CANCLE_BUTTON.setBackground(CANCLE_BTN_COLOR);

    PAYMENT_BUTTON.setText(LangCheck.isKorean() ? "주문진행" : "COMPLETE ORDER");
    PAYMENT_BUTTON.setBackground(PAYMENT_BTN_COLR);
  }

  private void setListener() {
    CANCLE_BUTTON.addActionListener((e) -> {
      orderData.clearMenu();
      kioskPageLoader.refreshPage(orderData);
    });

    PAYMENT_BUTTON.addActionListener((e) -> {
      if (orderData.getCalculator().getOrderQuantity() == 0) {
        KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer.createKioskAudioPlayer(
            LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
        kioskAudioPlayer.play();
      } else {
        kioskPageLoader.loadNextPage(orderData);
      }
    });
  }

  void refresh() {
    ORDER_DATA_LABEL.setText("<html>" + orderData.getCalculator().getOrderQuantity() +
        "<br>" + orderData.getCalculator().getOrderAmount() +
        "<br>" + orderData.getCalculator().getOrderKCal() + "</html>");
  }
}
