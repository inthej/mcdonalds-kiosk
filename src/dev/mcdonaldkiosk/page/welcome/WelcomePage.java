package dev.mcdonaldkiosk.page.welcome;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.eatplace.EatPlacePage;

/**
 * Created by kimjaehyeon on 2017. 5. 19 
 * Class Role : 프로그램 시작 페이지
 *
 * 특징 : 
 * 1. KioskPage의 구성을 가지고 있다. 
 * 2. ImageTextPanel의 특징을 가지고 있다.
 */
public class WelcomePage extends KioskPage {

	private final ImageTextPanel IMG_TEXT_PANEL = new ImageTextPanel(new ImageIcon("image/bg_info2.jpg"),
			LangCheck.isKorean() ? "주문하시려면 화면을 터치하세요" : "TOUCH TO START");

	public WelcomePage() {
		initPage();
		initImgTextPanel();

		setListener();
	}

	private void initPage() {
		// 백버튼 표시여부.
		this.showBackButton();
		
		// 소리재생.
		this.playSound(LangCheck.isKorean() ? "sound/welcome.wav" : "sound/welcome_eng.wav");
	}

	private void initImgTextPanel() {
		IMG_TEXT_PANEL.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		IMG_TEXT_PANEL.setLocation(0, 0);

		this.add(IMG_TEXT_PANEL);
	}

	private void setListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MainFrame.attachPanel(new EatPlacePage());
			}
		});
	}
	
	private static final long serialVersionUID = -1185488629202701120L;
}