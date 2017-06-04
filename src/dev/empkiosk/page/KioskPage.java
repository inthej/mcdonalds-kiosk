package dev.empkiosk.page;

import dev.empkiosk.main.Display;
import dev.empkiosk.main.MainFrame;

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

	@Deprecated
	/* Pulbic 이어야 합니까? Page의 size 공개는 한쪽에서만 해주세요. 이곳저곳에 page width 정보가 널렸습니다. 다 정리하세요. */
	public static final int PAGE_WIDTH = MainFrame.FRAME_WIDTH - MainFrame.FRAME_WIDTH / 200;
	@Deprecated
	/* Pulbic 이어야 합니까? Page의 size 공개는 한쪽에서만 해주세요. 이곳저곳에 page width 정보가 널렸습니다. 다 정리하세요. */
	public static final int PAGE_HEIGHT = MainFrame.FRAME_HEIGHT - (Display.SCREEN_HEIGHT - Display.WINDOWS_HEIGHT);
	
	@Deprecated
	/* BACK_BUTTON을 자식에게 공개할 이유가 없습니다. 자식에게 할일을 많이 주지 마세요. 웬만하면 부모 클래스에서 해결하세요. */
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
	/* 보통 setBackgroundImg 를 하면 isBackgroundImg는 true가 되어야 합니다.
	 * setText 할때도
	 * showText(true)까지 안씁니다. setText만쓰지. */
	@Deprecated
	protected void setBackgroundImg(String filePath) {
		backgroundImg = filePath;
	}

	/* backgroundImg != null <-- 이렇게 강제화 하는건 좋지 않습니다. 배경을 껏다 켰다 하고 싶을때 쓰는게
	 * show~
	 * hide~
	 * 패턴의 메서드에요. */
	@Deprecated
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