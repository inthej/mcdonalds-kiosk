package dev.mcdonaldkiosk.page.order;

import dev.mcdonaldkiosk.lang.LangCheck;

public class OrderData {

	final String MENU_NAME;
	final int PRICE;
	final int K_CAL;

	OrderData(String menuName, int price, int kCal) {
		this.MENU_NAME = menuName;
		this.PRICE = price;
		this.K_CAL = kCal;
	}

	int getPrice() {
		return PRICE;
	}

	int getKCal() {
		return K_CAL;
	}

	String toMenuButtonText(String priceTextColor) {
		return new StringBuilder().append("<html><center>").append(MENU_NAME).append("<br>")
				.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='").append(priceTextColor)
				.append("'>").append(PRICE).append("</font><br>").append(K_CAL).append("KCal")
				.append("</center></html>").toString();
	}

	/**
	 * 영문 주문일 경우 메뉴이름에 br 태그가 포함되는 경우도 있다. 
	 * br 태그를 공백문자로 치환하고 기타 태그를 제거한 메뉴이름을 리턴한다. 
	 * 장바구니 및 체크에서 메뉴 이름에 태그가 없도록 가공하기 위해 기능을 구현.
	 */
	private String getMenuNameWithoutTag() {
		// <bR></bR><BR><br><br/><br /> 태그 문자 치환
		final String tmpMenuName = MENU_NAME.replaceAll("<(/)?[bB][rR](\\s)*(/)?>", " ");
		// 모든태그 제거
		return tmpMenuName.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}

	@Override
	public String toString() {
		return new StringBuilder().append(getMenuNameWithoutTag()).append(" || ")
				.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append(PRICE).append(" || ").append(K_CAL)
				.append("KCal").toString();
	}
}
