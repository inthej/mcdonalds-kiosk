package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.page.eatplace.EatingPlace;
import dev.mcdonaldkiosk.page.menu.Menu;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Role : 키오스크 주문관련(식사장소, 결제장소, 선택메뉴) 데이터 수집을 담당한다.
 * 키오스크 주문 데이터 입력, 비움이 가능하다.
 *
 * 내부적 제공하는 Calculator를 사용하여 입력된 주문의 수량, 금액, 칼로리 확인이 가능하다.
 *
 * @author Jaehyeon Kim
 * @see Calculator
 * @since 2017. 6. 22.
 */
public class KioskOrderData {

  private final List<Menu> orderMenuList = new ArrayList<>();

  public class Calculator {

    public int getOrderQuantity() {
      return orderMenuList.size();
    }

    public int getOrderAmount() {
      int totalAmount = 0;
      for (Menu menu : orderMenuList) {
        totalAmount += menu.getPrice();
      }
      return totalAmount;
    }

    public int getOrderKCal() {
      int totalKCal = 0;
      for (Menu menu : orderMenuList) {
        totalKCal += menu.getKCal();
      }

      return totalKCal;
    }
  }

  private EatingPlace eatingPlace;
  private PaymentPlace paymentPlace;

  public KioskOrderData() {

  }

  private final Calculator calculator = new Calculator();

  public EatingPlace getEatingPlace() {
    return eatingPlace;
  }
  public void setEatingPlace(EatingPlace place) {
    eatingPlace = place;
  }

  public PaymentPlace getPaymentPlace() {
    return paymentPlace;
  }
  public void setPaymentPlace(PaymentPlace place) {
    paymentPlace = place;
  }

  public Calculator getCalculator() {
    return calculator;
  }

  public void addMenu(Menu menu) {
    orderMenuList.add(menu);
  }

  public void clearMenu() {
    orderMenuList.clear();
  }

  public void emptyOrder() {
    orderMenuList.clear();
    eatingPlace = null;
    paymentPlace = null;
  }

  public Menu[] getOrderMenuArray() {
    return orderMenuList.toArray(new Menu[orderMenuList.size()]);
  }
}
