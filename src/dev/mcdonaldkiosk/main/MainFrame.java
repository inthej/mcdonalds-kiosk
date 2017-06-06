package dev.mcdonaldkiosk.main;

import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.welcome.WelcomePage;

import javax.swing.JFrame;

/**
 * Created by kimjaehyeon on 2017. 5. 15.. 
 * Class Role : 프로그램에서 유일하게 사용되는 프레임이다.
 * <p>
 * 기능- 
 * 1. 입력된 Page를 프레임에 붙인다.(갱신하다.) 
 * 2. 화면을 보여준다.
 */
public final class MainFrame extends JFrame {

	/* 프레임 사이즈 */
	public static final int FRAME_WIDTH = Display.WINDOWS_WIDTH / 2;

	/* 프레임의 세로 크기는 Windows상태바의 높이를 제외하여 규정하였다. */
	public static final int FRAME_HEIGHT = Display.WINDOWS_HEIGHT - Display.WINDOWS_BAR_HEIGHT;

	/* 싱글톤 */
	private static final MainFrame MAIN_FRAME = new MainFrame();
	private final String TITLE = "ORDER HERE!";

	private MainFrame() {
		initMainFrame();
	}

	// 프레임 환경설정
	private void initMainFrame() {
		this.setLayout(null);
		this.setTitle(TITLE);
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT + Display.WINDOWS_BAR_HEIGHT);
		this.setResizable(false);
		this.setLocation((Display.WINDOWS_WIDTH - FRAME_WIDTH) / 2, 0);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(new WelcomePage());
	}

	// 입력된 KioskPage를 프레임에 붙인다.
	public static void attachPanel(KioskPage page) {
		// 컨테이너 삭제
		MAIN_FRAME.getContentPane().removeAll();

		// 패널 추가
		MAIN_FRAME.getContentPane().add(page);

		// 갱신
		MAIN_FRAME.revalidate();
		MAIN_FRAME.repaint();
	}

	// 화면을 보여준다.
	static void showScreen() {
		MAIN_FRAME.setVisible(true);
	}
}