package dev.empkiosk.page.confirm;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dev.empkiosk.page.eatplace.EatPlace;

class OrderTotalDataPanel extends JPanel {

    private final EatPlace eatPlace;
    private final OrderData[] orderDataArray;

    OrderTotalDataPanel(EatPlace eatPlace, OrderData[] orderDataArray) {
        this.eatPlace = eatPlace;
        this.orderDataArray = orderDataArray;

        initPanel();
    }

    // 패널 초기화
    private void initPanel() {
        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(new JList<OrderData>(orderDataArray)), BorderLayout.CENTER);
        this.add(createTotalListPanel(), BorderLayout.SOUTH);
    }

    // factory 공장, 만들어 낸다.
    private JPanel createTotalListPanel() {
        JPanel totalListPanel = new JPanel();
        totalListPanel.setLayout(new GridLayout(0, 4));
        totalListPanel.add(new JLabel("나의주문 : " + eatPlace.toString(), JLabel.CENTER));
        totalListPanel.add(new JLabel("주문수량 : " + orderDataArray.length, JLabel.CENTER));
        totalListPanel.add(new JLabel("주문금액 : " + getTotalAmount(), JLabel.CENTER));
        totalListPanel.add(new JLabel("총 칼로리 : " + getTotalKCal(), JLabel.CENTER));

        return totalListPanel;
    }

    private int getTotalAmount() {
        int totalAmount = 0;
        for (OrderData data : orderDataArray) {
            totalAmount += data.PRICE;
        }

        return totalAmount;
    }

    private int getTotalKCal() {
        int totalKCal = 0;
        for (OrderData data : orderDataArray) {
            totalKCal += data.K_CAL;
        }

        return totalKCal;
    }

    private static final long serialVersionUID = -8252111445137027819L;
}
