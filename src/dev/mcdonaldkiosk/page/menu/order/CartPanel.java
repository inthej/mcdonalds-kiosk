package dev.mcdonaldkiosk.page.menu.order;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.OrderData;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * Class Role : 장바구니 패널로서 선택한 메뉴정보를 확인할 수 있다.
 *
 * 기본 레이아웃은 BorderLayout 이다.
 * 상단 텍스트툴바(TextToolbarPanel) 패널, 중간 주문리스트(OrderListPanel) 패널, 하단 주문확인(OrderConfirmPanel) 패널로 구성되어 있다.
 *
 * @author Jaehyeon, Kim
 */
public class CartPanel extends JPanel {

  /* 주문 장바구니 리스트 */
  private final TextToolbarPanel TEXT_TOOLBAR_PANEL = new TextToolbarPanel();
  private final OrderListPanel ORDER_LIST_PANEL;
  private final OrderConfirmPanel ORDER_CONFIRM_PANEL;

  private final OrderData orderData;

  public CartPanel(KioskPageLoader kioskPageLoader, OrderData orderData) {
    this.orderData = orderData;
    ORDER_LIST_PANEL = new OrderListPanel();
    ORDER_CONFIRM_PANEL = new OrderConfirmPanel(kioskPageLoader, orderData);

    // 초기화
    initMyOrderPanel();
    addTextToTextToolbar();
  }

  private void initMyOrderPanel() {
    this.setLayout(new BorderLayout());
    this.add(TEXT_TOOLBAR_PANEL.getPanel(), BorderLayout.NORTH);
    this.add(ORDER_LIST_PANEL, BorderLayout.CENTER);
    this.add(ORDER_CONFIRM_PANEL, BorderLayout.SOUTH);
  }

  // 텍스트툴바에 텍스트 추가
  private void addTextToTextToolbar() {
    TEXT_TOOLBAR_PANEL.addText(LangCheck.isKorean() ? "메뉴" : "MENU")
        .addText(LangCheck.isKorean() ? "수량" : "QUANTITY")
        .addText(LangCheck.isKorean() ? "가격" : "PRICE");
  }

  // 새로고침
  public void reflesh() {
    ORDER_LIST_PANEL.setJListMenu(orderData.getOrderMenuArray());
    ORDER_CONFIRM_PANEL.refresh();
  }
}
