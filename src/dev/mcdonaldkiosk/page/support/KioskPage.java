package dev.mcdonaldkiosk.page.support;

import dev.mcdonaldkiosk.main.Display;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.support.BackButton;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Create by kimjaehyeon on 2017. 5. 16 
 * Class Role : MainFrame 에서 사용되는 Page 패널이다.
 *
 * 특징 : 
 * 1. 인스턴스를 생성할 수 없는 abstract class 이다. 
 * 2. Layout 을 가지고 있지 않다.(null) 
 * 3. 백 버튼을 가지고 있다. 
 * 4. 배경화면을 가지고 있으며 Background 이미지를 지정할 경우에만 표시가 가능하다.
 *
 * 기능 : 
 * 1. 배경화면 이미지파일 경로 설정을 제공한다. 
 * 2. 배경화면 표시 기능을 제공한다. 
 * 3. 백버튼 표시 기능을 제공한다.
 */
public abstract class KioskPage extends JPanel {

	public static final int PAGE_WIDTH = MainFrame.FRAME_WIDTH - MainFrame.FRAME_WIDTH / 200;
	public static final int PAGE_HEIGHT = MainFrame.FRAME_HEIGHT - (Display.SCREEN_HEIGHT - Display.WINDOWS_HEIGHT);

	protected final BackButton BACK_BUTTON = new BackButton();

	private boolean isBackgroundImg;
	private String backgroundImg;

	public KioskPage() {
		initKioskPage();
	}

	private void initKioskPage() {
		this.setLayout(null);
		this.setSize(PAGE_WIDTH, PAGE_HEIGHT);
		this.setLocation(0, 0);
	}

	// 배경이미지 설정
	protected void setBackgroundImg(String filePath) {
		backgroundImg = filePath;
	}

	/* 배경이미지 표시 여부 */
	protected void showBackgroundImg(boolean bool) {
		if (bool && backgroundImg != null) {
			isBackgroundImg = bool;
		}
	}

	/* 백버튼 표시 여부 */
	protected void showBackButton(boolean bool) {
		if (bool && backgroundImg != null) {
			this.add(BACK_BUTTON);
		}
	}

	/* 배경이미지 설정 */
	@Override
	protected void paintComponent(Graphics g) {
		if (isBackgroundImg) {
			try {
				BufferedImage bufferImg = ImageIO.read(new File(backgroundImg));
				super.paintComponent(g);
				g.drawImage(bufferImg, 0, 0, PAGE_WIDTH, PAGE_HEIGHT, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static final long serialVersionUID = -7872723353787164076L;
}