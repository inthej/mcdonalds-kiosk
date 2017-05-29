package dev.empkiosk.page.order;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dev.empkiosk.page.LangCheck;

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
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "골든 에그 치즈버거" : "Golden Egg Cheeseburger",
				"image/burger/Golden Egg Cheeseburger.png", 8000, 636));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "그릴드 머쉬룸 버거" : "Grilled Mushroom Burger",
				"image/burger/Grilled Mushroom Burger.png", 8000, 679));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거" : "Crispy Oriental Chicken Burger",
				"image/burger/Crispy Oriental Chicken Burger.png", 5700, 620));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "빅맥®" : "BigMac®", 
				"image/burger/Big Mac®.png", 4900, 512));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "메가맥" : "Mega Mac", 
				"image/burger/Mega Mac.png", 6000, 694));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거" : "McSpicy™ Shanghai Burger",
				"image/burger/McSpicy™ Shanghai Burger.png", 4900, 463));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "1955 버거™" : "1955 Burger™", 
				"image/burger/1955 Burger™.png", 5900, 509));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 1955 버거™" : "Double 1955 Burger™",
				"image/burger/Double 1955 Burger™.png", 7300, 726));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "쿼터파운더™ 치즈" : "Quarter Pounder® with Cheese",
				"image/burger/Quarter Pounder® with Cheese.png", 5400, 496));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈" : "Double Quarter Pounder® with Cheese",
				"image/burger/Double Quarter Pounder® with Cheese.png", 6900, 712));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈슈버거" : "Supreme Shrimp Burger",
				"image/burger/Supreme Shrimp Burger.png", 4900, 404));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈비버거" : "Shrimp Beef Burger",
				"image/burger/Shrimp Beef Burger.png", 5900, 525));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 토마토 디럭스™" : "Bacon Tomato Deluxe™",
				"image/burger/Bacon Tomato Deluxe™.png",5500, 519));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 치즈버거" : "Tomato Cheeseburger",
				"image/burger/Tomato Cheeseburger.png", 2500, 335));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "불고기 버거" : "Bulgogi Burger", 
				"image/burger/Bulgogi Burger.png", 2500, 398));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 불고기 버거" : "Double Bulgogi Burger",
				"image/burger/Double Bulgogi Burger.png", 4900, 646));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "치킨 버거" : "Chicken Burger", 
				"image/burger/Chicken Burger.png", 2500, 324));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "치즈버거" : "Cheeseburger", 
				"image/burger/Cheeseburger.png", 3000, 302));
		burgerTable.addMenu(new MenuButton(LangCheck.isKorean() ? "햄버거" : "Hamburger", 
				"image/burger/Hamburger.png", 2500, 253));
	}

	private void resisterSnack() {
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥너겟® 4조각" : "McNuggets® 4pc",
				"image/snack/prol_201312040705101540.png", 2000, 185));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥너겟® 6조각" : "McNuggets® 6pc",
				"image/snack/prol_201312041109175130.png", 3300, 378));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥너겟® 10조각" : "McNuggets® 10pc",
				"image/snack/prol_201312041117509620.png", 4700, 463));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥너겟® 20조각" : "McNuggets® 20pc",
				"image/snack/prol_201312041119014910.png", 7900, 925));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 2조각" : "McSpicy™ Chicken Tenders 2pc",
				"image/snack/prol_201312041112149570.png", 3000, 180));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 4조각" : "McSpicy™ Chicken Tenders 4pc",
				"image/snack/prol_201312041113153590.png", 5200, 359));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 8조각" : "McSpicy™ Chicken Tenders 8pc",
				"image/snack/prol_201312051035534240.png", 9200, 719));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥윙™ 2조각" : "McWings™ 2pc",
				"image/snack/prol_201404300757383040.png", 2700, 236));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥윙™ 4조각" : "McWings™ 4pc",
				"image/snack/prol_201404300800189010.png", 4700, 472));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥윙™ 8조각" : "McWings™ 8pc",
				"image/snack/prol_201404300802241440.png", 8500, 945));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 치킨 박스" : "Double Chicken Box",
				"image/snack/prol_201402220248443700.png", 13700, 1644));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "치킨 스낵팩" : "Chicken Snack Pack",
				"image/snack/prol_201405120556246810.png", 8400, 935));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "제주 감귤 샐러드" : "Jeju Tangerine Salad",
				"image/snack/prol_201704250505221790.png", 3500, 18));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "와플 후라이" : "Waffle Fries",
				"image/snack/prol_201703240201573360.png", 2100, 197));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "후렌치 후라이" : "French Fries",
				"image/snack/prol_201504290918266140.png", 2100, 368));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
				"image/snack/prol_201312111049449760.png", 2500, 296));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "스파이시 비프 스낵랩®" : "Spicy Beef Snack Wrap®",
				"image/snack/prol_201401090204552140.png", 2500, 297));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "파인애플 후룻컵" : "Pineapple Fruit Cup",
				"image/snack/prol_201312130709085280.png", 2100, 0));
		snackTable.addMenu(new MenuButton(LangCheck.isKorean() ? "해쉬 브라운" : "Hash Brown",
				"image/snack/prol_201311280851341080.png", 1500, 156));
	}

	private void resisterSetMenu() {
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "골든 에그 치즈버거 세트" : "Golden Egg Cheeseburger Meal",
				"image/set_menu/prol_201703290425058560.png", 9700, 1004));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "그릴드 머쉬룸 버거 세트" : "Grilled Mushroom Burger Meal",
				"image/set_menu/prol_201703290425447840.png", 9700, 1047));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
				"image/set_menu/prol_201704280826064130.png", 7100, 988));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "빅맥® 세트" : "<html><center>Big Mac® Extra<br>Value Meal</center></html>",
				"image/set_menu/prol_201402210535304330.png", 6300, 880));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "메가맥 세트" : "Mega Mac Extra Value Meal",
				"image/set_menu/prol_201605160956103670.png", 7600, 1062));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트" : "<html><center>McSpicy™ Shanghai Burger<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312021239480850.png", 6300, 831));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "1955 버거™ 세트" : "<html><center>1955 Burger™<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201508070731369560.png", 7500, 877));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 1955 버거™ 세트" : "<html><center>Double 1955 Burger™<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201403131156168140.png", 8800, 1094));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트" : "<html><center>Quarter Pounder® with Cheese<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312021239276890.png", 7100, 864));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 쿼터파운더™ 치즈 세트" : "<html><center>Double Quarter Pounder®<br>with CheeseExtra Value Meal</center></html>",
				"image/set_menu/prol_201312011049256070.png", 8300, 1080));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal",
				"image/set_menu/prol_201612221010079000.png", 6300, 772));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal",
				"image/set_menu/prol_201612221010197520.png", 7500, 893));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트" : "<html><center>Bacon Tomato Deluxe™<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312021239122200.png", 7400, 887));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "불고기 버거 세트" : "<html><center>Bulgogi Burger<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312021240387800.png", 5300, 767));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 불고기 버거 세트" : "<html><center>Double Bulgogi Burger<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312021240536440.png", 6300, 1014));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥윙™ 세트" : "<html><center>McWings™<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201404300804125040.png", 6000, 841));
		setMenuTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 텐더 세트" : "<html><center>McSpicy™ Chicken Tenders<br>Extra Value Meal</center></html>",
				"image/set_menu/prol_201312011051114730.png", 6400, 728));
	}

	private void resisterMcCafe() {
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "프리미엄 로스트™ 원두커피" : "Premium Roast™ Coffee",
				"image/mc_cafe/prol_201501280310302830.png", 1500, 10));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 커피" : "Iced Coffee",
				"image/mc_cafe/prol_201501280331001790.png", 1500, 10));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아메리카노" : "Americano",
				"image/mc_cafe/prol_201501280338541970.png", 2000, 13));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카페라떼" : "Café Latte",
				"image/mc_cafe/prol_201501280353272690.png", 2400, 157));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카라멜 마키아또" : "Caramel Macchiato",
				"image/mc_cafe/prol_201510160558512030.png", 2900, 217));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카푸치노" : "Cappuccino",
				"image/mc_cafe/prol_201501280345458940.png", 2400, 133));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "에스프레소" : "Espresso",
				"image/mc_cafe/prol_201501290511504900.png", 1500, 6));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano",
				"image/mc_cafe/prol_201502020631462070.png", 2500, 11));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Café Latte",
				"image/mc_cafe/prol_201501280314115040.png", 2900, 103));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 카라멜 마키아또" : "Iced Caramel Macchiato",
				"image/mc_cafe/prol_201510160619136820.png", 2900, 187));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "애플 망고 요거트 스무디" : "Apple Mango Yogurt Smoothie",
				"image/mc_cafe/prol_201704210613038480.png", 3800, 264));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "딸기 바나나 요거트 스무디" : "Strawberry Banana Yogurt Smoothie",
				"image/mc_cafe/prol_201704210622303450.png", 3800, 229));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "블루베리 석류 요거트 스무디" : "Blueberry Pomegranate Yogurt Smoothie",
				"image/mc_cafe/prol_201704210629445890.png", 3800, 222));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "딸기 레모네이드" : "Strawberry Lemonade",
				"image/mc_cafe/prol_201704210506373340.png", 1500, 197));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "모카 프라페" : "Mocha Frappe",
				"image/mc_cafe/prol_201610261154116690.png", 3800, 346));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아메리카노" : "Americano",
				"image/mc_cafe/prol_201312090423396200.png", 2400, 5));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카푸치노" : "Cappuccino",
				"image/mc_cafe/prol_201312100147004590.png", 3300, 110));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "플랫 화이트" : "Flat White",
				"image/mc_cafe/prol_201312100203305430.png", 3300, 142));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카페 모카" : "Café Mocha",
				"image/mc_cafe/prol_201403170459513500.png", 3300, 146));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "에스프레소" : "Espresso",
				"image/mc_cafe/prol_201312091105256050.png", 2000, 3));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "에스프레소 마끼아또" : "Espresso Macchiato",
				"image/mc_cafe/prol_201312091105541820.png", 2300, 6));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "피콜로" : "Piccolo", 
				"image/mc_cafe/prol_201403170531596900.png", 2800, 76));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초콜렛 아포가토" : "Chocolate Affogato",
				"image/mc_cafe/prol_201510160644549250.png", 3300, 250));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아포가토" : "Affogato", 
				"image/mc_cafe/prol_201403170559363440.png", 2800, 157));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카페라떼" : "Café Latte",
				"image/mc_cafe/prol_201312100227331810.png", 3300, 135));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카라멜 라떼" : "Caramel Latte",
				"image/mc_cafe/prol_201403170502066960.png", 3800, 200));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "헤이즐넛 라떼" : "Hazelnut Latte",
				"image/mc_cafe/prol_201510160657022070.png", 3800, 198));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "바닐라 라떼" : "Vanilla Latte",
				"image/mc_cafe/prol_201312100251215360.png", 3800, 203));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "핫초코" : "Hot Chocolate",
				"image/mc_cafe/prol_201312100734101020.png", 3300, 186));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "프리미엄 티" : "Premium Tea",
				"image/mc_cafe/prol_201403170401131370.png", 2500, 0));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이비치노" : "Babycino",
				"image/mc_cafe/prol_201312091104271210.png", 500, 40));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 아메리카노" : "Iced Americano",
				"image/mc_cafe/prol_201312100847100620.png", 2400, 5));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 초코" : "Iced Chocolate",
				"image/mc_cafe/prol_201312100851144040.png", 3800, 327));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 카페모카" : "Iced Cafe Mocha",
				"image/mc_cafe/prol_201312100856188810.png", 3800, 167));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "피치 아이스티" : "Peach Ice Tea",
				"image/mc_cafe/prol_201312100908407470.png", 3900, 155));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "라즈베리 아이스티" : "Raspberry Ice Tea",
				"image/mc_cafe/prol_201312100918340880.png", 3900, 155));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 카페라떼" : "Iced Cafe Latte",
				"image/mc_cafe/prol_201312100929471100.png", 3700, 93));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 카라멜 라떼" : "Iced Caramel Latte",
				"image/mc_cafe/prol_201403170506071500.png", 4200, 158));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 헤이즐넛 라떼" : "Iced Hazelnut Latte",
				"image/mc_cafe/prol_201403170503515230.png", 4200, 156));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스 바닐라 라떼" : "Iced Vanilla Latte",
				"image/mc_cafe/prol_201403170505356570.png", 4200, 161));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초콜렛 프라페" : "Chocolate Frappe",
				"image/mc_cafe/prol_201403170507233320.png", 4500, 390));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "스트로베리 프라페" : "Strawberry Frappe",
				"image/mc_cafe/prol_201510280616550500.png", 4500, 332));
		mcCafeTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 주스" : "Tomato Juice",
				"image/mc_cafe/prol_201501280222157270.png", 3500, 96));
	}

	private void resisterMcLunch() {
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "크리스피 오리엔탈 치킨버거 세트" : "Crispy Oriental Chicken Burger Meal",
				"image/mc_lunch/prol_201704280826064130.png", 5500, 988));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "빅맥® 세트" : "<html><center>Big Mac®<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201402210535304330.png", 4900, 880));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 상하이 버거 세트" : "<html><center>McSpicy™ Shanghai Burger<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201312021239480850.png", 4900, 831));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "1955 버거™ 세트" : "<html><center>1955 Burger™<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201508070731369560.png", 5900, 877));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "쿼터파운더™ 치즈 세트" : "<html><center>Quarter Pounder® with Cheese<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201312021239276890.png", 5400, 864));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈슈버거 세트" : "Supreme Shrimp Burger Meal",
				"image/mc_lunch/prol_201612221010079000.png", 4900, 772));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "슈비버거 세트" : "Shrimp Beef Burger Meal",
				"image/mc_lunch/prol_201612221010197520.png", 5900, 893));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 토마토 디럭스™ 세트" : "<html><center>Bacon Tomato Deluxe™<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201312021239122200.png", 5500, 887));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "불고기 버거 세트" : "<html><center>Bulgogi Burger<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201312021240387800.png", 3500, 767));
		mcLunchTable.addMenu(new MenuButton(LangCheck.isKorean() ? "더블 불고기 버거 세트" : "<html><center>Double Bulgogi Burger<br>Extra Value Meal</center></html>",
				"image/mc_lunch/prol_201312021240536440.png", 4900, 1014));
	}

	private void resisterDrink() {
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "코카-콜라 제로" : "Coca-Cola Zero",
				"image/drink/prol_201312050151291100.png", 1500, 0));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "코카-콜라" : "Coca-Cola", 
				"image/drink/prol_201312050152466340.png", 1500, 143));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "스프라이트" : "Sprite", 
				"image/drink/prol_201312050152466340.png", 1500, 149));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "환타" : "Fanta", 
				"image/drink/prol_201312050152466340.png", 1500, 167));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "바닐라 쉐이크" : "Vanilla Shake",
				"image/drink/prol_201402220224483140.png", 2700, 339));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "딸기 쉐이크" : "Strawberry Shake",
				"image/drink/prol_201402220229522730.png", 3700, 345));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초코 쉐이크" : "Chocolate Shake",
				"image/drink/prol_201402220234029140.png", 2700, 339));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "오렌지 주스" : "Orange Juice",
				"image/drink/prol_201312090535528510.png", 2300, 0));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "우유" : "Milk", 
				"image/drink/prol_201312011125364160.png", 2000, 0));
		drinkTable.addMenu(new MenuButton(LangCheck.isKorean() ? "생수" : "Mineral Water",
				"image/drink/prol_201404220647354250.png", 1500, 0));
	}

	private void resisterMcMoning() {
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™" : "Tomato Bacon Egg McMuffin™",
				"image/mc_moning/prol_201703160247462420.png", 4800, 448));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 토마토 머핀" : "BLT Muffin",
				"image/mc_moning/prol_201311280852253010.png", 4600, 385));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀" : "Tomato Chicken 'n Cheese Muffin",
				"image/mc_moning/prol_201703160249302220.png", 5100, 510));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "에그 맥머핀™" : "Egg McMuffin™",
				"image/mc_moning/prol_201402210536286650.png", 3000, 286));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 에그 맥머핀™" : "Bacon Egg McMuffin™",
				"image/mc_moning/prol_201311280852044240.png", 3200, 289));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "소시지 맥머핀™" : "Sausage McMuffin™",
				"image/mc_moning/prol_201603170147008720.png", 2500, 338));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "소시지 에그 맥머핀™" : "Sausage Egg McMuffin™",
				"image/mc_moning/prol_201402210548008880.png", 3200, 414));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "치킨 치즈 머핀" : "Chicken 'n Cheese Muffin",
				"image/mc_moning/prol_201402210551034670.png", 3400, 338));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "맥스파이시™ 치킨 스낵랩®" : "McSpicy™ Chicken Snack Wrap®",
				"image/mc_moning/prol_201312111049449760.png", 2500, 296));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "디럭스 브렉퍼스트™" : "Deluxe Breakfast™",
				"image/mc_moning/prol_201402240350481910.png", 5100, 816));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "빅 브렉퍼스트™" : "Big Breakfast™",
				"image/mc_moning/prol_201402240351164550.png", 4400, 596));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "핫케익 3조각" : "Hotcakes 3pc",
				"image/mc_moning/prol_201402210552030320.png", 3200, 331));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 베이컨 에그 맥머핀™ 세트" : "<html><center>Tomato Bacon Egg McMuffin™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201703160231285820.png", 4800, 448));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 토마토 머핀 세트" : "<html><center>BLT Muffin<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280449072030.png", 4600, 385));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "토마토 치킨 치즈 머핀 세트" : "<html><center>Tomato Chicken 'n Cheese Muffin<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201703160238588990.png", 5100, 510));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "에그 맥머핀™ 세트" : "<html><center>Egg McMuffin™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280441107300.png", 4300, 452));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "베이컨 에그 맥머핀™ 세트" : "<html><center>Bacon Egg McMuffin™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280442076260.png", 4300, 454));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "소시지 맥머핀™ 세트" : "<html><center>Sausage McMuffin™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280444463940.png", 4200, 504));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "소시지 에그 맥머핀™ 세트" : "<html><center>Sausage Egg McMuffin™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280443577710.png", 4300, 579));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "치킨 치즈 머핀 세트" : "<html><center>Chicken 'n Cheese Muffin<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280445552890.png", 4600, 503));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "디럭스 브렉퍼스트™ 세트" : "<html><center>Deluxe Breakfast™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280446555460.png", 6300, 826));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "빅 브렉퍼스트™ 세트" : "<html><center>Big Breakfast™<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280447308350.png", 5500, 605));
		mcMoningTable.addMenu(new MenuButton(LangCheck.isKorean() ? "핫케익 3조각 세트" : "<html><center>Hotcakes 3pc<br>Extra Value Breakfast</center></html>",
				"image/mc_moning/prol_201501280448120810.png", 4400, 340));
	}

	private void resisterDessert() {
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "리세스 맥플러리®" : "Reese’s McFlurry®",
				"image/dessert/prol_201703290608504310.png", 2800, 300));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "츄러스" : "Churros", 
				"image/dessert/prol_201601311029185960.png", 2000, 181));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "오레오 맥플러리®" : "Oreo McFlurry®",
				"image/dessert/prol_201312050311223540.png", 3000, 322));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "딸기 오레오 맥플러리®" : "Strawberry Oreo McFlurry®",
				"image/dessert/prol_201312041015558530.png", 3000, 291));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초코 오레오 맥플러리®" : "Choco Oreo McFlurry®",
				"image/dessert/prol_201312050311494320.png", 3000, 375));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초코 선데이 아이스크림" : "Chocolate Sundae",
				"image/dessert/prol_201311280226114370.png",  2000, 307));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "카라멜 선데이 아이스크림" : "Caramel Sundae",
				"image/dessert/prol_201509091159582930.png", 2000, 306));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "딸기 선데이 아이스크림" : "Strawberry Sundae",
				"image/dessert/prol_201311280223173290.png", 2000, 261));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "오레오 아포가토" : "Oreo Affogato",
				"image/dessert/prol_201311280221377300.png", 2800, 248));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "초코콘" : "Chocolate Cone",
				"image/dessert/prol_201311280227345110.png", 800, 229));
		dessertTable.addMenu(new MenuButton(LangCheck.isKorean() ? "아이스크림콘" : "Ice Cream Cone",
				"image/dessert/prol_201311280228539530.png", 600, 153));
	}

	private static final long serialVersionUID = -3009884571057632259L;
}
