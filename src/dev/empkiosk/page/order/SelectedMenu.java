package dev.empkiosk.page.order;

/**
 * Created by kimjaehyeon
 * Class Role : 선택메뉴 데이터를 제공한다.
 */
public class SelectedMenu {
	public static int orderAmount = 0;	// 주문금액
	public static int orderQuantity = 0;	// 주문수량
	public static int totalKCal = 0;	// 총 칼로리
	
	private SelectedMenu() {
		
	}
	
	public static void addOrder(int amount, int quantity, int kCal) {
		orderAmount += amount;
		orderQuantity += quantity;
		totalKCal += kCal;
	}
	
	public static void init() {
		orderAmount = 0;
		orderQuantity = 0;
		totalKCal = 0;
	}
}
