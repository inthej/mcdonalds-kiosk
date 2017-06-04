package dev.empkiosk.page.order;

import dev.empkiosk.language.LangCheck;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/* 이름이 않좋습니다. 클래스 역할에 맞게 알맞은 이름을 지으세요. */
@Deprecated
class CartTitlePanel extends JPanel {

	private static final JLabel MENU_LABEL = new JLabel(LangCheck.isKorean() ? "메뉴" : "MENU", JLabel.CENTER);
	private static final JLabel QUANTITY_LABEL = new JLabel(LangCheck.isKorean() ? "수량" : "QUANTITY", JLabel.CENTER);
	private static final JLabel PRICE_LABEL = new JLabel(LangCheck.isKorean() ? "가격" : "PRICE", JLabel.CENTER);

	private static final Color BACKGROUND_COLOR = Color.BLACK;
	private static final Color FONT_COLOR = Color.WHITE;

	CartTitlePanel() {
		initCartTopPanel();
		initLabels();
	}

	void initCartTopPanel() {
		this.setLayout(new GridLayout(0, 3));
		this.setBackground(BACKGROUND_COLOR);
	}

	void initLabels() {
		MENU_LABEL.setForeground(FONT_COLOR);
		QUANTITY_LABEL.setForeground(FONT_COLOR);
		PRICE_LABEL.setForeground(FONT_COLOR);

		this.add(MENU_LABEL);
		this.add(QUANTITY_LABEL);
		this.add(PRICE_LABEL);
	}

	private static final long serialVersionUID = -8661061076586747725L;
}
