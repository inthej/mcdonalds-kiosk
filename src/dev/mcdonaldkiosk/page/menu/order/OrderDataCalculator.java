package dev.mcdonaldkiosk.page.menu.order;

import java.util.ArrayList;

import dev.mcdonaldkiosk.page.menu.Menu;

public class OrderDataCalculator {
	
	private final ArrayList<Menu> ORDER_MENU_LIST;
	
	OrderDataCalculator(ArrayList<Menu> list) {
		ORDER_MENU_LIST = list;
	}
	
	// 주문 수량
	public int getOrderQuantity() {
		return ORDER_MENU_LIST.size();
	}
	
	// 주문 금액
	public int getOrderAmount() {
		int totalAmount = 0;
		for (Menu menu : ORDER_MENU_LIST) {
			totalAmount += menu.getPrice();
		}
		
		return totalAmount;
	}
	
	// 총 칼로리
	public int getTotalKCal() {
		int totalKCal = 0;
		for (Menu menu : ORDER_MENU_LIST) {
			totalKCal += menu.getKCal();
		}
		
		return totalKCal;
	}
}