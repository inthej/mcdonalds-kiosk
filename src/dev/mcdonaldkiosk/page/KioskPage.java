package dev.mcdonaldkiosk.page;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import dev.mcdonaldkiosk.main.Display;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : MainFrame 구성에 사용되는 View 컴포넌트 이다.
 * 
 * View 컴포넌트 특징
 * 1. 로딩시 사운드가 실행
 * 2. 배경이미지 설정
 * 3. 이전버튼(BackButton) 제공
 * 4. NextPage 페이지 설정 제공
 *
 * @author Jaehyeon Kim
 * @see MainFrame#attachPanel(KioskPage)
 */
public abstract class KioskPage extends JPanel {
  
  protected interface OnClickListener {
    public void onClick();
  }
  
  private OnClickListener onClickListener = null;
  
  private static final KioskOrderData kioskOrderData = new KioskOrderData();
  private KioskPageType nextPageType = KioskPageType.EMPTY_PAGE;
  private KioskPageType previousPageType = KioskPageType.EMPTY_PAGE;
  
  private final BackButton backBtn = new BackButton();
  private String bgPath;
  
  KioskPage() {}
  
  public KioskPage(KioskSettingData kioskSettingData) {
    nextPageType = kioskSettingData.getNextPage();
    previousPageType = kioskSettingData.getPreviousPage();

    initKioskPage();
    playKioskVoice(kioskSettingData.getAudioPath());
    setBackBtnListener();
    setMouseListener();
  }

  private void initKioskPage() {
    this.setLayout(null);
    this.setSize(Display.WINDOWS_WIDTH_HALF, Display.AVALIABLE_WINDOW_HEIGHT);
    this.setLocation(0, 0);
  }
  
  private void playKioskVoice(final String audioPath) {
    KioskAudioPlayer.createKioskAudioPlayer(audioPath).play();
  }

  private void setBackBtnListener() {
    backBtn.addActionListener(e -> loadPreviousPage());
  }
  
  protected void setOnClickListener(final OnClickListener listener) {
    onClickListener = listener;
  }
  
  private void setMouseListener() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        if (onClickListener != null) { onClickListener.onClick(); }
      }
    });
  }

  protected BackButton getBackButton() {
    return backBtn;
  }

  // 배경이미지 설정
  protected void setBackgroundImg(final String bgPath) {
    if (bgPath != null) { this.bgPath = bgPath; }
  }

  protected void showBackBtn() {
    setBackBtnZOrderByTop();
    this.add(backBtn);
  }
  
  /* BackButton Z-Order를 상위로 올린다.  */
  private void setBackBtnZOrderByTop() {
    this.setComponentZOrder(backBtn, 0);
  }

  private boolean isBgImgEmpty() {
    return bgPath != null;
  }

  /* 배경이미지 설정 */
  @Override
  protected void paintComponent(final Graphics g) {
    if (isBgImgEmpty()) {
      try {
        BufferedImage bufferImg = ImageIO.read(new File(bgPath));
        super.paintComponent(g);
        g.drawImage(bufferImg, 0, 0, Display.WINDOWS_WIDTH_HALF, Display.AVALIABLE_WINDOW_HEIGHT, null);
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