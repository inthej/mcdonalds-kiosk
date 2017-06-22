package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.page.menu.MenuPage;

/**
 * Class Role : 버거 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon, Kim
 * @since 2017. 06. 15.
 */
public class BurgerTable extends MenuTable {

  public BurgerTable(MenuPage menuPage, final OrderData orderData, final int rows, final int cols) {
    super(menuPage, rows, cols);
    resisterBurger(orderData);
  }

  private void resisterBurger(final OrderData orderData) {
    this.addMenu(
        createMenuButton("image/burger/Golden Egg Cheeseburger.png",
            createMenu(LangCheck.isKorean() ? "골든 에그 치즈버거" : "Golden Egg Cheeseburger", 8000, 636),
            orderData));
    this.addMenu(
        createMenuButton("image/burger/Grilled Mushroom Burger.png",
            createMenu(LangCheck.isKorean() ? "그릴드 머쉬룸 버거" : "Grilled Mushroom Burger", 8000, 679),
            orderData));
    this.addMenu(
        createMenuButton("image/burger/Crispy Oriental Chicken Burger.png",
            createMenu(LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거" : "Crispy Oriental Chicken Burger",
                5700, 620), orderData));
    this.addMenu(
        createMenuButton("image/burger/Big Mac®.png",
            createMenu(LangCheck.isKorean() ? "빅맥®" : "BigMac®", 4900, 512), orderData));
    this.addMenu(
        createMenuButton("image/burger/Mega Mac.png",
            createMenu(LangCheck.isKorean() ? "메가맥" : "Mega Mac", 6000, 694), orderData));
    this.addMenu(
        createMenuButton("image/burger/McSpicy™ Shanghai Burger.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거" : "McSpicy™ Shanghai Burger", 4900,
                463)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/1955 Burger™.png",
            createMenu(LangCheck.isKorean() ? "1955 버거™" : "1955 Burger™", 5900, 509)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Double 1955 Burger™.png",
            createMenu(LangCheck.isKorean() ? "더블 1955 버거™" : "Double 1955 Burger™", 7300, 726)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Quarter Pounder® with Cheese.png",
            createMenu(LangCheck.isKorean() ? "쿼터파운더™ 치즈" : "Quarter Pounder® with Cheese", 5400,
                496)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Double Quarter Pounder® with Cheese.png",
            createMenu(
                LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈" : "Double Quarter Pounder® with Cheese", 6900,
                712)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Supreme Shrimp Burger.png",
            createMenu(LangCheck.isKorean() ? "슈슈버거" : "Supreme Shrimp Burger", 4900, 404)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Shrimp Beef Burger.png",
            createMenu(LangCheck.isKorean() ? "슈비버거" : "Shrimp Beef Burger", 5900, 525)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Bacon Tomato Deluxe™.png",
            createMenu(LangCheck.isKorean() ? "베이컨 토마토 디럭스™" : "Bacon Tomato Deluxe™", 5500, 519)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Tomato Cheeseburger.png",
            createMenu(LangCheck.isKorean() ? "토마토 치즈버거" : "Tomato Cheeseburger", 2500, 335)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Bulgogi Burger.png",
            createMenu(LangCheck.isKorean() ? "불고기 버거" : "Bulgogi Burger", 2500, 398)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Double Bulgogi Burger.png",
            createMenu(LangCheck.isKorean() ? "더블 불고기 버거" : "Double Bulgogi Burger", 4900, 646)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Chicken Burger.png",
            createMenu(LangCheck.isKorean() ? "치킨 버거" : "Chicken Burger", 2500, 324)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Cheeseburger.png",
            createMenu(LangCheck.isKorean() ? "치즈버거" : "Cheeseburger", 3000, 302)
            , orderData));
    this.addMenu(
        createMenuButton("image/burger/Hamburger.png",
            createMenu(LangCheck.isKorean() ? "햄버거" : "Hamburger", 2500, 253)
            , orderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "버거" : "Burgers & Sandwiches";
  }
}
