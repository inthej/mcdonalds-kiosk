package dev.mcdonaldkiosk.page.welcome;

import dev.mcdonaldkiosk.page.KioskPageType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;

/**
 * Class Role : ImageTextPanel을 이용하여 회사로고 이미지와 주문시작 안내를 표시한다.
 *
 * @author Jaehyeon Kim
 * @see ImageTextPanel
 * @since 2017. 05. 19.
 */
public class WelcomePage extends KioskPage {

  private final ImageIcon BannerImgIcon = new ImageIcon("image/bg_info2.jpg");
  private final String TITLE = LangCheck.isKorean() ? "주문하시려면 화면을 터치하세요" : "TOUCH TO START";

  private ImageTextPanel imageTextPanel = new ImageTextPanel(BannerImgIcon, TITLE);

  public WelcomePage() {
    super(KioskPageType.WELCOME_PAGE);
    initWelcomePage();
    initImgTextPanel();

    setListener();
  }

  private void initWelcomePage() {
    // 백버튼 표시여부.
    this.showBackButton();
    this.add(imageTextPanel);
  }

  private void initImgTextPanel() {
    imageTextPanel.setSize(MainFrame.FRAME_WIDTH, MainFrame.AVALIABLE_FRAME_HEIGHT);
    imageTextPanel.setLocation(0, 0);
  }

  private void setListener() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        currentPage.loadNextPage();
      }
    });
  }
}