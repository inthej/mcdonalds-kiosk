package dev.empkiosk.page.order;

import dev.empkiosk.page.LangCheck;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Created by kimjaehyeon
 * Class Role : 메뉴탭을 제공한다.
 */
public class MenuTab extends JTabbedPane {

    // 메뉴 탭
    private final JPanel BURGER_TAB = new JPanel();
    private final JPanel SNACK_TAB = new JPanel();
    private final JPanel SET_MENU_TAB = new JPanel();
    private final JPanel MC_CAFE_TAB = new JPanel();
    private final JPanel MC_LUNCH_TAB = new JPanel();
    private final JPanel DRINK_TAB = new JPanel();
    private final JPanel MC_MONING_TAB = new JPanel();
    private final JPanel DESSERT_TAB = new JPanel();

    // 메뉴 테이블
    private MenuTablePanel burgerTable = new MenuTablePanel(0, 4);
    private MenuTablePanel snackTable = new MenuTablePanel(0, 4);
    private MenuTablePanel setMenuTable = new MenuTablePanel(0, 4);
    private MenuTablePanel mcCafeTable = new MenuTablePanel(0, 4);
    private MenuTablePanel mcLunchTable = new MenuTablePanel(0, 4);
    private MenuTablePanel drinkTable = new MenuTablePanel(0, 4);
    private MenuTablePanel mcMoningTable = new MenuTablePanel(0, 4);
    private MenuTablePanel dessertTable = new MenuTablePanel(0, 4);

    public MenuTab() {
        // 컬러
        BURGER_TAB.setBackground(Color.WHITE);
        SNACK_TAB.setBackground(Color.WHITE);
        SET_MENU_TAB.setBackground(Color.WHITE);
        MC_CAFE_TAB.setBackground(Color.WHITE);
        MC_LUNCH_TAB.setBackground(Color.WHITE);
        DRINK_TAB.setBackground(Color.WHITE);
        MC_MONING_TAB.setBackground(Color.WHITE);
        DESSERT_TAB.setBackground(Color.WHITE);

        // 위치
        this.setTabPlacement(JTabbedPane.TOP); // 상단위치

        // 추가
        BURGER_TAB.add(burgerTable);
        SNACK_TAB.add(snackTable);
        SET_MENU_TAB.add(setMenuTable);
        MC_CAFE_TAB.add(mcCafeTable);
        MC_LUNCH_TAB.add(mcLunchTable);
        DRINK_TAB.add(drinkTable);
        MC_MONING_TAB.add(mcMoningTable);
        DESSERT_TAB.add(dessertTable);

        this.add(BURGER_TAB);
        this.add(SNACK_TAB);
        this.add(SET_MENU_TAB);
        this.add(MC_CAFE_TAB);
        this.add(MC_LUNCH_TAB);
        this.add(DRINK_TAB);
        this.add(MC_MONING_TAB);
        this.add(DESSERT_TAB);

        // 탭 이름
        this.setTitleAt(0, LangCheck.isKorean() ? "버거" : "Burgers & Sandwiches");
        this.setTitleAt(1, LangCheck.isKorean() ? "스낵과 사이드" : "Snacks & Sides");
        this.setTitleAt(2, LangCheck.isKorean() ? "세트메뉴" : "Extra Value Meals");
        this.setTitleAt(3, LangCheck.isKorean() ? "맥카페" : "McCafé®");
        this.setTitleAt(4, LangCheck.isKorean() ? "맥런치™" : "McLunch™");
        this.setTitleAt(5, LangCheck.isKorean() ? "음료" : "Beverages");
        this.setTitleAt(6, LangCheck.isKorean() ? "맥모닝" : "McMorning");
        this.setTitleAt(7, LangCheck.isKorean() ? "디저트" : "Desserts");

        // burger
        resisterBurger();
        resisterSnack();
        resisterSetMenu();
        resisterMcCafe();
        resisterMcLunch();
        resisterDrink();
        resisterMcMoning();
        resisterDessert();
    }

