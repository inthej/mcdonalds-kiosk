package dev.mcdonaldkiosk.page.menu.order;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.confirm.ConfirmPage;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jaehyeon Kim
 */
class OrderDataConfirmPanel extends JPanel {

  private final JLabel ORDER_TEXT_LABEL = new JLabel();
  private final JLabel ORDER_DATA_LABEL = new JLabel();
  private final JButton CANCLE_BUTTON = new JButton();
  private final JButton PAYMENT_BUTTON = new JButton();

  private final Color BACKGROUND_COLOR = Color.WHITE;
  private final Color CANCLE_BTN_COLOR = Color.GRAY;
  private final Color PAYMENT_BTN_COLR = Color.ORANGE;

  private MenuPage menuPage;
  private final KioskOrderData kioskOrderData;

  OrderDataConfirmPanel(MenuPage menuPage, KioskOrderData kioskOrderData) {
    this.menuPage = menuPage;
    this.kioskOrderData = kioskOrderData;

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
    ORDER_DATA_LABEL.setText("<html>" + kioskOrderData.getCalculator().getOrderQuantity() +
        "<br>" + kioskOrderData.getCalculator().getOrderAmount() +
        "<br>" + kioskOrderData.getCalculator().getOrderKCal() + "</html>");
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
      kioskOrderData.clearMenu();
      menuPage.reflesh();
    });

    PAYMENT_BUTTON.addActionListener((e) -> {
      if (kioskOrderData.getCalculator().getOrderQuantity() == 0) {
        KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer.createKioskAudioPlayer(
            LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
        kioskAudioPlayer.play();
      } else {
        MainFrame.attachPanel(new ConfirmPage(kioskOrderData));
      }
    });
  }

  void refresh() {
    ORDER_DATA_LABEL.setText("<html>" + kioskOrderData.getCalculator().getOrderQuantity() +
        "<br>" + kioskOrderData.getCalculator().getOrderAmount() +
        "<br>" + kioskOrderData.getCalculator().getOrderKCal() + "</html>");
  }
}
