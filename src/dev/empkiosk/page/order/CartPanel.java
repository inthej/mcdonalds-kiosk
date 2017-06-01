package dev.empkiosk.page.order;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.confirm.ConfirmPage;

/**
 * Created by kimjaehyeon
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class CartPanel extends JPanel {

    // 선택 메뉴 리스트
    private final OrderDataList ORDER_DATA_LIST = new OrderDataList();

    private final OrderTitlePanel ORDER_TITLE_PANEL = new OrderTitlePanel();
    private final OrderScrollPanel ORDER_SCROLL_PANEL = new OrderScrollPanel(ORDER_DATA_LIST);
    private final OrderConfirmPanel ORDER_CONFIRM_PANEL = new OrderConfirmPanel(ORDER_DATA_LIST);


    public CartPanel() {
        // 초기화
        this.setLayout(null);

        initOrderTitlePanel();

        initOrderScrollPanel();

        initOrderConfirmPanel();

        setListener();
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

    // 여기서 해야하는지?
    private void setListener() {
        ORDER_CONFIRM_PANEL.getCancleButton().addActionListener((args) -> {
            emptyOrderData();
            ORDER_SCROLL_PANEL.scrollDown();
            ORDER_CONFIRM_PANEL.refleshDataLabel();
        });

        ORDER_CONFIRM_PANEL.getPaymentButton().addActionListener((args) -> {
            if (ORDER_DATA_LIST.getOrderQuantity() == 0) {
                KioskVoice.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
            } else {
                MainFrame.attachPanel(new ConfirmPage());
            }
        });
    }

    OrderScrollPanel getOrderScrollPanel() {
        return ORDER_SCROLL_PANEL;
    }

    OrderConfirmPanel getOrderConfirmPanel() {
        return ORDER_CONFIRM_PANEL;
    }

    // 주문 넣기
    void addOrderData(OrderData orderData) {
        ORDER_DATA_LIST.add(orderData);
    }

    // 주문 비우기
    public void emptyOrderData() {
        ORDER_DATA_LIST.clear();
    }
}
