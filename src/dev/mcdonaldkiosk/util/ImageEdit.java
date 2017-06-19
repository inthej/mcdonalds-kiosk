package dev.mcdonaldkiosk.util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Create by kimjaehyeon on 2017. 5. 19
 * Class Role : 이미지 편집을 담당한다.
 *
 * 기능- 1. 이미지아이콘을 리사이징 한다.
 */
public class ImageEdit {

  // 이미지 아이콘을 리사이징 한다.
  public static ImageIcon getResizeIcon(String path, int width, int height) {
    ImageIcon imgIcon = new ImageIcon(path);

    return getResizeIcon(imgIcon, width, height);
  }

  public static ImageIcon getResizeIcon(ImageIcon imgIcon, int width, int height) {
    Image resizedImg = imgIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

    return new ImageIcon(resizedImg);
  }
}