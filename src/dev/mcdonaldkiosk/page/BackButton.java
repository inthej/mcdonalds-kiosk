package dev.mcdonaldkiosk.page;

import java.awt.Color;
import javax.swing.JButton;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.util.Display;

/**
 * class role : KioskPage에서 사용되는 백버튼의 디자인 및 상태를 설정한다.
 * 
 * @author Jaehyeon Kim
 * @since 2017. 05. 16.
 */
public class BackButton extends JButton {

  /* 버튼 사이즈 */
  private static final int BUTTON_WIDTH = Display.WINDOWS_WIDTH_HALF / 5;
  private static final int BUTTON_HEIGHT = Display.AVALIABLE_WINDOW_HEIGHT / 20;
  private static final Color BG_COLOR = Color.LIGHT_GRAY;

  BackButton() {
    init();
    setLocationByTopRight();
  }

  private void init() {
    this.setText(LangCheck.isKorean() ? "뒤로" : "BACK");
    this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    this.setBackground(BG_COLOR);
  }
  
  private void setLocationByTopRight() {
    this.setLocation(Display.WINDOWS_WIDTH_HALF - BUTTON_WIDTH,
        Display.AVALIABLE_WINDOW_HEIGHT - (Display.AVALIABLE_WINDOW_HEIGHT - BUTTON_HEIGHT));
  }
}