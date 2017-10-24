package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 맥 런치 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class McLunchTable extends MenuTable {

  public McLunchTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows,
      final int cols) {
    super(menuPage, rows, cols);
    resisterMcLunch(kioskOrderData);
  }

  private void resisterMcLunch(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201704280826064130.png",
            createMenu(
                LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
                5500, 988)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201402210535304330.png",
            createMenu(LangCheck.isKorean() ? "빅맥® 세트" : "Big Mac®<br>Extra Value Meal", 4900, 880)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201312021239480850.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트"
                : "McSpicy™ Shanghai Burger<br>Extra Value Meal", 4900, 831)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201508070731369560.png",
            createMenu(LangCheck.isKorean() ? "1955 버거™ 세트" : "1955 Burger™<br>Extra Value Meal",
                5900, 877)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201312021239276890.png",
            createMenu(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트"
                : "Quarter Pounder® with Cheese<br>Extra Value Meal", 5400, 864)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201612221010079000.png",
            createMenu(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal", 4900, 772)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201612221010197520.png",
            createMenu(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal", 5900, 893)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201312021239122200.png",
            createMenu(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트"
                : "Bacon Tomato Deluxe™<br>Extra Value Meal", 5500, 887)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201312021240387800.png",
            createMenu(LangCheck.isKorean() ? "불고기 버거 세트" : "Bulgogi Burger<br>Extra Value Meal",
                3500, 767)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_lunch/prol_201312021240536440.png",
            createMenu(
                LangCheck.isKorean() ? "더블 불고기 버거 세트" : "Double Bulgogi Burger<br>Extra Value Meal",
                4900, 1014)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "맥런치™" : "McLunch™";
  }
}
