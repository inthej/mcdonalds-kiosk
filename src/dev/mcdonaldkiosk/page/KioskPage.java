package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Class Role : MainFrame 에서 필요로 하는 JPanel을 Customizing 한 타입이다.
 * KioskPage 를 상속하고 View를 구현할 경우 MainFrame에 화면에 표시할 수 있는 객체가 된다.
 * Customizing의 특징으로는 프로그램이 로딩시 사운드가 실행이되며 프로그램 배경이미지 설정과 이전버튼(BackButton)을 제공한다.
 *
 * 기능 :
 * 1. 배경 이미지 파일 경로 설정을 제공한다.
 * 2. 배경화면 표시 기능을 제공한다.
 * 3. 이전버튼 표시 기능을 제공한다.
 *
 * @author Jaehyeon Kim
 * @see MainFrame#attachPanel(KioskPage),BackButton
 * @since 2017. 05. 16.
 */
public abstract class KioskPage extends JPanel {

  private String backgroundImg;
  private BackButton backButton = new BackButton();

  private static final KioskOrderData kioskOrderData = new KioskOrderData();
  private KioskPageType nextPageType = KioskPageType.EMPTY_PAGE;
  private KioskPageType previousPageType = KioskPageType.EMPTY_PAGE;

  KioskPage() { }

  public KioskPage(KioskSettingData kioskSettingData) {
    this.nextPageType = kioskSettingData.getNextPageType();
    this.previousPageType = kioskSettingData.getPreviousPageType();

    KioskAudioPlayer.createKioskAudioPlayer(kioskSettingData.getAudioPath()).play();
    initKioskPage();
    setListener();
  }

  private void initKioskPage() {
    this.setLayout(null);
    this.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
    this.setLocation(0, 0);
  }

  private void setListener() {
    backButton.addActionListener((e) -> {
      loadPreviousPage();
    });
  }

  protected BackButton getBackButton() {
    return backButton;
  }

  // 배경이미지 설정
  protected void setBackgroundImg(final String filePath) {
    if (filePath != null) {
      backgroundImg = filePath;
    }
  }

  protected void showBackButton() {
    this.add(backButton);
  }

  /* 배경이미지 등록 여부 */
  private boolean isBackgroundImg() {
    return backgroundImg != null;
  }

  /* 배경이미지 설정 */
  @Override
  protected void paintComponent(final Graphics g) {
    if (isBackgroundImg()) {
      try {
        BufferedImage bufferImg = ImageIO.read(new File(backgroundImg));
        super.paintComponent(g);
        g.drawImage(bufferImg, 0, 0, MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT, null);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  protected void loadNextPage() {
    if (nextPageType != KioskPageType.EMPTY_PAGE) {
      MainFrame.attachPanel(nextPageType.createKioskPage());
    }
  }

  protected void loadPreviousPage() {
    if (previousPageType != KioskPageType.EMPTY_PAGE) {
      MainFrame.attachPanel(previousPageType.createKioskPage());
    }
  }

  protected void reloadPage() {
    try {
      MainFrame.attachPanel(this.getClass().newInstance());
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }

  protected static KioskOrderData getKioskOrderData() {
    return kioskOrderData;
  }
}