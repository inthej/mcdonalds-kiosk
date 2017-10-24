package dev.mcdonaldkiosk.page.menu.table;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 맥 카페 메뉴의 버튼 구성을 가진 MenuTable이다.
 *
 * @author Jaehyeon Kim
 */
public class McCafeTable extends MenuTable {

  public McCafeTable(MenuPage menuPage, final KioskOrderData kioskOrderData, final int rows, final int cols) {
    super(menuPage, rows, cols);
    resisterMcCafe(kioskOrderData);
  }

  private void resisterMcCafe(final KioskOrderData kioskOrderData) {
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280310302830.png",
            createMenu(LangCheck.isKorean() ? "프리미엄 로스트™ 원두커피" : "Premium Roast™ Coffee", 1500, 10)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280331001790.png",
            createMenu(LangCheck.isKorean() ? "아이스 커피" : "Iced Coffee", 1500, 10)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280338541970.png",
            createMenu(LangCheck.isKorean() ? "아메리카노" : "Americano", 2000, 13)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280353272690.png",
            createMenu(LangCheck.isKorean() ? "카페라떼" : "Café Latte", 2400, 157)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201510160558512030.png",
            createMenu(LangCheck.isKorean() ? "카라멜 마키아또" : "Caramel Macchiato", 2900, 217)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280345458940.png",
            createMenu(LangCheck.isKorean() ? "카푸치노" : "Cappuccino", 2400, 133)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501290511504900.png",
            createMenu(LangCheck.isKorean() ? "에스프레소" : "Espresso", 1500, 6)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201502020631462070.png",
            createMenu(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano", 2500, 11)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280314115040.png",
            createMenu(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Café Latte", 2900, 103)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201510160619136820.png",
            createMenu(LangCheck.isKorean() ? "아이스 카라멜 마키아또" : "Iced Caramel Macchiato", 2900, 187)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201704210613038480.png",
            createMenu(LangCheck.isKorean() ? "애플 망고 요거트 스무디" : "Apple Mango Yogurt Smoothie", 3800,
                264)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201704210622303450.png",
            createMenu(
                LangCheck.isKorean() ? "딸기 바나나 요거트 스무디" : "Strawberry Banana Yogurt Smoothie", 3800,
                229)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201704210629445890.png", createMenu(
            LangCheck.isKorean() ? "블루베리 석류 요거트 스무디" : "Blueberry Pomegranate Yogurt Smoothie",
            3800, 222)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201704210506373340.png",
            createMenu(LangCheck.isKorean() ? "딸기 레모네이드" : "Strawberry Lemonade", 1500, 197)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201610261154116690.png",
            createMenu(LangCheck.isKorean() ? "모카 프라페" : "Mocha Frappe", 3800, 346)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312090423396200.png",
            createMenu(LangCheck.isKorean() ? "아메리카노" : "Americano", 2400, 5)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100147004590.png",
            createMenu(LangCheck.isKorean() ? "카푸치노" : "Cappuccino", 3300, 110)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100203305430.png",
            createMenu(LangCheck.isKorean() ? "플랫 화이트" : "Flat White", 3300, 142)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170459513500.png",
            createMenu(LangCheck.isKorean() ? "카페 모카" : "Café Mocha", 3300, 146)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312091105256050.png",
            createMenu(LangCheck.isKorean() ? "에스프레소" : "Espresso", 2000, 3)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312091105541820.png",
            createMenu(LangCheck.isKorean() ? "에스프레소 마끼아또" : "Espresso Macchiato", 2300, 6)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170531596900.png",
            createMenu(LangCheck.isKorean() ? "피콜로" : "Piccolo", 2800, 76)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201510160644549250.png",
            createMenu(LangCheck.isKorean() ? "초콜렛 아포가토" : "Chocolate Affogato", 3300, 250)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170559363440.png",
            createMenu(LangCheck.isKorean() ? "아포가토" : "Affogato", 2800, 157)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100227331810.png",
            createMenu(LangCheck.isKorean() ? "카페라떼" : "Café Latte", 3300, 135)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170502066960.png",
            createMenu(LangCheck.isKorean() ? "카라멜 라떼" : "Caramel Latte", 3800, 200)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201510160657022070.png",
            createMenu(LangCheck.isKorean() ? "헤이즐넛 라떼" : "Hazelnut Latte", 3800, 198)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100251215360.png",
            createMenu(LangCheck.isKorean() ? "바닐라 라떼" : "Vanilla Latte", 3800, 203)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100734101020.png",
            createMenu(LangCheck.isKorean() ? "핫초코" : "Hot Chocolate", 3300, 186)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170401131370.png",
            createMenu(LangCheck.isKorean() ? "프리미엄 티" : "Premium Tea", 2500, 0)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312091104271210.png",
            createMenu(LangCheck.isKorean() ? "베이비치노" : "Babycino", 500, 40)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100847100620.png",
            createMenu(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano", 2400, 5)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100851144040.png",
            createMenu(LangCheck.isKorean() ? "아이스 초코" : "Iced Chocolate", 3800, 327)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100856188810.png",
            createMenu(LangCheck.isKorean() ? "아이스 카페모카" : "Iced Cafe Mocha", 3800, 167)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100908407470.png",
            createMenu(LangCheck.isKorean() ? "피치 아이스티" : "Peach Ice Tea", 3900, 155)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100918340880.png",
            createMenu(LangCheck.isKorean() ? "라즈베리 아이스티" : "Raspberry Ice Tea", 3900, 155)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201312100929471100.png",
            createMenu(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Cafe Latte", 3700, 93)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170506071500.png",
            createMenu(LangCheck.isKorean() ? "아이스 카라멜 라떼" : "Iced Caramel Latte", 4200, 158)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170503515230.png",
            createMenu(LangCheck.isKorean() ? "아이스 헤이즐넛 라떼" : "Iced Hazelnut Latte", 4200, 156)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170505356570.png",
            createMenu(LangCheck.isKorean() ? "아이스 바닐라 라떼" : "Iced Vanilla Latte", 4200, 161)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201403170507233320.png",
            createMenu(LangCheck.isKorean() ? "초콜렛 프라페" : "Chocolate Frappe", 4500, 390)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201510280616550500.png",
            createMenu(LangCheck.isKorean() ? "스트로베리 프라페" : "Strawberry Frappe", 4500, 332)
            , kioskOrderData));
    this.addMenu(
        createMenuButton("image/mc_cafe/prol_201501280222157270.png",
            createMenu(LangCheck.isKorean() ? "토마토 주스" : "Tomato Juice", 3500, 96)
            , kioskOrderData));
  }

  @Override
  public String toString() {
    return LangCheck.isKorean() ? "맥카페" : "McCafé®";
  }
}
