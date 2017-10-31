package dev.mcdonaldkiosk.page.end;

import java.awt.Color;
import javax.swing.ImageIcon;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.ImageTextPanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.PageData;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import dev.mcdonaldkiosk.util.Display;

/**
 * Class Role : 주문이 종료 되었을 때 보여지는 View 컴포넌트 이다.
 * 
 * 주문 데이터가 초기화 되며,
 * 주문시작 페이지(StartPage)와 주문 종료 페이지(EndPage)의 공통 컴포넌트인 ImageTextPanel이 사용한다.
 *
 * @author Jaehyeon Kim
 */
public class EndPage extends KioskPage {

  public EndPage() {
    super(new PageData.Builder(KioskPage.getKioskOrderData().getPaymentPlace().equals(PaymentPlace.COUNTER)
                                ? LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav"
                                : LangCheck.isKorean() ? "sound/end.wav" : "sound/end_eng.wav")
                      .nextPageType(KioskPageType.START_PAGE)
                      .build());

    emptyOrder();
    addImgTextPanel();
    setNextPage();
  }
  
  private void emptyOrder() {
    KioskPage.getKioskOrderData().emptyOrder();
  }
  
  private void addImgTextPanel() {
    this.add(createImgTextPanel());
  }
  
  private ImageTextPanel createImgTextPanel() {
    final ImageTextPanel imgTextPanel = new ImageTextPanel(new ImageIcon("image/bg_info3.jpg"),
        LangCheck.isKorean() ? "주문이 완료되었습니다." : "YOUR ORDER IS COMPLETE");
    imgTextPanel.setSize(Display.WINDOWS_HALF_WIDTH, Display.WINDOWS_AVALIABLE_HEIGHT);
    imgTextPanel.setLocation(0, 0);
    imgTextPanel.setTextBackground(Color.BLUE);
    
    return imgTextPanel;
  }

  private void setNextPage() {
    this.setOnClickListener(() -> EndPage.this.loadNextPage());
  }
}
