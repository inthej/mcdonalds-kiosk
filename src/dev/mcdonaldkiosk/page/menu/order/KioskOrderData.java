package dev.mcdonaldkiosk.page.menu.order;

import java.util.ArrayList;
import java.util.List;
import dev.mcdonaldkiosk.page.eatplace.EatPlace;
import dev.mcdonaldkiosk.page.menu.Menu;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;

/**
 * Class Role : 키오스크 주문관련(식사장소, 결제장소, 선택메뉴) 데이터 수집을 담당한다.
 * 키오스크 주문 데이터 입력, 비움이 가능하다.
 *
 * 내부적 제공하는 Calculator를 사용하여 입력된 주문의 수량, 금액, 칼로리 확인이 가능하다.
 *
 * @author Jaehyeon Kim
 */
public class KioskOrderData {

  private final List<Menu> orderMenuList = new ArrayList<>();

  private class Calculator {

    private int getOrderQuantity() {
      return orderMenuList.size();
    }

    private int getTotalAmount() {
      int totalAmount = 0;
      for (Menu menu : orderMenuList) {
        totalAmount += menu.getPrice();
      }
      return totalAmount;
    }

    private int getTotalKCal() {
      int totalKCal = 0;
      for (Menu menu : orderMenuList) {
        totalKCal += menu.getKCal();
      }

      return totalKCal;
    }
  }
  
  private final Calculator calculator = new Calculator();

  private EatPlace eatPlace;
  private PaymentPlace paymentPlace;

  public EatPlace getEatPlace() {
    return eatPlace;
  }
  
  public void setEatPlace(EatPlace place) {
    eatPlace = place;
  }

  public PaymentPlace getPaymentPlace() {
    return paymentPlace;
  }
  
  public void setPaymentPlace(PaymentPlace place) {
    paymentPlace = place;
  }

  public int getOrderQuantity() {
    return calculator.getOrderQuantity();
  }

  public int getOrderAmount() {
    return calculator.getTotalAmount();
  }

  public int getOrderKCal() {
    return calculator.getTotalKCal();
  }

  public void addMenu(Menu menu) {
    orderMenuList.add(menu);
  }

  public void clearMenu() {
    orderMenuList.clear();
  }

  public void emptyOrder() {
    orderMenuList.clear();
    eatPlace = null;
    paymentPlace = null;
  }

  public Menu[] getOrderMenuArray() {
    return orderMenuList.toArray(new Menu[orderMenuList.size()]);
  }
}
