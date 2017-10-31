package dev.mcdonaldkiosk.page.start;

import javax.swing.ImageIcon;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.PageData;
import dev.mcdonaldkiosk.util.Display;

/**
 * Class Role : 주문이 처음 시작될 때 보여지는 View 컴포넌트 이다.
 * 
 * 주문시작 페이지(StartPage)와 주문 종료 페이지(EndPage)의 공통 컴포넌트인 ImageTextPanel이 사용한다.
 *
 * @author Jaehyeon Kim
 */
public class StartPage extends KioskPage {
  
  public StartPage() {
    super(new PageData.Builder(LangCheck.isKorean() ? "sound/start.wav" : "sound/start_eng.wav")
                      .nextPageType(KioskPageType.EAT_PLACE_PAGE)
                      .build());
    
    addImageTextPanel();
    setNextPage();
  }
  
  private void addImageTextPanel() {
    this.add(createImageTextPanel());
  }
  
  private ImageTextPanel createImageTextPanel() {
    final ImageTextPanel imgTextPanel = new ImageTextPanel(new ImageIcon("image/bg_info2.jpg"),
                                                           LangCheck.isKorean() ? "주문하시려면 화면을 터치하세요" : "TOUCH TO START");
    imgTextPanel.setSize(Display.WINDOWS_HALF_WIDTH, Display.WINDOWS_AVALIABLE_HEIGHT);
    imgTextPanel.setLocation(0, 0);
    
    return imgTextPanel;
  }
  
  private void setNextPage() {
    this.setOnClickListener(() -> StartPage.this.loadNextPage());
  }
}