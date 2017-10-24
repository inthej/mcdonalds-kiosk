package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 세트 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class SetMenuTable extends MenuTable {

  public SetMenuTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows,
      final int cols) {
    super(menuPage, rows, cols);
    resisterSetMenu(kioskOrderData);
  }

  private void resisterSetMenu(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/set_menu/prol_201703290425058560.png",
            createMenu(LangCheck.isKorean() ? "골든 에그 치즈버거 세트" : "Golden Egg Cheeseburger Meal",
                9700, 1004)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201703290425447840.png",
            createMenu(LangCheck.isKorean() ? "그릴드 머쉬룸 버거 세트" : "Grilled Mushroom Burger Meal",
                9700, 1047)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201704280826064130.png",
            createMenu(
                LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
                7100, 988)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201402210535304330.png",
            createMenu(LangCheck.isKorean() ? "빅맥® 세트" : "Big Mac® Extra<br>Value Meal", 6300, 880)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201605160956103670.png",
            createMenu(LangCheck.isKorean() ? "메가맥 세트" : "Mega Mac Extra Value Meal", 7600, 1062)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312021239480850.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트"
                : "McSpicy™ Shanghai Burger<br>Extra Value Meal", 6300, 831)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201508070731369560.png",
            createMenu(LangCheck.isKorean() ? "1955 버거™ 세트" : "1955 Burger™<br>Extra Value Meal",
                7500, 877)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201403131156168140.png",
            createMenu(
                LangCheck.isKorean() ? "더블 1955 버거™ 세트" : "Double 1955 Burger™<br>Extra Value Meal",
                8800, 1094)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312021239276890.png",
            createMenu(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트"
                : "Quarter Pounder® with Cheese<br>Extra Value Meal", 7100, 864)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312011049256070.png",
            createMenu(LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈 세트"
                : "Double Quarter Pounder®<br>with CheeseExtra Value Meal", 8300, 1080)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201612221010079000.png",
            createMenu(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal", 6300, 772)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201612221010197520.png",
            createMenu(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal", 7500, 893)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312021239122200.png",
            createMenu(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트"
                : "Bacon Tomato Deluxe™<br>Extra Value Meal", 7400, 887)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312021240387800.png",
            createMenu(LangCheck.isKorean() ? "불고기 버거 세트" : "Bulgogi Burger<br>Extra Value Meal",
                5300, 767)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312021240536440.png",
            createMenu(
                LangCheck.isKorean() ? "더블 불고기 버거 세트" : "Double Bulgogi Burger<br>Extra Value Meal",
                6300, 1014)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201404300804125040.png",
            createMenu(LangCheck.isKorean() ? "맥윙™ 세트" : "McWings™<br>Extra Value Meal", 6000, 841)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/set_menu/prol_201312011051114730.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 세트"
                : "McSpicy™ Chicken Tenders<br>Extra Value Meal", 6400, 728)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "세트메뉴" : "Extra Value Meals";
  }
}
