package dev.empkiosk.page.order;

import java.util.Vector;

/**
 * Created by kimjaehyeon
 * Class Role : 선택메뉴의 데이터를 제공한다.
 */
public class OrderDataList {

  private static final Vector<OrderData> SELECTED_MENU_LIST = new Vector<>();

  // 선택 메뉴 추가
  public void add(OrderData order) {
    SELECTED_MENU_LIST.add(order);
  }

  // 선택 메뉴 비우기
  public void clear() {
    SELECTED_MENU_LIST.clear();
  }

  // 총 수량
  public int getOrderQuantity() {
    return SELECTED_MENU_LIST.size();
  }

  // 총 금액
  public int getOrderAmount() {
    int totalAmount = 0;
    for (OrderData order : SELECTED_MENU_LIST) {
      totalAmount += order.getPrice();
    }

    return totalAmount;
  }

  // 총 칼로리
  public int getOrderKCal() {
    int totalKCal = 0;
    for (OrderData order : SELECTED_MENU_LIST) {
      totalKCal += order.getPrice();
    }

    return totalKCal;
  }

  public Vector<OrderData> getVector() {
    return SELECTED_MENU_LIST;
  }
}
