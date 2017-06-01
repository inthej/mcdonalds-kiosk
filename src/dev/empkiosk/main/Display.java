package dev.empkiosk.main;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Created by kimjaehyeon on 2017. 5. 19
 * Class Role : 디스플레이 화면의 정보를 제공한다.
 * 디스플레이 화면의 정보는 스크린 사이즈와, 윈도우 사이즈가 있다.
 */
public final class Display {

  /* 다른 컨포넌트에서 정적 사이즈 할당 을 쉽게 하기위해서 static으로 사용하여 접근을 열어두었다. */
  // 스크린 사이즈
  public static final int SCREEN_WIDTH;
  public static final int SCREEN_HEIGHT;

  // 윈도우 사이즈
  public static final int WINDOWS_WIDTH;
  public static final int WINDOWS_HEIGHT;

  static {
    final Dimension DIMEN = Toolkit.getDefaultToolkit().getScreenSize();
    SCREEN_WIDTH = (int) DIMEN.getWidth();
    SCREEN_HEIGHT = (int) DIMEN.getHeight();

    final GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
    final Rectangle REC = GE.getMaximumWindowBounds();
    WINDOWS_WIDTH = (int) REC.getWidth();
    WINDOWS_HEIGHT = (int) REC.getHeight();
  }

  private Display() {
  }
}
