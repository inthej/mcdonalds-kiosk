package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 디저트 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class DessertTable extends MenuTable {

  public DessertTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows,
      final int cols) {
    super(menuPage, rows, cols);
    resisterDessert(kioskOrderData);
  }

  private void resisterDessert(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/dessert/prol_201703290608504310.png",
            createMenu(LangCheck.isKorean() ? "리세스 맥플러리®" : "Reese’s McFlurry®", 2800, 300)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201601311029185960.png",
            createMenu(LangCheck.isKorean() ? "츄러스" : "Churros", 2000, 181)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201312050311223540.png",
            createMenu(LangCheck.isKorean() ? "오레오 맥플러리®" : "Oreo McFlurry®", 3000, 322)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201312041015558530.png",
            createMenu(LangCheck.isKorean() ? "딸기 오레오 맥플러리®" : "Strawberry Oreo McFlurry®", 3000,
                291)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201312050311494320.png",
            createMenu(LangCheck.isKorean() ? "초코 오레오 맥플러리®" : "Choco Oreo McFlurry®", 3000, 375)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201311280226114370.png",
            createMenu(LangCheck.isKorean() ? "초코 선데이 아이스크림" : "Chocolate Sundae", 2000, 307)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201509091159582930.png",
            createMenu(LangCheck.isKorean() ? "카라멜 선데이 아이스크림" : "Caramel Sundae", 2000, 306)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201311280223173290.png",
            createMenu(LangCheck.isKorean() ? "딸기 선데이 아이스크림" : "Strawberry Sundae", 2000, 261)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201311280221377300.png",
            createMenu(LangCheck.isKorean() ? "오레오 아포가토" : "Oreo Affogato", 2800, 248)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201311280227345110.png",
            createMenu(LangCheck.isKorean() ? "초코콘" : "Chocolate Cone", 800, 229)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/dessert/prol_201311280228539530.png",
            createMenu(LangCheck.isKorean() ? "아이스크림콘" : "Ice Cream Cone", 600, 153)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "디저트" : "Desserts";
  }
}
