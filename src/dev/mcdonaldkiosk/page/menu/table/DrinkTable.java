package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.OrderData;

/**
 * Class Role : 음료 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon, Kim
 * @since 2017. 06. 15.
 */
public class DrinkTable extends MenuTable {

  public DrinkTable(final OrderData orderData, final int rows, final int cols) {
    super(rows, cols);
    resisterDrink(orderData);
  }

  private void resisterDrink(final OrderData orderData) {
    this.addMenu(
        createMenuButton("image/drink/prol_201312050151291100.png",
            createMenu(LangCheck.isKorean() ? "코카-콜라 제로" : "Coca-Cola Zero", 1500, 0),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "코카-콜라" : "Coca-Cola", 1500, 143),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "스프라이트" : "Sprite", 1500, 149),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "환타" : "Fanta", 1500, 167),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220224483140.png",
            createMenu(LangCheck.isKorean() ? "바닐라 쉐이크" : "Vanilla Shake", 2700, 339),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220229522730.png",
            createMenu(LangCheck.isKorean() ? "딸기 쉐이크" : "Strawberry Shake", 3700, 345),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220234029140.png",
            createMenu(LangCheck.isKorean() ? "초코 쉐이크" : "Chocolate Shake", 2700, 339),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312090535528510.png",
            createMenu(LangCheck.isKorean() ? "오렌지 주스" : "Orange Juice", 2300, 0),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312011125364160.png",
            createMenu(LangCheck.isKorean() ? "우유" : "Milk", 2000, 0),
            orderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201404220647354250.png",
            createMenu(LangCheck.isKorean() ? "생수" : "Mineral Water", 1500, 0),
            orderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "음료" : "Beverages";
  }
}
