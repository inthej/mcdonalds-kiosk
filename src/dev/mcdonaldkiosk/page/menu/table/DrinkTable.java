package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 음료 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class DrinkTable extends MenuTable {

  public DrinkTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows, final int cols) {
    super(menuPage, rows, cols);
    resisterDrink(kioskOrderData);
  }

  private void resisterDrink(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/drink/prol_201312050151291100.png",
            createMenu(LangCheck.isKorean() ? "코카-콜라 제로" : "Coca-Cola Zero", 1500, 0)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "코카-콜라" : "Coca-Cola", 1500, 143)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "스프라이트" : "Sprite", 1500, 149)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312050152466340.png",
            createMenu(LangCheck.isKorean() ? "환타" : "Fanta", 1500, 167)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220224483140.png",
            createMenu(LangCheck.isKorean() ? "바닐라 쉐이크" : "Vanilla Shake", 2700, 339)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220229522730.png",
            createMenu(LangCheck.isKorean() ? "딸기 쉐이크" : "Strawberry Shake", 3700, 345)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201402220234029140.png",
            createMenu(LangCheck.isKorean() ? "초코 쉐이크" : "Chocolate Shake", 2700, 339)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312090535528510.png",
            createMenu(LangCheck.isKorean() ? "오렌지 주스" : "Orange Juice", 2300, 0)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201312011125364160.png",
            createMenu(LangCheck.isKorean() ? "우유" : "Milk", 2000, 0)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/drink/prol_201404220647354250.png",
            createMenu(LangCheck.isKorean() ? "생수" : "Mineral Water", 1500, 0)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "음료" : "Beverages";
  }
}
