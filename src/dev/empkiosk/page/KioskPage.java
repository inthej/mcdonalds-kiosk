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
 * Class Role : MainFrame 에서 사용되는 패널
 * 1. 배경화면 표시여부를 제공한다.
 * 2. 배경화면 이미지파일 경로 설정을 제공한다.
 * 3. 백버튼 표시여부가 가능하다.
 */
public abstract class KioskPage extends JPanel {

    public static final int PAGE_WIDTH = MainFrame.FRAME_WIDTH - MainFrame.FRAME_WIDTH / 200;
    public static final int PAGE_HEIGHT =
            MainFrame.FRAME_HEIGHT - (Display.SCREEN_HEIGHT - Display.WINDOWS_HEIGHT);

    protected final BackButton BACK_BUTTON = new BackButton();

    private boolean isBackgroundImg;
    private String backgroundImg;

    public KioskPage() {
        initPage();
    }

    private void initPage() {
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
        if (bool != isBackgroundImg) {
            if (bool && backgroundImg != null) {
                isBackgroundImg = bool;
            }
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

    private static final long serialVersionUID = 1597979454780430547L;
}