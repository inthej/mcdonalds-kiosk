package dev.empkiosk.page.order;

import dev.empkiosk.page.KioskPage;

import javax.swing.JPanel;

/**
 * Created by kimjaehyeon
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class CartPanel extends JPanel {

    /* 주문 장바구니 리스트 */
    private static final OrderDataList ORDER_DATA_LIST = new OrderDataList();

    private static final OrderTitlePanel ORDER_TITLE_PANEL = new OrderTitlePanel();
    private static final OrderScrollPanel ORDER_SCROLL_PANEL = new OrderScrollPanel(ORDER_DATA_LIST);
    private static final OrderConfirmPanel ORDER_CONFIRM_PANEL = new OrderConfirmPanel(
            ORDER_DATA_LIST);

    public CartPanel() {
        // 초기화
        this.setLayout(null);

        initOrderTitlePanel();

        initOrderScrollPanel();

        initOrderConfirmPanel();
    }

    private void initOrderTitlePanel() {
        ORDER_TITLE_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 8);
        ORDER_TITLE_PANEL.setLocation(0, 0);

        this.add(ORDER_TITLE_PANEL);
    }

    private void initOrderScrollPanel() {
        ORDER_SCROLL_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT * 5 / 8);
        ORDER_SCROLL_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT / 8);

        this.add(ORDER_SCROLL_PANEL);
    }

    private void initOrderConfirmPanel() {
        ORDER_CONFIRM_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 4);
        ORDER_CONFIRM_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT * 3 / 4);

        this.add(ORDER_CONFIRM_PANEL);
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
        ORDER_SCROLL_PANEL.setJListOrderList();
        ORDER_CONFIRM_PANEL.refleshData();
    }

    private static void cartStatus() {
        ORDER_SCROLL_PANEL.setJListOrderList();
        ORDER_SCROLL_PANEL.scrollDown();
        ORDER_CONFIRM_PANEL.refleshData();
    }
}
