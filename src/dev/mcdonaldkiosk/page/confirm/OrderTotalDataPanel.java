package dev.mcdonaldkiosk.page.confirm;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dev.mcdonaldkiosk.page.eatplace.EatPlace;
import dev.mcdonaldkiosk.page.menu.Menu;
import dev.mcdonaldkiosk.page.menu.order.OrderDataModel;

class OrderTotalDataPanel extends JPanel {

	private final EatPlace eatPlace;
	private final OrderDataModel ORDER_DATA_LIST;

	OrderTotalDataPanel(EatPlace eatPlace, OrderDataModel orderDataModel) {
		this.eatPlace = eatPlace;
		this.ORDER_DATA_LIST = orderDataModel;

		initPanel();
	}

	// 패널 초기화
	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(new JList<Menu>(ORDER_DATA_LIST.getOrderMenuArray())), BorderLayout.CENTER);
		this.add(createTotalListPanel(), BorderLayout.SOUTH);
	}

	// factory 공장, 만들어 낸다.
	private JPanel createTotalListPanel() {
		JPanel totalListPanel = new JPanel();
		totalListPanel.setLayout(new GridLayout(0, 4));
		totalListPanel.add(new JLabel("나의주문 : " + eatPlace.toString(), JLabel.CENTER));
		totalListPanel.add(new JLabel("주문수량 : " + ORDER_DATA_LIST.getTotalQuantity(), JLabel.CENTER));
		totalListPanel.add(new JLabel("주문금액 : " + ORDER_DATA_LIST.getTotalAmount(), JLabel.CENTER));
		totalListPanel.add(new JLabel("총 칼로리 : " + ORDER_DATA_LIST.getTotalKCal(), JLabel.CENTER));

		return totalListPanel;
	}
}
