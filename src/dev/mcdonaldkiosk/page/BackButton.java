package dev.mcdonaldkiosk.page;

import java.awt.Color;
import javax.swing.JButton;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.Display;

/**
 * Created by kimjaehyeon on 2017. 5. 16..
 * Class Role : KioskPage에서 사용되는 백버튼의 디자인 및 상태를 설정한다.
 */
public class BackButton extends JButton {

  /* 버튼 사이즈 */
  private final int BUTTON_WIDTH = Display.WINDOWS_WIDTH_HALF / 5;
  private final int BUTTON_HEIGHT = Display.AVALIABLE_WINDOW_HEIGHT / 20;

  private final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

  public BackButton() {
    initButton();
  }

  private void initButton() {
    this.setText(LangCheck.isKorean() ? "뒤로" : "BACK");
    this.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
    this.setLocation(Display.WINDOWS_WIDTH_HALF - BUTTON_WIDTH,
        Display.AVALIABLE_WINDOW_HEIGHT
            - (Display.AVALIABLE_WINDOW_HEIGHT - BUTTON_HEIGHT));
    this.setBackground(BACKGROUND_COLOR);
  }
}