package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 스낵 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class SnackTable extends MenuTable {

  public SnackTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows, final int cols) {
    super(menuPage, rows, cols);
    resisterSnack(kioskOrderData);
  }

  private void resisterSnack(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/snack/prol_201312040705101540.png",
            createMenu(LangCheck.isKorean() ? "맥너겟® 4조각" : "McNuggets® 4pc", 2000, 185)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312041109175130.png",
            createMenu(LangCheck.isKorean() ? "맥너겟® 6조각" : "McNuggets® 6pc", 3300, 378)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312041117509620.png",
            createMenu(LangCheck.isKorean() ? "맥너겟® 10조각" : "McNuggets® 10pc", 4700, 463)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312041119014910.png",
            createMenu(LangCheck.isKorean() ? "맥너겟® 20조각" : "McNuggets® 20pc", 7900, 925)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312041112149570.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 2조각" : "McSpicy™ Chicken Tenders 2pc",
                3000, 180)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312041113153590.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 4조각" : "McSpicy™ Chicken Tenders 4pc",
                5200, 359)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312051035534240.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 8조각" : "McSpicy™ Chicken Tenders 8pc",
                9200, 719)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201404300757383040.png",
            createMenu(LangCheck.isKorean() ? "맥윙™ 2조각" : "McWings™ 2pc", 2700, 236)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201404300800189010.png",
            createMenu(LangCheck.isKorean() ? "맥윙™ 4조각" : "McWings™ 4pc", 4700, 472)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201404300802241440.png",
            createMenu(LangCheck.isKorean() ? "맥윙™ 8조각" : "McWings™ 8pc", 8500, 945)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201402220248443700.png",
            createMenu(LangCheck.isKorean() ? "더블 치킨 박스" : "Double Chicken Box", 13700, 1644)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201405120556246810.png",
            createMenu(LangCheck.isKorean() ? "치킨 스낵팩" : "Chicken Snack Pack", 8400, 935)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201704250505221790.png",
            createMenu(LangCheck.isKorean() ? "제주 감귤 샐러드" : "Jeju Tangerine Salad", 3500, 18)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201703240201573360.png",
            createMenu(LangCheck.isKorean() ? "와플 후라이" : "Waffle Fries", 2100, 197)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201504290918266140.png",
            createMenu(LangCheck.isKorean() ? "후렌치 후라이" : "French Fries", 2100, 368)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312111049449760.png",
            createMenu(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
                2500, 296)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201401090204552140.png",
            createMenu(LangCheck.isKorean() ? "스파이시 비프 스낵랩®" : "Spicy Beef Snack Wrap®", 2500, 297)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201312130709085280.png",
            createMenu(LangCheck.isKorean() ? "파인애플 후룻컵" : "Pineapple Fruit Cup", 2100, 0)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/snack/prol_201311280851341080.png",
            createMenu(LangCheck.isKorean() ? "해쉬 브라운" : "Hash Brown", 1500, 156)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "스낵과 사이드" : "Snacks & Sides";
  }
}
