package dev.empkiosk.page.order;

import dev.empkiosk.page.LangCheck;

public class OrderData {
	final String MENU_NAME;
	final int PRICE;
	final int K_CAL;
	
	OrderData(String menuName, int price, int kCal) {
		this.MENU_NAME = menuName;
		this.PRICE = price;
		this.K_CAL = kCal;
	}
	
	String getMenuName() {
		return MENU_NAME;
	}
	
	int getPrice() {
		return PRICE;
	}
	
	int getKCal() {
		return K_CAL;
	}
	
	@Override
	public String toString() {
		return new StringBuilder().append(MENU_NAME).append(" || ").
				append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append(PRICE).append(" || ")
				.append(K_CAL).append("KCal").toString();
	}
	
	public String toMenuButtonText(String priceTextColor){
		return new StringBuilder().append("<html><center>")
				.append(MENU_NAME).append("<br>")
				.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='")
				.append(priceTextColor).append("'>")
				.append(PRICE).append("</font><br>")
				.append(K_CAL).append("KCal").append("</center></html>").toString();
	}
}
