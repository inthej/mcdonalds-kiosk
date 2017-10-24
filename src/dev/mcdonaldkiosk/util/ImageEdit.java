package dev.mcdonaldkiosk.util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Class Role : 이미지 편집(리사이징)을 담당한다.
 */
public class ImageEdit {

  public static ImageIcon getResizeIcon(String path, int width, int height) {
    ImageIcon imgIcon = new ImageIcon(path);

    return getResizeIcon(imgIcon, width, height);
  }

  public static ImageIcon getResizeIcon(ImageIcon imgIcon, int width, int height) {
    Image resizedImg = imgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

    return new ImageIcon(resizedImg);
  }
  
  private ImageEdit() {
    throw new AssertionError();
  }
}