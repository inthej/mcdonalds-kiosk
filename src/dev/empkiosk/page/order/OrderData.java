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

    /**
     * 영문버전 일때 <br> 태그가 포함되어 있는 경우도 있다.
     * 태그를 제거 이름을 리턴한다.
     * <p>
     * 사용용도는 메뉴를 선택하였을때 사용데이터를 장바구니 스크롤데이터 박스에 메뉴명을 입력하는 용도의 메서드이다.
     */
    public String getMenuNameWithoutTag() {
        //<bR></bR><BR><br><br/><br /> 태그 개행 문자 치환
        String tmpMenuName = MENU_NAME.replaceAll("<(/)?[bB][rR](\\s)*(/)?>", " ");
        //모든태그 제거
        return tmpMenuName.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
    }

    int getPrice() {
        return PRICE;
    }

    int getKCal() {
        return K_CAL;
    }

    public String toMenuButtonText(String priceTextColor) {
        return new StringBuilder().append("<html><center>")
                .append(MENU_NAME).append("<br>")
                .append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='")
                .append(priceTextColor).append("'>")
                .append(PRICE).append("</font><br>")
                .append(K_CAL).append("KCal").append("</center></html>").toString();
    }

    // 데이터 입력 용도.
    @Override
    public String toString() {
        return new StringBuilder().append(getMenuNameWithoutTag()).append(" || ").
                append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append(PRICE).append(" || ")
                .append(K_CAL).append("KCal").toString();
    }
}
