package dev.mcdonaldkiosk.page.confirm;

import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.page.menu.Menu;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class OrderTotalDataPanel extends JPanel {

  private final OrderData orderData;

  OrderTotalDataPanel(OrderData orderData) {
    this.orderData = orderData;

    initPanel();
  }

  // 패널 초기화
  private void initPanel() {
    this.setLayout(new BorderLayout());
    this.add(new JScrollPane(new JList<Menu>(orderData.getOrderMenuArray())),
        BorderLayout.CENTER);
    this.add(createTotalListPanel(), BorderLayout.SOUTH);
  }

  // factory 공장, 만들어 낸다.
  private JPanel createTotalListPanel() {
    JPanel totalListPanel = new JPanel();
    totalListPanel.setLayout(new GridLayout(0, 4));
    totalListPanel.add(new JLabel("나의주문 : " + orderData.getEatingPlace(), JLabel.CENTER));
    totalListPanel.add(new JLabel("주문수량 : " + orderData.getCalculator().getOrderQuantity(), JLabel.CENTER));
    totalListPanel.add(new JLabel("주문금액 : " + orderData.getCalculator().getOrderAmount(), JLabel.CENTER));
    totalListPanel.add(new JLabel("총 칼로리 : " + orderData.getCalculator().getOrderKCal(), JLabel.CENTER));

    return totalListPanel;
  }
}
