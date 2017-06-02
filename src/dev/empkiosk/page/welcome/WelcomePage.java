package dev.empkiosk.page.welcome;

import dev.empkiosk.lang.LangCheck;
import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextPanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.eatplace.EatPlacePage;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		// 배경화면 표시여부.
		this.showBackgroundImg(false);
		// 백버튼 표시여부.
		this.showBackButton(false);
		// 소리재생.
		KioskVoice.playSound(LangCheck.isKorean() ? "sound/welcome.wav" : "sound/welcome_eng.wav");
	}

	private void initImgTextPanel() {
		IMG_TEXT_PANEL.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
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