    private void resisterBurger() {
        burgerTable.addMenu(new MenuButton("image/burger/Golden Egg Cheeseburger.png",
                new OrderData(LangCheck.isKorean() ? "골든 에그 치즈버거" : "Golden Egg Cheeseburger",
                        8000, 636)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Grilled Mushroom Burger.png",
                new OrderData(LangCheck.isKorean() ? "그릴드 머쉬룸 버거" : "Grilled Mushroom Burger",
                        8000, 679)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Crispy Oriental Chicken Burger.png",
                new OrderData(LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거" : "Crispy Oriental Chicken Burger",
                        5700, 620)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Big Mac®.png",
                new OrderData(LangCheck.isKorean() ? "빅맥®" : "BigMac®",
                        4900, 512)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Mega Mac.png",
                new OrderData(LangCheck.isKorean() ? "메가맥" : "Mega Mac",
                        6000, 694)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/McSpicy™ Shanghai Burger.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거" : "McSpicy™ Shanghai Burger",
                        4900, 463)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/1955 Burger™.png",
                new OrderData(LangCheck.isKorean() ? "1955 버거™" : "1955 Burger™",
                        5900, 509)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Double 1955 Burger™.png",
                new OrderData(LangCheck.isKorean() ? "더블 1955 버거™" : "Double 1955 Burger™",
                        7300, 726)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Quarter Pounder® with Cheese.png",
                new OrderData(LangCheck.isKorean() ? "쿼터파운더™ 치즈" : "Quarter Pounder® with Cheese",
                        5400, 496)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Double Quarter Pounder® with Cheese.png",
                new OrderData(LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈" : "Double Quarter Pounder® with Cheese",
                        6900, 712)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Supreme Shrimp Burger.png",
                new OrderData(LangCheck.isKorean() ? "슈슈버거" : "Supreme Shrimp Burger",
                        4900, 404)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Shrimp Beef Burger.png",
                new OrderData(LangCheck.isKorean() ? "슈비버거" : "Shrimp Beef Burger",
                        5900, 525)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Bacon Tomato Deluxe™.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 토마토 디럭스™" : "Bacon Tomato Deluxe™",
                        5500, 519)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Tomato Cheeseburger.png",
                new OrderData(LangCheck.isKorean() ? "토마토 치즈버거" : "Tomato Cheeseburger",
                        2500, 335)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Bulgogi Burger.png",
                new OrderData(LangCheck.isKorean() ? "불고기 버거" : "Bulgogi Burger",
                        2500, 398)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Double Bulgogi Burger.png",
                new OrderData(LangCheck.isKorean() ? "더블 불고기 버거" : "Double Bulgogi Burger",
                        4900, 646)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Chicken Burger.png",
                new OrderData(LangCheck.isKorean() ? "치킨 버거" : "Chicken Burger",
                        2500, 324)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Cheeseburger.png",
                new OrderData(LangCheck.isKorean() ? "치즈버거" : "Cheeseburger",
                        3000, 302)));
        burgerTable.addMenu(new MenuButton(
                "image/burger/Hamburger.png",
                new OrderData(LangCheck.isKorean() ? "햄버거" : "Hamburger",
                        2500, 253)));
    }

    private void resisterSnack() {
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312040705101540.png",
                new OrderData(LangCheck.isKorean() ? "맥너겟® 4조각" : "McNuggets® 4pc",
                        2000, 185)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312041109175130.png",
                new OrderData(LangCheck.isKorean() ? "맥너겟® 6조각" : "McNuggets® 6pc",
                        3300, 378)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312041117509620.png",
                new OrderData(LangCheck.isKorean() ? "맥너겟® 10조각" : "McNuggets® 10pc",
                        4700, 463)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312041119014910.png",
                new OrderData(LangCheck.isKorean() ? "맥너겟® 20조각" : "McNuggets® 20pc",
                        7900, 925)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312041112149570.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 2조각" : "McSpicy™ Chicken Tenders 2pc",
                        3000, 180)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312041113153590.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 4조각" : "McSpicy™ Chicken Tenders 4pc",
                        5200, 359)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312051035534240.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 8조각" : "McSpicy™ Chicken Tenders 8pc",
                        9200, 719)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201404300757383040.png",
                new OrderData(LangCheck.isKorean() ? "맥윙™ 2조각" : "McWings™ 2pc",
                        2700, 236)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201404300800189010.png",
                new OrderData(LangCheck.isKorean() ? "맥윙™ 4조각" : "McWings™ 4pc",
                        4700, 472)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201404300802241440.png",
                new OrderData(LangCheck.isKorean() ? "맥윙™ 8조각" : "McWings™ 8pc",
                        8500, 945)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201402220248443700.png",
                new OrderData(LangCheck.isKorean() ? "더블 치킨 박스" : "Double Chicken Box",
                        13700, 1644)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201405120556246810.png",
                new OrderData(LangCheck.isKorean() ? "치킨 스낵팩" : "Chicken Snack Pack",
                        8400, 935)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201704250505221790.png",
                new OrderData(LangCheck.isKorean() ? "제주 감귤 샐러드" : "Jeju Tangerine Salad",
                        3500, 18)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201703240201573360.png",
                new OrderData(LangCheck.isKorean() ? "와플 후라이" : "Waffle Fries",
                        2100, 197)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201504290918266140.png",
                new OrderData(LangCheck.isKorean() ? "후렌치 후라이" : "French Fries",
                        2100, 368)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312111049449760.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
                        2500, 296)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201401090204552140.png",
                new OrderData(LangCheck.isKorean() ? "스파이시 비프 스낵랩®" : "Spicy Beef Snack Wrap®",
                        2500, 297)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201312130709085280.png",
                new OrderData(LangCheck.isKorean() ? "파인애플 후룻컵" : "Pineapple Fruit Cup",
                        2100, 0)));
        snackTable.addMenu(new MenuButton(
                "image/snack/prol_201311280851341080.png",
                new OrderData(LangCheck.isKorean() ? "해쉬 브라운" : "Hash Brown",
                        1500, 156)));
    }

    private void resisterSetMenu() {
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201703290425058560.png",
                new OrderData(LangCheck.isKorean() ? "골든 에그 치즈버거 세트" : "Golden Egg Cheeseburger Meal",
                        9700, 1004)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201703290425447840.png",
                new OrderData(LangCheck.isKorean() ? "그릴드 머쉬룸 버거 세트" : "Grilled Mushroom Burger Meal",
                        9700, 1047)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201704280826064130.png",
                new OrderData(
                        LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
                        7100, 988)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201402210535304330.png",
                new OrderData(LangCheck.isKorean() ? "빅맥® 세트"
                        : "Big Mac® Extra<br>Value Meal",
                        6300, 880)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201605160956103670.png",
                new OrderData(LangCheck.isKorean() ? "메가맥 세트" : "Mega Mac Extra Value Meal",
                        7600, 1062)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312021239480850.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트"
                        : "McSpicy™ Shanghai Burger<br>Extra Value Meal",
                        6300, 831)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201508070731369560.png",
                new OrderData(LangCheck.isKorean() ? "1955 버거™ 세트"
                        : "1955 Burger™<br>Extra Value Meal",
                        7500, 877)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201403131156168140.png",
                new OrderData(LangCheck.isKorean() ? "더블 1955 버거™ 세트"
                        : "Double 1955 Burger™<br>Extra Value Meal",
                        8800, 1094)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312021239276890.png",
                new OrderData(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트"
                        : "Quarter Pounder® with Cheese<br>Extra Value Meal",
                        7100, 864)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312011049256070.png",
                new OrderData(LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈 세트"
                        : "Double Quarter Pounder®<br>with CheeseExtra Value Meal",
                        8300, 1080)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201612221010079000.png",
                new OrderData(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal",
                        6300, 772)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201612221010197520.png",
                new OrderData(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal",
                        7500, 893)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312021239122200.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트"
                        : "Bacon Tomato Deluxe™<br>Extra Value Meal",
                        7400, 887)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312021240387800.png",
                new OrderData(LangCheck.isKorean() ? "불고기 버거 세트"
                        : "Bulgogi Burger<br>Extra Value Meal",
                        5300, 767)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312021240536440.png",
                new OrderData(LangCheck.isKorean() ? "더블 불고기 버거 세트"
                        : "Double Bulgogi Burger<br>Extra Value Meal",
                        6300, 1014)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201404300804125040.png", new OrderData(LangCheck.isKorean() ? "맥윙™ 세트"
                : "McWings™<br>Extra Value Meal",
                6000, 841)));
        setMenuTable.addMenu(new MenuButton(
                "image/set_menu/prol_201312011051114730.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 세트"
                        : "McSpicy™ Chicken Tenders<br>Extra Value Meal",
                        6400, 728)));
    }

    private void resisterMcCafe() {
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280310302830.png",
                new OrderData(LangCheck.isKorean() ? "프리미엄 로스트™ 원두커피" : "Premium Roast™ Coffee",
                        1500, 10)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280331001790.png",
                new OrderData(LangCheck.isKorean() ? "아이스 커피" : "Iced Coffee",
                        1500, 10)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280338541970.png",
                new OrderData(LangCheck.isKorean() ? "아메리카노" : "Americano",
                        2000, 13)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280353272690.png",
                new OrderData(LangCheck.isKorean() ? "카페라떼" : "Café Latte",
                        2400, 157)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201510160558512030.png",
                new OrderData(LangCheck.isKorean() ? "카라멜 마키아또" : "Caramel Macchiato",
                        2900, 217)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280345458940.png",
                new OrderData(LangCheck.isKorean() ? "카푸치노" : "Cappuccino",
                        2400, 133)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501290511504900.png",
                new OrderData(LangCheck.isKorean() ? "에스프레소" : "Espresso",
                        1500, 6)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201502020631462070.png",
                new OrderData(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano",
                        2500, 11)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280314115040.png",
                new OrderData(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Café Latte",
                        2900, 103)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201510160619136820.png",
                new OrderData(LangCheck.isKorean() ? "아이스 카라멜 마키아또" : "Iced Caramel Macchiato",
                        2900, 187)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201704210613038480.png",
                new OrderData(LangCheck.isKorean() ? "애플 망고 요거트 스무디" : "Apple Mango Yogurt Smoothie",
                        3800, 264)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201704210622303450.png",
                new OrderData(LangCheck.isKorean() ? "딸기 바나나 요거트 스무디" : "Strawberry Banana Yogurt Smoothie",
                        3800, 229)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201704210629445890.png",
                new OrderData(
                        LangCheck.isKorean() ? "블루베리 석류 요거트 스무디" : "Blueberry Pomegranate Yogurt Smoothie",
                        3800, 222)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201704210506373340.png",
                new OrderData(LangCheck.isKorean() ? "딸기 레모네이드" : "Strawberry Lemonade",
                        1500, 197)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201610261154116690.png",
                new OrderData(LangCheck.isKorean() ? "모카 프라페" : "Mocha Frappe",
                        3800, 346)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312090423396200.png",
                new OrderData(LangCheck.isKorean() ? "아메리카노" : "Americano",
                        2400, 5)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100147004590.png",
                new OrderData(LangCheck.isKorean() ? "카푸치노" : "Cappuccino",
                        3300, 110)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100203305430.png",
                new OrderData(LangCheck.isKorean() ? "플랫 화이트" : "Flat White",
                        3300, 142)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170459513500.png",
                new OrderData(LangCheck.isKorean() ? "카페 모카" : "Café Mocha",
                        3300, 146)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312091105256050.png",
                new OrderData(LangCheck.isKorean() ? "에스프레소" : "Espresso",
                        2000, 3)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312091105541820.png",
                new OrderData(LangCheck.isKorean() ? "에스프레소 마끼아또" : "Espresso Macchiato",
                        2300, 6)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170531596900.png",
                new OrderData(LangCheck.isKorean() ? "피콜로" : "Piccolo", 2800, 76)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201510160644549250.png",
                new OrderData(LangCheck.isKorean() ? "초콜렛 아포가토" : "Chocolate Affogato",
                        3300, 250)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170559363440.png",
                new OrderData(LangCheck.isKorean() ? "아포가토" : "Affogato",
                        2800, 157)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100227331810.png",
                new OrderData(LangCheck.isKorean() ? "카페라떼" : "Café Latte",
                        3300, 135)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170502066960.png",
                new OrderData(LangCheck.isKorean() ? "카라멜 라떼" : "Caramel Latte",
                        3800, 200)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201510160657022070.png",
                new OrderData(LangCheck.isKorean() ? "헤이즐넛 라떼" : "Hazelnut Latte",
                        3800, 198)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100251215360.png",
                new OrderData(LangCheck.isKorean() ? "바닐라 라떼" : "Vanilla Latte",
                        3800, 203)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100734101020.png",
                new OrderData(LangCheck.isKorean() ? "핫초코" : "Hot Chocolate",
                        3300, 186)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170401131370.png",
                new OrderData(LangCheck.isKorean() ? "프리미엄 티" : "Premium Tea",
                        2500, 0)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312091104271210.png",
                new OrderData(LangCheck.isKorean() ? "베이비치노" : "Babycino",
                        500, 40)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100847100620.png",
                new OrderData(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano",
                        2400, 5)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100851144040.png",
                new OrderData(LangCheck.isKorean() ? "아이스 초코" : "Iced Chocolate",
                        3800, 327)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100856188810.png",
                new OrderData(LangCheck.isKorean() ? "아이스 카페모카" : "Iced Cafe Mocha",
                        3800, 167)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100908407470.png",
                new OrderData(LangCheck.isKorean() ? "피치 아이스티" : "Peach Ice Tea",
                        3900, 155)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100918340880.png",
                new OrderData(LangCheck.isKorean() ? "라즈베리 아이스티" : "Raspberry Ice Tea",
                        3900, 155)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201312100929471100.png",
                new OrderData(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Cafe Latte",
                        3700, 93)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170506071500.png",
                new OrderData(LangCheck.isKorean() ? "아이스 카라멜 라떼" : "Iced Caramel Latte",
                        4200, 158)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170503515230.png",
                new OrderData(LangCheck.isKorean() ? "아이스 헤이즐넛 라떼" : "Iced Hazelnut Latte",
                        4200, 156)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170505356570.png",
                new OrderData(LangCheck.isKorean() ? "아이스 바닐라 라떼" : "Iced Vanilla Latte",
                        4200, 161)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201403170507233320.png",
                new OrderData(LangCheck.isKorean() ? "초콜렛 프라페" : "Chocolate Frappe",
                        4500, 390)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201510280616550500.png",
                new OrderData(LangCheck.isKorean() ? "스트로베리 프라페" : "Strawberry Frappe",
                        4500, 332)));
        mcCafeTable.addMenu(new MenuButton(
                "image/mc_cafe/prol_201501280222157270.png",
                new OrderData(LangCheck.isKorean() ? "토마토 주스" : "Tomato Juice",
                        3500, 96)));
    }

    private void resisterMcLunch() {
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201704280826064130.png",
                new OrderData(
                        LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
                        5500, 988)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201402210535304330.png",
                new OrderData(LangCheck.isKorean() ? "빅맥® 세트"
                        : "Big Mac®<br>Extra Value Meal",
                        4900, 880)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201312021239480850.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트"
                        : "McSpicy™ Shanghai Burger<br>Extra Value Meal",
                        4900, 831)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201508070731369560.png",
                new OrderData(LangCheck.isKorean() ? "1955 버거™ 세트"
                        : "1955 Burger™<br>Extra Value Meal",
                        5900, 877)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201312021239276890.png",
                new OrderData(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트"
                        : "Quarter Pounder® with Cheese<br>Extra Value Meal",
                        5400, 864)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201612221010079000.png",
                new OrderData(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal",
                        4900, 772)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201612221010197520.png",
                new OrderData(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal",
                        5900, 893)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201312021239122200.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트"
                        : "Bacon Tomato Deluxe™<br>Extra Value Meal",
                        5500, 887)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201312021240387800.png",
                new OrderData(LangCheck.isKorean() ? "불고기 버거 세트"
                        : "Bulgogi Burger<br>Extra Value Meal",
                        3500, 767)));
        mcLunchTable.addMenu(new MenuButton(
                "image/mc_lunch/prol_201312021240536440.png",
                new OrderData(LangCheck.isKorean() ? "더블 불고기 버거 세트"
                        : "Double Bulgogi Burger<br>Extra Value Meal",
                        4900, 1014)));
    }

    private void resisterDrink() {
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312050151291100.png",
                new OrderData(LangCheck.isKorean() ? "코카-콜라 제로" : "Coca-Cola Zero",
                        1500, 0)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312050152466340.png",
                new OrderData(LangCheck.isKorean() ? "코카-콜라" : "Coca-Cola",
                        1500, 143)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312050152466340.png",
                new OrderData(LangCheck.isKorean() ? "스프라이트" : "Sprite",
                        1500, 149)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312050152466340.png",
                new OrderData(LangCheck.isKorean() ? "환타" : "Fanta",
                        1500, 167)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201402220224483140.png",
                new OrderData(LangCheck.isKorean() ? "바닐라 쉐이크" : "Vanilla Shake",
                        2700, 339)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201402220229522730.png",
                new OrderData(LangCheck.isKorean() ? "딸기 쉐이크" : "Strawberry Shake",
                        3700, 345)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201402220234029140.png",
                new OrderData(LangCheck.isKorean() ? "초코 쉐이크" : "Chocolate Shake",
                        2700, 339)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312090535528510.png",
                new OrderData(LangCheck.isKorean() ? "오렌지 주스" : "Orange Juice",
                        2300, 0)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201312011125364160.png",
                new OrderData(LangCheck.isKorean() ? "우유" : "Milk",
                        2000, 0)));
        drinkTable.addMenu(new MenuButton(
                "image/drink/prol_201404220647354250.png",
                new OrderData(LangCheck.isKorean() ? "생수" : "Mineral Water",
                        1500, 0)));
    }

    private void resisterMcMoning() {
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201703160247462420.png",
                new OrderData(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™" : "Tomato Bacon Egg McMuffin™",
                        4800, 448)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201311280852253010.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 토마토 머핀" : "BLT Muffin",
                        4600, 385)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201703160249302220.png",
                new OrderData(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀" : "Tomato Chicken 'n Cheese Muffin",
                        5100, 510)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402210536286650.png",
                new OrderData(LangCheck.isKorean() ? "에그 맥머핀™" : "Egg McMuffin™",
                        3000, 286)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201311280852044240.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 에그 맥머핀™" : "Bacon Egg McMuffin™",
                        3200, 289)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201603170147008720.png",
                new OrderData(LangCheck.isKorean() ? "소시지 맥머핀™" : "Sausage McMuffin™",
                        2500, 338)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402210548008880.png",
                new OrderData(LangCheck.isKorean() ? "소시지 에그 맥머핀™" : "Sausage Egg McMuffin™",
                        3200, 414)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402210551034670.png",
                new OrderData(LangCheck.isKorean() ? "치킨 치즈 머핀" : "Chicken 'n Cheese Muffin",
                        3400, 338)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201312111049449760.png",
                new OrderData(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
                        2500, 296)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402240350481910.png",
                new OrderData(LangCheck.isKorean() ? "디럭스 브렉퍼스트™" : "Deluxe Breakfast™",
                        5100, 816)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402240351164550.png",
                new OrderData(LangCheck.isKorean() ? "빅 브렉퍼스트™" : "Big Breakfast™",
                        4400, 596)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201402210552030320.png",
                new OrderData(LangCheck.isKorean() ? "핫케익 3조각" : "Hotcakes 3pc",
                        3200, 331)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201703160231285820.png",
                new OrderData(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™ 세트"
                        : "Tomato Bacon Egg McMuffin™<br>Extra Value Breakfast",
                        4800, 448)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280449072030.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 토마토 머핀 세트"
                        : "BLT Muffin<br>Extra Value Breakfast",
                        4600, 385)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201703160238588990.png",
                new OrderData(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀 세트"
                        : "Tomato Chicken 'n Cheese Muffin<br>Extra Value Breakfast",
                        5100, 510)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280441107300.png",
                new OrderData(LangCheck.isKorean() ? "에그 맥머핀™ 세트"
                        : "Egg McMuffin™<br>Extra Value Breakfast",
                        4300, 452)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280442076260.png",
                new OrderData(LangCheck.isKorean() ? "베이컨 에그 맥머핀™ 세트"
                        : "Bacon Egg McMuffin™<br>Extra Value Breakfast",
                        4300, 454)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280444463940.png",
                new OrderData(LangCheck.isKorean() ? "소시지 맥머핀™ 세트"
                        : "Sausage McMuffin™<br>Extra Value Breakfast",
                        4200, 504)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280443577710.png",
                new OrderData(LangCheck.isKorean() ? "소시지 에그 맥머핀™ 세트"
                        : "Sausage Egg McMuffin™<br>Extra Value Breakfast",
                        4300, 579)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280445552890.png",
                new OrderData(LangCheck.isKorean() ? "치킨 치즈 머핀 세트"
                        : "Chicken 'n Cheese Muffin<br>Extra Value Breakfast",
                        4600, 503)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280446555460.png",
                new OrderData(LangCheck.isKorean() ? "디럭스 브렉퍼스트™ 세트"
                        : "Deluxe Breakfast™<br>Extra Value Breakfast",
                        6300, 826)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280447308350.png",
                new OrderData(LangCheck.isKorean() ? "빅 브렉퍼스트™ 세트"
                        : "Big Breakfast™<br>Extra Value Breakfast",
                        5500, 605)));
        mcMoningTable.addMenu(new MenuButton(
                "image/mc_moning/prol_201501280448120810.png",
                new OrderData(LangCheck.isKorean() ? "핫케익 3조각 세트"
                        : "Hotcakes 3pc<br>Extra Value Breakfast",
                        4400, 340)));
    }

    private void resisterDessert() {
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201703290608504310.png",
                new OrderData(LangCheck.isKorean() ? "리세스 맥플러리®" : "Reese’s McFlurry®",
                        2800, 300)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201601311029185960.png",
                new OrderData(LangCheck.isKorean() ? "츄러스" : "Churros",
                        2000, 181)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201312050311223540.png",
                new OrderData(LangCheck.isKorean() ? "오레오 맥플러리®" : "Oreo McFlurry®",
                        3000, 322)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201312041015558530.png",
                new OrderData(LangCheck.isKorean() ? "딸기 오레오 맥플러리®" : "Strawberry Oreo McFlurry®",
                        3000, 291)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201312050311494320.png",
                new OrderData(LangCheck.isKorean() ? "초코 오레오 맥플러리®" : "Choco Oreo McFlurry®",
                        3000, 375)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201311280226114370.png",
                new OrderData(LangCheck.isKorean() ? "초코 선데이 아이스크림" : "Chocolate Sundae",
                        2000, 307)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201509091159582930.png",
                new OrderData(LangCheck.isKorean() ? "카라멜 선데이 아이스크림" : "Caramel Sundae",
                        2000, 306)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201311280223173290.png",
                new OrderData(LangCheck.isKorean() ? "딸기 선데이 아이스크림" : "Strawberry Sundae",
                        2000, 261)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201311280221377300.png",
                new OrderData(LangCheck.isKorean() ? "오레오 아포가토" : "Oreo Affogato",
                        2800, 248)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201311280227345110.png",
                new OrderData(LangCheck.isKorean() ? "초코콘" : "Chocolate Cone",
                        800, 229)));
        dessertTable.addMenu(new MenuButton(
                "image/dessert/prol_201311280228539530.png",
                new OrderData(LangCheck.isKorean() ? "아이스크림콘" : "Ice Cream Cone",
                        600, 153)));
    }

    private static final long serialVersionUID = -3009884571057632259L;
}
