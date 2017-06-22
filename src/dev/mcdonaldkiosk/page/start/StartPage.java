package dev.mcdonaldkiosk.page.start;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.OrderData;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * Class Role : MainFrame이 실행되면 가장먼저 보여지는 KioskPage이다.
 * ImageTextPanel를 이용하여 이미지 베너와 텍스트를 보여준다.
 *
 * @author Jaehyeon Kim
 * @see MainFrame#initMainFrame(),ImageTextPanel
 * @since 2017. 05. 19.
 */
public class StartPage extends KioskPage {

  private final ImageTextPanel imageTextPanel = new ImageTextPanel(
      new ImageIcon("image/bg_info2.jpg"),
      LangCheck.isKorean() ? "주문하시려면 화면을 터치하세요" : "TOUCH TO START");

  public StartPage() {
    super(KioskPageType.START_PAGE, new OrderData());

    initImgTextPanel();
    setListener();
  }

  private void initImgTextPanel() {
    imageTextPanel.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
    imageTextPanel.setLocation(0, 0);

    this.add(imageTextPanel);
  }

  private void setListener() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        currentPage.loadNextPage(StartPage.this.orderData);
      }
    });
  }
}