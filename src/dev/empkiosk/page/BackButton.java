package dev.empkiosk.page;

import java.awt.Color;
import javax.swing.JButton;

import dev.empkiosk.lang.LangCheck;

/**
 * Created by kimjaehyeon on 2017. 5. 16.. 
 * Class Role : KioskPage에서 사용되는 백버튼의 디자인 및 상태를 설정한다.
 */
public class BackButton extends JButton {

	/* 버튼 사이즈 */
	private static final int BUTTON_WIDTH = KioskPage.PAGE_WIDTH / 5;
	private static final int BUTTON_HEIGHT = KioskPage.PAGE_HEIGHT / 20;

	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

	public BackButton() {
		initButton();
	}

	private void initButton() {
		this.setText(LangCheck.isKorean() ? "뒤로" : "BACK");
		this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
		this.setLocation(KioskPage.PAGE_WIDTH - this.getWidth() - KioskPage.PAGE_WIDTH / 30,
				KioskPage.PAGE_HEIGHT - (KioskPage.PAGE_HEIGHT - this.getHeight()));
		this.setBackground(BACKGROUND_COLOR);
	}

	private static final long serialVersionUID = -4132633377653157405L;
}