package dev.empkiosk.page.confirm;

public class OrderData {

    final String MENU_NAME;
    final int PRICE;
    final int K_CAL;

    OrderData(String menuName, int price, int kCal) {
        this.MENU_NAME = menuName;
        this.PRICE = price;
        this.K_CAL = kCal;
    }

    @Override
    public String toString() {
        return MENU_NAME + "||가격 ￦" + PRICE + "||" + K_CAL + "KCal";
    }
}
