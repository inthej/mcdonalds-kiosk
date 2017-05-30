package dev.empkiosk.page.order;

import javax.swing.JScrollPane;

/**
 * 장바구니 패널의 선택메뉴 리스트 스크롤
 */
class CartScrollPane extends JScrollPane {
	
	CartScrollPane() {
		initCartCenterScrollPane();
	}
	
	private void initCartCenterScrollPane() {
		
	}
	
	// 스크롤을 최하단으로 내린다.
	void scrollDown() {
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}
	
	private static final long serialVersionUID = -3433581082175322789L;
}
