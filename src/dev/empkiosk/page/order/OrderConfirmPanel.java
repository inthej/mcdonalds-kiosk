package dev.empkiosk.page.order;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dev.empkiosk.page.LangCheck;

/**
 * 장바구니 패널의 선택메뉴정보 확인 패널
 */
class OrderConfirmPanel extends JPanel {

    private static final JLabel ORDER_TEXT_LABEL = new JLabel();
    private static final JLabel ORDER_DATA_LABEL = new JLabel();
    private static final JButton CANCLE_BUTTON = new JButton();
    private static final JButton PAYMENT_BUTTON = new JButton();

    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color CANCLE_BTN_COLOR = Color.GRAY;
    private static final Color PAYMENT_BTN_COLR = Color.ORANGE;

    private final OrderDataList ORDER_DATA_LIST;

    OrderConfirmPanel(OrderDataList orderDataList) {
        this.ORDER_DATA_LIST = orderDataList;

        this.setLayout(new GridLayout(0, 4));
        this.setBackground(BACKGROUND_COLOR);

        initOrderTextLabel();
        initOrderDataLabel();
        initCancleButton();
        initPaymentButton();

        setListener();
    }


    private void initOrderTextLabel() {
        ORDER_TEXT_LABEL.setText(LangCheck.isKorean()
                ? "<html>주문수량<br>주문금액<br>총 칼로리</html>"
                : "<html>Order quantity<br>Order amount<br>Total calories</html>");
        ORDER_TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);

        this.add(ORDER_TEXT_LABEL);
    }

    private void initOrderDataLabel() {
        ORDER_DATA_LABEL.setText("<html>" +
                ORDER_DATA_LIST.getOrderQuantity() + "<br>" +
                ORDER_DATA_LIST.getOrderAmount() + "<br>" +
                ORDER_DATA_LIST.getOrderKCal() + "</html>");
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

    }

    JButton getCancleButton() {
        return CANCLE_BUTTON;
    }

    JButton getPaymentButton() {
        return PAYMENT_BUTTON;
    }

    // 데이터라벨 리셋
    void refleshDataLabel() {
        ORDER_DATA_LABEL.setText("<html>" +
                ORDER_DATA_LIST.getOrderQuantity() + "<br>" +
                ORDER_DATA_LIST.getOrderAmount() + "<br>" +
                ORDER_DATA_LIST.getOrderKCal() + "</html>");
    }
}
