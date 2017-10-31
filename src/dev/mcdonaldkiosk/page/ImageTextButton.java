package dev.mcdonaldkiosk.page;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import dev.mcdonaldkiosk.util.Display;
import dev.mcdonaldkiosk.util.ImageEdit;

/**
 * Class Role : 이미지와 텍스트로 구성된 버튼이다.
 * 상단의 이미지와 하단의 텍스트 구성을 가지고 있는 버튼이다.
 *
 * 특징 :
 * 1. 이미지는 지정한 크기에 맞게 화질이 보정되어 변환된 형태를 가지고 있다.
 * 
 * @author Jaehyeon Kim
 */
public class ImageTextButton extends JButton {

  private final int IMAGE_SIZE_WIDTH = Display.WINDOWS_HALF_WIDTH * 4 / 15;
  private final int IMAGE_SIZE_HEIGHT = Display.WINDOWS_AVALIABLE_HEIGHT * 2 / 15;

  private final float FONT_SIZE = 15.0f; // float자료형 글자크기, int자료형 글자디자인
  private final Color FONT_COLOR = Color.RED;
  private final Color BG_COLOR = Color.WHITE;

  public ImageTextButton() {
    initeImageTextButton();
  }

  public ImageTextButton(String text, ImageIcon icon) {
    super(text, icon);
    initeImageTextButton();
    setResizedImg(icon);
  }

  public ImageTextButton(String text) {
    super(text);
    initeImageTextButton();
  }

  private void initeImageTextButton() {
    this.setFont(this.getFont().deriveFont(FONT_SIZE));
    this.setForeground(FONT_COLOR);
    this.setBackground(BG_COLOR);
    this.setHorizontalTextPosition(SwingConstants.CENTER);
    this.setVerticalTextPosition(SwingConstants.BOTTOM);
  }

  private void setResizedImg(ImageIcon imgIcon) {
    this.setIcon(ImageEdit.getResizeIcon(imgIcon, IMAGE_SIZE_WIDTH, IMAGE_SIZE_HEIGHT));
  }

  public void setResizedImg(ImageIcon imgIcon, int width, int height) {
    this.setIcon(ImageEdit.getResizeIcon(imgIcon, width, height));
  }
}
