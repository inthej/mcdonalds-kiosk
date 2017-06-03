package dev.mcdonaldkiosk.page.order;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.util.KioskVoice;
import dev.mcdonaldkiosk.page.confirm.ConfirmPage;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 장바구니 패널의 선택메뉴정보 확인 패널
 */
class CartConfirmPanel extends JPanel {

	private static final JLabel ORDER_TEXT_LABEL = new JLabel();
	private static final JLabel ORDER_DATA_LABEL = new JLabel();
	private static final JButton CANCLE_BUTTON = new JButton();
	private static final JButton PAYMENT_BUTTON = new JButton();

	private static final Color BACKGROUND_COLOR = Color.WHITE;
	private static final Color CANCLE_BTN_COLOR = Color.GRAY;
	private static final Color PAYMENT_BTN_COLR = Color.ORANGE;

	private final OrderDataList ORDER_DATA_LIST;

	CartConfirmPanel(OrderDataList orderDataList) {
		this.ORDER_DATA_LIST = orderDataList;

		initOrderConfirmPanel();
		initOrderTextLabel();
		initOrderDataLabel();
		initCancleButton();
		initPaymentButton();

		setListener();
	}

	private void initOrderConfirmPanel() {
		this.setLayout(new GridLayout(0, 4));
		this.setBackground(BACKGROUND_COLOR);
	}

	private void initOrderTextLabel() {
		ORDER_TEXT_LABEL.setText(LangCheck.isKorean() ? "<html>주문수량<br>주문금액<br>총 칼로리</html>"
				: "<html>Order quantity<br>Order amount<br>Total calories</html>");
		ORDER_TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);

		this.add(ORDER_TEXT_LABEL);
	}

	private void initOrderDataLabel() {
		ORDER_DATA_LABEL.setText("<html>" + ORDER_DATA_LIST.getOrderQuantity() + "<br>"
				+ ORDER_DATA_LIST.getOrderAmount() + "<br>" + ORDER_DATA_LIST.getOrderKCal() + "</html>");
		ORDER_DATA_LABEL.setHorizontalAlignment(JLabel.CENTER);

		this.add(ORDER_DATA_LABEL);
	}

	private void initCancleButton() {
		CANCLE_BUTTON.setText(LangCheck.isKorean() ? "주문취소" : "CANCEL ORDER");
		CANCLE_BUTTON.setBackground(CANCLE_BTN_COLOR);

		this.add(CANCLE_BUTTON);
	}

	private void initPaymentButton() {
		PAYMENT_BUTTON.setText(LangCheck.isKorean() ? "주문진행" : "COMPLETE ORDER");
		PAYMENT_BUTTON.setBackground(PAYMENT_BTN_COLR);

		this.add(PAYMENT_BUTTON);
	}

	private void setListener() {
		CANCLE_BUTTON.addActionListener((e) -> {
			CartPanel.clearOrderData();
		});

		PAYMENT_BUTTON.addActionListener((e) -> {
			if (ORDER_DATA_LIST.getOrderQuantity() == 0) {
				KioskVoice.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
			} else {
				MainFrame.attachPanel(new ConfirmPage(ORDER_DATA_LIST));
			}
		});
	}

	// 데이터라벨 리셋
	void refleshData() {
		ORDER_DATA_LABEL.setText("<html>" + ORDER_DATA_LIST.getOrderQuantity() + "<br>"
				+ ORDER_DATA_LIST.getOrderAmount() + "<br>" + ORDER_DATA_LIST.getOrderKCal() + "</html>");
	}
	
	private static final long serialVersionUID = -8047327814420758593L;
}
