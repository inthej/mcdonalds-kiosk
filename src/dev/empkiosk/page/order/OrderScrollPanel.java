package dev.empkiosk.page.order;

import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.LangCheck;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * 장바구니 패널의 선택메뉴 리스트 스크롤
 */
class OrderScrollPanel extends JScrollPane {

  public final JList<OrderData> J_LIST = new JList<>();
  private final OrderDataList ORDER_DATA_LIST;

  OrderScrollPanel(OrderDataList orderDataList) {
    ORDER_DATA_LIST = orderDataList;

    initOrderScrollPanel();
    initJList();
    scrollDown();
  }

  private void initOrderScrollPanel() {
    this.setBorder(
        BorderFactory.createTitledBorder(LangCheck.isKorean() ? "선택메뉴" : "Select Menu")); // 경계 설정
    this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로바정책
    this.setViewportView(J_LIST);
  }

  private void initJList() {
    J_LIST.setSize(KioskPage.PAGE_WIDTH,
        OrderPage.BOTTOM_HEIGHT / 2 + OrderPage.BOTTOM_HEIGHT / 4 / 2);
    J_LIST.setLocation(0, OrderPage.BOTTOM_HEIGHT / 4 - OrderPage.BOTTOM_HEIGHT / 4 / 2);
    J_LIST.setListData(ORDER_DATA_LIST.getVector());
  }

  // 스크롤을 최하단으로 내린다.
  void scrollDown() {
    getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
  }

  private static final long serialVersionUID = -3433581082175322789L;
}
