package dev.mcdonaldkiosk.page.order;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import dev.mcdonaldkiosk.lang.LangCheck;

/**
 * Created by kimjaehyeon 
 * Class Role : 선택한 주문확인을 담당한다.
 */
public class MyOrderPanel extends JPanel {

	/* 주문 장바구니 리스트 */
	private static final OrderDataList ORDER_DATA_LIST = new OrderDataList();

	private final TextToolbarPanel TEXT_TOOLBAR_PANEL = new TextToolbarPanel();
	private static final CartScrollPanel CART_SCROLL_PANEL = new CartScrollPanel(ORDER_DATA_LIST);
	private static final CartConfirmPanel CART_ORDER_CONFIRM_PANEL = new CartConfirmPanel(ORDER_DATA_LIST);

	public MyOrderPanel() {
		// 초기화
		initMyOrderPanel();
		addTextToTextToolbar();
	}
	
	private void initMyOrderPanel() {
		this.setLayout(new BorderLayout());
		this.add(TEXT_TOOLBAR_PANEL.getPanel(), BorderLayout.NORTH);
		this.add(CART_SCROLL_PANEL, BorderLayout.CENTER);
		this.add(CART_ORDER_CONFIRM_PANEL, BorderLayout.SOUTH);
	}
	
	// 텍스트툴바에 데이터 추가
	private void addTextToTextToolbar() {
		TEXT_TOOLBAR_PANEL.addText(LangCheck.isKorean() ? "메뉴" : "MENU")
		.addText(LangCheck.isKorean() ? "수량" : "QUANTITY")
		.addText(LangCheck.isKorean() ? "가격" : "PRICE");
	}

	// 주문 넣기
	static void addOrder(OrderData orderData) {
		// 데이터추가
		ORDER_DATA_LIST.add(orderData);

		cartStatus();
	}

	// 주문 비우기
	static void emptyOrder() {
		ORDER_DATA_LIST.clear();

		cartStatus();
	}

	public static void clearOrderData() {
		ORDER_DATA_LIST.clear();
		CART_SCROLL_PANEL.setJListOrderList();
		CART_ORDER_CONFIRM_PANEL.refleshData();
	}

	private static void cartStatus() {
		CART_SCROLL_PANEL.setJListOrderList();
		CART_SCROLL_PANEL.scrollDown();
		CART_ORDER_CONFIRM_PANEL.refleshData();
	}
	
	private static final long serialVersionUID = 3529877822808691105L;
}
