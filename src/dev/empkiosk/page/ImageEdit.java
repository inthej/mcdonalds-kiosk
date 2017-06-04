package dev.empkiosk.page;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Create by kimjaehyeon on 2017. 5. 19 
 * Class Role : 이미지 편집을 담당한다.
 * <p>
 * 기능- 1. 이미지아이콘을 리사이징 한다.
 */

/* 이런류의 헬퍼 클래스는 util 패키지로 옮기는게 적절하다. 
 * 소스코드 마다 이미지 리사이징하는 코드들이 재각각 퍼져있다. (캡슐화 떨어짐)
 * 한데 모아야 합니다.
 * */
@Deprecated
public class ImageEdit {

	// 이미지 아이콘을 리사이징 한다.
	public static ImageIcon getResizeIcon(String path, final int WIDTH, final int HEIGHT) {
		ImageIcon imageIcon = new ImageIcon(path);
		Image image = imageIcon.getImage().getScaledInstance(WIDTH, HEIGHT, Image.SCALE_SMOOTH);

		return new ImageIcon(image);
	}
}