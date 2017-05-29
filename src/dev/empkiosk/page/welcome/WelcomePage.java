package dev.empkiosk.page.welcome;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextPanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.eatplace.EatPlacePage;

/**
 * Created by kimjaehyeon on 2017. 5. 19 
 * Class Role : 인사 페이지
 */
public class WelcomePage extends KioskPage {

	private final ImageTextPanel WELCOME_IMG_TEXT_PANEL = new ImageTextPanel(new ImageIcon("image/bg_info2.jpg"),
			LangCheck.isKorean() ? "주문하시려면 화면을 터치하세요" : "TOUCH TO START");

	public WelcomePage() {
		initWelcomePage();
		initWelcomeImgTextPanel();
		setListener();
	}

	private void initWelcomePage() {
		this.showBackgroundImg(false);
		this.showBackButton(false);
		
		KioskVoice.playSound(LangCheck.isKorean() ? "sound/welcome.wav" : "sound/welcome_eng.wav");
	}
	
	private void initWelcomeImgTextPanel() {
		Component welcomeImgTextComp = WELCOME_IMG_TEXT_PANEL.getPanel();
		welcomeImgTextComp.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
		welcomeImgTextComp.setLocation(0, 0);
		
		this.add(welcomeImgTextComp);
	}

	private void setListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.attachPanel(new EatPlacePage());
			}
		});
	}

	private static final long serialVersionUID = -6650560747872554894L;
}