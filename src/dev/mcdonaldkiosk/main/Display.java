package dev.mcdonaldkiosk.main;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * Class Role : 디스플레이 화면 크기의 정보를 제공한다.
 * 디스플레이 화면의 정보는 스크린 사이즈와, 윈도우 사이즈, 윈도우 상태바 사이즈가 존재한다.
 * 정보가 제공되는 목적은 MainFrame의 정적 사이즈 할당때문이다.
 *
 * @author Jaehyeon Kim
 * @see MainFrame
 * @since 2017. 05. 19.
 */
final class Display {

  static final int SCREEN_HEIGHT;

  static final int WINDOWS_WIDTH;
  static final int WINDOWS_HEIGHT;
  static final int WINDOWS_BAR_HEIGHT;

  static {
    Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
    SCREEN_HEIGHT = (int) dimen.getHeight();

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Rectangle rec = ge.getMaximumWindowBounds();
    WINDOWS_WIDTH = (int) rec.getWidth();
    WINDOWS_HEIGHT = (int) rec.getHeight();
    WINDOWS_BAR_HEIGHT = SCREEN_HEIGHT - WINDOWS_HEIGHT;
  }

  private Display() {
  }
}
