package dev.mcdonaldkiosk.page.menu.order;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

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
	
	private int totalQuantity;
	private int totalAmount;
	private int totalKCal;

	OrderConfirmPanel(int totalQuantity, int totalAmount, int totalKCal) {
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.totalKCal = totalKCal;
		
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
		ORDER_TEXT_LABEL.setText(LangCheck.isKorean() ? "<html>주문수량<br>주문금액<br>총 칼로리</html>"
				: "<html>Order quantity<br>Order amount<br>Total calories</html>");
		ORDER_TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);
	}
	
	private void initDataLabel() {
		ORDER_DATA_LABEL.setText("<html>" + totalQuantity + "<br>" + totalAmount + "<br>" + totalKCal + "</html>");
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
			// TODO : 주문비우기
			// MyOrderPanel.clearOrderData();
		});

		PAYMENT_BUTTON.addActionListener((e) -> {
			if (totalQuantity == 0) {
				KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
						.createKioskAudioPlayer(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
				kioskAudioPlayer.play();
			} else {
				// TODO : 다음페이지 데이터 넘기기.
				// MainFrame.attachPanel(new ConfirmPage(ORDER_DATA_LIST));
			}
		});
	}
	
	void setOrderData(int totalQuantity, int totalAmount, int totalKCal) {
		this.totalQuantity = totalQuantity;
		this.totalAmount = totalAmount;
		this.totalKCal = totalKCal;
	}

	void refresh() {
		ORDER_DATA_LABEL.setText("<html>" + totalQuantity + "<br>" + totalAmount + "<br>" + totalKCal + "</html>");
	}
}
