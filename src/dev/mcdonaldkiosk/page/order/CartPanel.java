package dev.mcdonaldkiosk.page.order;

import javax.swing.JPanel;

import dev.mcdonaldkiosk.page.KioskPage;

/**
 * Created by kimjaehyeon 
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class CartPanel extends JPanel {

	/* 주문 장바구니 리스트 */
	private static final OrderDataList ORDER_DATA_LIST = new OrderDataList();

	private static final CartTitlePanel CART_TITLE_PANEL = new CartTitlePanel();
	private static final CartScrollPanel CART_SCROLL_PANEL = new CartScrollPanel(ORDER_DATA_LIST);
	private static final CartConfirmPanel CART_ORDER_CONFIRM_PANEL = new CartConfirmPanel(ORDER_DATA_LIST);

	public CartPanel() {
		// 초기화
		this.setLayout(null);

		initCartTitlePanel();

		initCartScrollPanel();

		initCartOrderConfirmPanel();
	}

	private void initCartTitlePanel() {
		CART_TITLE_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 8);
		CART_TITLE_PANEL.setLocation(0, 0);

		this.add(CART_TITLE_PANEL);
	}

	private void initCartScrollPanel() {
		CART_SCROLL_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT * 5 / 8);
		CART_SCROLL_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT / 8);

		this.add(CART_SCROLL_PANEL);
	}

	private void initCartOrderConfirmPanel() {
		CART_ORDER_CONFIRM_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 4);
		CART_ORDER_CONFIRM_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT * 3 / 4);

		this.add(CART_ORDER_CONFIRM_PANEL);
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
