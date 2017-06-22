package dev.mcdonaldkiosk.page;

/**
 * Class Role : KioskPage의 공통된 로딩 처리를 담당한다.
 *
 * @author kimjaehyeon
 */
public interface KioskPageLoader {

  // 다음 페이지 불러온다.
  public abstract void loadNextPage(OrderData orderData);

  // 이전 페이지 불러온다.
  public abstract void loadPreviousPage(OrderData orderData);

  // 로드페이지 소리재생
  public abstract void playSoundOfLoadPage();

  // 페이지 새로고침
  public abstract void refreshPage(OrderData orderData);
}
