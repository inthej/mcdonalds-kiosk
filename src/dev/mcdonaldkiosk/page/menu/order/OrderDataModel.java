package dev.mcdonaldkiosk.page.menu.order;

import java.util.ArrayList;

import dev.mcdonaldkiosk.page.menu.Menu;

/**
 * Class Role : 주문관련 데이터 제공한다.
 * 
 * @author kimjaehyeon
 * @since 2017. 06. 07.
 */
public class OrderDataModel {

	private final ArrayList<Menu> ORDER_MENU_LIST = new ArrayList<>();
	private final OrderDataCalculator ORDER_DATA_CALCULATOR = new OrderDataCalculator(ORDER_MENU_LIST);
	
	public OrderDataModel() {
	
	}
	
	void clear() {
		ORDER_MENU_LIST.clear();
	}

	public void add(Menu order) {
		ORDER_MENU_LIST.add(order);
	}

	public Menu[] getOrderMenuArray() {
		return ORDER_MENU_LIST.toArray(new Menu[ORDER_MENU_LIST.size()]);
	}
	
	public int getTotalQuantity() {
		return ORDER_DATA_CALCULATOR.getOrderQuantity();
	}
	
	public int getTotalAmount() {
		return ORDER_DATA_CALCULATOR.getOrderAmount();
	}
	
	public int getTotalKCal() {
		return ORDER_DATA_CALCULATOR.getTotalKCal();
	}
}
