package dev.mcdonaldkiosk.page.menu.order;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import dev.mcdonaldkiosk.lang.LangCheck;

/**
 * Created by kimjaehyeon 
 * Class Role : 선택한 주문확인을 담당한다.
 */
public class MyOrderPanel extends JPanel {

	/* 주문 장바구니 리스트 */
	private final OrderDataModel ORDER_DATA_MODEL = new OrderDataModel();

	private final TextToolbarPanel TEXT_TOOLBAR_PANEL = new TextToolbarPanel();
	private final SelectMenuBoxScrollPane SELECT_MENU_BOX_SCROLL_PANE = new SelectMenuBoxScrollPane(ORDER_DATA_MODEL.getOrderMenuArray());
	private final OrderConfirmPanel ORDER_CONFIRM_PANEL;

	public MyOrderPanel() {
		ORDER_CONFIRM_PANEL = new OrderConfirmPanel(ORDER_DATA_MODEL.getTotalQuantity(),
				ORDER_DATA_MODEL.getTotalAmount(), ORDER_DATA_MODEL.getTotalKCal());
		// 초기화
		initMyOrderPanel();
		addTextToTextToolbar();
	}

	private void initMyOrderPanel() {
		this.setLayout(new BorderLayout());
		this.add(TEXT_TOOLBAR_PANEL.getPanel(), BorderLayout.NORTH);
		this.add(SELECT_MENU_BOX_SCROLL_PANE, BorderLayout.CENTER);
		this.add(ORDER_CONFIRM_PANEL, BorderLayout.SOUTH);
	}

	// 텍스트툴바에 텍스트 추가
	private void addTextToTextToolbar() {
		TEXT_TOOLBAR_PANEL.addText(LangCheck.isKorean() ? "메뉴" : "MENU")
				.addText(LangCheck.isKorean() ? "수량" : "QUANTITY")
				.addText(LangCheck.isKorean() ? "가격" : "PRICE");
	}
}
