package dev.mcdonaldkiosk.page.order;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : TextLabel을 ToolBar형식으로 제공하는 패널이다.
 * 
 * 특징 -
 * 1. 입력된 텍스트의 갯수만큼 GridLayout(0, textCnt) 형식의 레이아웃이 사용된다.
 * 2. 입력된 텍스트는 지정된 라벨의 디자인으로 툴바에 추가된다.
 * 
 * 기능 -
 * 텍스트입력을 제공한다.
 * 
 * @since 2017. 06. 06.
 * @author kimjaehyeon
 */
class TextToolbarPanel {
	
	private final JPanel TEXT_TOOLBAR_PANEL = new JPanel();
	
	private final Color BACKGROUND_COLOR = Color.BLACK;
	private final Color TEXT_COLOR = Color.WHITE;

	private int textCnt;
	
	TextToolbarPanel() {
		initTextToolbarPanel();
	}
	
	void initTextToolbarPanel() {
		TEXT_TOOLBAR_PANEL.setBackground(BACKGROUND_COLOR);
	}
	
	TextToolbarPanel addText(String text) {
		TEXT_TOOLBAR_PANEL.setLayout(new GridLayout(0, ++textCnt));
		TEXT_TOOLBAR_PANEL.add(getDesignLabel(new JLabel(text, JLabel.CENTER)));
		
		return this;
	}
	
	private JLabel getDesignLabel(JLabel jLabel) {
		jLabel.setForeground(TEXT_COLOR);
		return jLabel;
	}
	
	public Component getPanel() {
		return TEXT_TOOLBAR_PANEL;
	}
}
