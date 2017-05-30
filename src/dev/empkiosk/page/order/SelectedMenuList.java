package dev.empkiosk.page.order;

import java.util.Vector;

/**
 * Created by kimjaehyeon
 * Class Role : 선택메뉴의 데이터를 제공한다.
 */
public class SelectedMenuList {
	private static final SelectedMenuList UNIQUE_INSTANCE = new SelectedMenuList();
	private final Vector<OrderData> SELECTED_MENU_LIST = new Vector<>();
	
	private SelectedMenuList() {
		
	}
	
	public static SelectedMenuList getInstance() {
		return UNIQUE_INSTANCE;
	}
	
	// 선택 메뉴 추가
	public void add(OrderData order) {
		SELECTED_MENU_LIST.add(order);
	}
	
	// 선택 메뉴 비우기
	public void empty() {
		SELECTED_MENU_LIST.clear();
	}
	
	// 총 수량
	public int getTotalQuantity() {
		return SELECTED_MENU_LIST.size();
	}
	
	// 총 금액
	public int getTotalAmount() {
		int totalAmount = 0;
		if (!SELECTED_MENU_LIST.isEmpty()) {
			for (OrderData order : SELECTED_MENU_LIST) {
				totalAmount += order.getPrice();
			}
		}
		
		return totalAmount;
	}
	
	// 총 칼로리
	public int getTotalKCal() {
		int totalKCal = 0;
		if (!SELECTED_MENU_LIST.isEmpty()) {
			for (OrderData order : SELECTED_MENU_LIST) {
				totalKCal += order.getPrice();
			}
		}
		
		return totalKCal;
	}
}
