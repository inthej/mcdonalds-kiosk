package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.util.ImageEdit;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : 이미지와 텍스트로 구성된 패널이다.
 * 중앙의 이미지 라벨과 하단의 텍스트 라벨의 구성을 가지고 있다.
 * <p>
 * 특징 :
 * 1. 사용되는 패널을 맴버로 가지고 있다.
 * 2. 특정한 레이아웃은 가지고 있지 않다.(null)
 * 3. 이미지는 지정한 크기에 맞게 화질이 보정되어 변환된 형태를 가지고 있다.
 * <p>
 * 기능 :
 * 1. 텍스트 라벨의 배경화면을 지정하는 기능을 제공한다.
 */
public class ImageTextPanel extends JPanel {

  private final int IMAGE_WIDTH = MainFrame.FRAME_WIDTH;
  private final int IMAGE_HEIGHT = MainFrame.FRAME_HEIGHT * 9 / 10;

  private final JLabel IMAGE_LABEL = new JLabel();
  private final JLabel TEXT_LABEL = new JLabel();

  private final float TEXT_SIZE = 20.0f;
  private final Color TEXT_COLOR = Color.WHITE;
  private Color TEXT_BACKGROUND_COLOR = new Color(00, 94, 00);

  private ImageEdit imageEdit = new ImageEdit();

  public ImageTextPanel(ImageIcon imgIcon, String text) {
    this.setLayout(null);

    initImageLabel(imgIcon);
    initTextLabel(text);
  }

  private void initImageLabel(ImageIcon imgIcon) {
    IMAGE_LABEL.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
    IMAGE_LABEL.setLocation(0, 0);
    IMAGE_LABEL.setIcon(imageEdit.getResizeIcon(imgIcon, IMAGE_WIDTH, IMAGE_HEIGHT));

    this.add(IMAGE_LABEL);
  }

  private void initTextLabel(String text) {
    TEXT_LABEL.setText(text);
    TEXT_LABEL.setHorizontalAlignment(JLabel.CENTER);
    TEXT_LABEL.setFont(TEXT_LABEL.getFont().deriveFont(TEXT_SIZE));

    TEXT_LABEL.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT
        - IMAGE_HEIGHT);
    TEXT_LABEL.setLocation(0, IMAGE_HEIGHT);

    TEXT_LABEL.setBackground(TEXT_BACKGROUND_COLOR);
    TEXT_LABEL.setForeground(TEXT_COLOR);
    TEXT_LABEL.setOpaque(true);

    this.add(TEXT_LABEL);
  }

  public void setTextBackground(Color color) {
    TEXT_LABEL.setBackground(color);
  }
}
