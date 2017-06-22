package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.page.menu.MenuPage;

/**
 * Class Role : 맥 모닝 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon, Kim
 * @since 2017. 06. 15.
 */
public class McMoningTable extends MenuTable {

  public McMoningTable(MenuPage menuPage, final OrderData orderData, final int rows, final int cols) {
    super(rows, cols);
    resisterMcMoning(menuPage, orderData);
  }

  private void resisterMcMoning(MenuPage menuPage, final OrderData orderData) {
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160247462420.png",
            createMenu(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™" : "Tomato Bacon Egg McMuffin™",
                4800, 448),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201311280852253010.png",
            createMenu(LangCheck.isKorean() ? "베이컨 토마토 머핀" : "BLT Muffin", 4600, 385),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160249302220.png",
            createMenu(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀" : "Tomato Chicken 'n Cheese Muffin",
                5100, 510),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210536286650.png",
            createMenu(LangCheck.isKorean() ? "에그 맥머핀™" : "Egg McMuffin™", 3000, 286),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201311280852044240.png",
            createMenu(LangCheck.isKorean() ? "베이컨 에그 맥머핀™" : "Bacon Egg McMuffin™", 3200, 289),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201603170147008720.png",
            createMenu(LangCheck.isKorean() ? "소시지 맥머핀™" : "Sausage McMuffin™", 2500, 338),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210548008880.png",
            createMenu(LangCheck.isKorean() ? "소시지 에그 맥머핀™" : "Sausage Egg McMuffin™", 3200, 414),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210551034670.png",
            createMenu(LangCheck.isKorean() ? "치킨 치즈 머핀" : "Chicken 'n Cheese Muffin", 3400, 338),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201312111049449760.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
                2500, 296),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402240350481910.png",
            createMenu(LangCheck.isKorean() ? "디럭스 브렉퍼스트™" : "Deluxe Breakfast™", 5100, 816),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402240351164550.png",
            createMenu(LangCheck.isKorean() ? "빅 브렉퍼스트™" : "Big Breakfast™", 4400, 596),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210552030320.png",
            createMenu(LangCheck.isKorean() ? "핫케익 3조각" : "Hotcakes 3pc", 3200, 331),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160231285820.png",
            createMenu(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™ 세트"
                : "Tomato Bacon Egg McMuffin™<br>Extra Value Breakfast", 4800, 448),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280449072030.png",
            createMenu(
                LangCheck.isKorean() ? "베이컨 토마토 머핀 세트" : "BLT Muffin<br>Extra Value Breakfast",
                4600, 385),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160238588990.png",
            createMenu(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀 세트"
                : "Tomato Chicken 'n Cheese Muffin<br>Extra Value Breakfast", 5100, 510),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280441107300.png",
            createMenu(
                LangCheck.isKorean() ? "에그 맥머핀™ 세트" : "Egg McMuffin™<br>Extra Value Breakfast",
                4300, 452),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280442076260.png",
            createMenu(LangCheck.isKorean() ? "베이컨 에그 맥머핀™ 세트"
                : "Bacon Egg McMuffin™<br>Extra Value Breakfast", 4300, 454),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280444463940.png",
            createMenu(
                LangCheck.isKorean() ? "소시지 맥머핀™ 세트" : "Sausage McMuffin™<br>Extra Value Breakfast",
                4200, 504),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280443577710.png",
            createMenu(LangCheck.isKorean() ? "소시지 에그 맥머핀™ 세트"
                : "Sausage Egg McMuffin™<br>Extra Value Breakfast", 4300, 579),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280445552890.png",
            createMenu(LangCheck.isKorean() ? "치킨 치즈 머핀 세트"
                : "Chicken 'n Cheese Muffin<br>Extra Value Breakfast", 4600, 503),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280446555460.png",
            createMenu(LangCheck.isKorean() ? "디럭스 브렉퍼스트™ 세트"
                : "Deluxe Breakfast™<br>Extra Value Breakfast", 6300, 826),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280447308350.png",
            createMenu(
                LangCheck.isKorean() ? "빅 브렉퍼스트™ 세트" : "Big Breakfast™<br>Extra Value Breakfast",
                5500, 605),
            menuPage, orderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280448120810.png",
            createMenu(
                LangCheck.isKorean() ? "핫케익 3조각 세트" : "Hotcakes 3pc<br>Extra Value Breakfast", 4400,
                340),
            menuPage, orderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "맥모닝" : "McMorning";
  }
}
