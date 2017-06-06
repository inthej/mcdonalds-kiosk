package dev.mcdonaldkiosk.page.confirm;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dev.mcdonaldkiosk.page.eatplace.EatPlace;
import dev.mcdonaldkiosk.page.order.OrderData;
import dev.mcdonaldkiosk.page.order.OrderDataList;

class OrderTotalDataPanel extends JPanel {

	private final EatPlace eatPlace;
	private final OrderDataList ORDER_DATA_LIST;

	OrderTotalDataPanel(EatPlace eatPlace, OrderDataList orderDataList) {
		this.eatPlace = eatPlace;
		this.ORDER_DATA_LIST = orderDataList;

		initPanel();
	}

	// 패널 초기화
	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(new JList<OrderData>(ORDER_DATA_LIST.getVector())), BorderLayout.CENTER);
		this.add(createTotalListPanel(), BorderLayout.SOUTH);
	}

	// factory 공장, 만들어 낸다.
	private JPanel createTotalListPanel() {
		JPanel totalListPanel = new JPanel();
		totalListPanel.setLayout(new GridLayout(0, 4));
		totalListPanel.add(new JLabel("나의주문 : " + eatPlace.toString(), JLabel.CENTER));
		totalListPanel.add(new JLabel("주문수량 : " + ORDER_DATA_LIST.getOrderQuantity(), JLabel.CENTER));
		totalListPanel.add(new JLabel("주문금액 : " + ORDER_DATA_LIST.getOrderAmount(), JLabel.CENTER));
		totalListPanel.add(new JLabel("총 칼로리 : " + ORDER_DATA_LIST.getOrderKCal(), JLabel.CENTER));

		return totalListPanel;
	}

	private static final long serialVersionUID = -8252111445137027819L;
}
