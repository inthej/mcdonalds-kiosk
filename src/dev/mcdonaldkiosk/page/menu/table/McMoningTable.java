package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 맥 모닝 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class McMoningTable extends MenuTable {

  public McMoningTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows,
      final int cols) {
    super(menuPage, rows, cols);
    resisterMcMoning(kioskOrderData);
  }

  private void resisterMcMoning(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160247462420.png",
            createMenu(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™" : "Tomato Bacon Egg McMuffin™",
                4800, 448)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201311280852253010.png",
            createMenu(LangCheck.isKorean() ? "베이컨 토마토 머핀" : "BLT Muffin", 4600, 385)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160249302220.png",
            createMenu(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀" : "Tomato Chicken 'n Cheese Muffin",
                5100, 510)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210536286650.png",
            createMenu(LangCheck.isKorean() ? "에그 맥머핀™" : "Egg McMuffin™", 3000, 286)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201311280852044240.png",
            createMenu(LangCheck.isKorean() ? "베이컨 에그 맥머핀™" : "Bacon Egg McMuffin™", 3200, 289)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201603170147008720.png",
            createMenu(LangCheck.isKorean() ? "소시지 맥머핀™" : "Sausage McMuffin™", 2500, 338)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210548008880.png",
            createMenu(LangCheck.isKorean() ? "소시지 에그 맥머핀™" : "Sausage Egg McMuffin™", 3200, 414)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210551034670.png",
            createMenu(LangCheck.isKorean() ? "치킨 치즈 머핀" : "Chicken 'n Cheese Muffin", 3400, 338)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201312111049449760.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
                2500, 296)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402240350481910.png",
            createMenu(LangCheck.isKorean() ? "디럭스 브렉퍼스트™" : "Deluxe Breakfast™", 5100, 816)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402240351164550.png",
            createMenu(LangCheck.isKorean() ? "빅 브렉퍼스트™" : "Big Breakfast™", 4400, 596)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201402210552030320.png",
            createMenu(LangCheck.isKorean() ? "핫케익 3조각" : "Hotcakes 3pc", 3200, 331)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160231285820.png",
            createMenu(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™ 세트"
                : "Tomato Bacon Egg McMuffin™<br>Extra Value Breakfast", 4800, 448)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280449072030.png",
            createMenu(
                LangCheck.isKorean() ? "베이컨 토마토 머핀 세트" : "BLT Muffin<br>Extra Value Breakfast",
                4600, 385)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201703160238588990.png",
            createMenu(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀 세트"
                : "Tomato Chicken 'n Cheese Muffin<br>Extra Value Breakfast", 5100, 510)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280441107300.png",
            createMenu(
                LangCheck.isKorean() ? "에그 맥머핀™ 세트" : "Egg McMuffin™<br>Extra Value Breakfast",
                4300, 452)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280442076260.png",
            createMenu(LangCheck.isKorean() ? "베이컨 에그 맥머핀™ 세트"
                : "Bacon Egg McMuffin™<br>Extra Value Breakfast", 4300, 454)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280444463940.png",
            createMenu(
                LangCheck.isKorean() ? "소시지 맥머핀™ 세트" : "Sausage McMuffin™<br>Extra Value Breakfast",
                4200, 504)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280443577710.png",
            createMenu(LangCheck.isKorean() ? "소시지 에그 맥머핀™ 세트"
                : "Sausage Egg McMuffin™<br>Extra Value Breakfast", 4300, 579)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280445552890.png",
            createMenu(LangCheck.isKorean() ? "치킨 치즈 머핀 세트"
                : "Chicken 'n Cheese Muffin<br>Extra Value Breakfast", 4600, 503)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280446555460.png",
            createMenu(LangCheck.isKorean() ? "디럭스 브렉퍼스트™ 세트"
                : "Deluxe Breakfast™<br>Extra Value Breakfast", 6300, 826)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280447308350.png",
            createMenu(
                LangCheck.isKorean() ? "빅 브렉퍼스트™ 세트" : "Big Breakfast™<br>Extra Value Breakfast",
                5500, 605)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_moning/prol_201501280448120810.png",
            createMenu(
                LangCheck.isKorean() ? "핫케익 3조각 세트" : "Hotcakes 3pc<br>Extra Value Breakfast", 4400,
                340)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "맥모닝" : "McMorning";
  }
}
