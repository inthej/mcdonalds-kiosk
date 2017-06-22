package dev.mcdonaldkiosk.page.end;

import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.OrderData;
import dev.mcdonaldkiosk.page.start.StartPage;

/**
 * Class Role : ThankPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 *
 * @author kimjaehyeon
 */
public class EndPageKioskPageLorder implements KioskPageLoader {

  @Override
  public void loadNextPage(OrderData orderData) {
    MainFrame.attachPanel(new StartPage());
  }

  @Override
  public void loadPreviousPage(OrderData orderData) {
    // TODO Auto-generated method stub
  }

  @Override
  public void playSoundOfLoadPage() {
    // TODO 이용해주셔서 감사합니다. 사운드 제작
  }

  @Override
  public void refreshPage(OrderData orderData) {
    // TODO Auto-generated method stub
  }
}
