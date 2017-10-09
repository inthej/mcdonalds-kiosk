package dev.mcdonaldkiosk.main;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 * class role : 디스플레이 화면 크기의 정보를 제공한다.
 *
 * @author Jaehyeon Kim
 * @since 2017. 05. 19.
 */
public class Display {

  static final int SCREEN_HEIGHT;

  static final int WINDOWS_WIDTH;
  static final int WINDOWS_HEIGHT;
  static final int TITLE_BAR_HEIGHT;
  public static final int WINDOWS_WIDTH_HALF;
  public static final int AVALIABLE_WINDOW_HEIGHT;

  static {
    Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
    SCREEN_HEIGHT = (int) dimen.getHeight();

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Rectangle rec = ge.getMaximumWindowBounds();
    WINDOWS_WIDTH = (int) rec.getWidth();
    WINDOWS_HEIGHT = (int) rec.getHeight();
    
    WINDOWS_WIDTH_HALF = WINDOWS_WIDTH / 2;
    TITLE_BAR_HEIGHT = SCREEN_HEIGHT - WINDOWS_HEIGHT;
    AVALIABLE_WINDOW_HEIGHT = WINDOWS_HEIGHT - TITLE_BAR_HEIGHT;
  }

  private Display() {}
}
