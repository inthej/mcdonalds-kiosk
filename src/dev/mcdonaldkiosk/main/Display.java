package dev.mcdonaldkiosk.main;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Created by kimjaehyeon on 2017. 5. 19 
 * Class Role : 디스플레이 화면의 정보 제공. 
 * 디스플레이 화면의 정보는 스크린 사이즈와, 윈도우 사이즈가 있다.
 */
public final class Display {

	// 스크린 사이즈
	static final int SCREEN_HEIGHT;

	// 윈도우 사이즈
	static final int WINDOWS_WIDTH;
	static final int WINDOWS_HEIGHT;
	static final int WINDOWS_BAR_HEIGHT;

	static {
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		SCREEN_HEIGHT = (int) dimen.getHeight();

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rec = ge.getMaximumWindowBounds();
		WINDOWS_WIDTH = (int) rec.getWidth();
		WINDOWS_HEIGHT = (int) rec.getHeight();
		WINDOWS_BAR_HEIGHT = SCREEN_HEIGHT - WINDOWS_HEIGHT;
	}

	private Display() {
	}
}
