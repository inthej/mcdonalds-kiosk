package dev.mcdonaldkiosk.page;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Class Role : 이미지와 텍스트로 구성된 버튼이다. 
 * 상단의 이미지와 하단의 텍스트 구성을 가지고 있는 버튼이다.
 *
 * 특징 : 
 * 1. 이미지는 지정한 크기에 맞게 화질이 보정되어 변환된 형태를 가지고 있다.
 */
public class ImageTextButton extends JButton {

	private static final int IMAGE_SIZE_WIDTH = KioskPage.PAGE_WIDTH * 4 / 15;
	private static final int IMAGE_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 15;

	private static final float FONT_SIZE = 15.0f; // float자료형 글자크기, int자료형 글자디자인
	private static final Color FONT_COLOR = Color.RED;
	private static final Color BACKGROUND_COLOR = Color.WHITE;

	public ImageTextButton() {
		initeImageTextButton();
	}

	public ImageTextButton(Action a) {
		super(a);
		initeImageTextButton();
	}

	public ImageTextButton(Icon icon) {
		super(icon);
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
		this.setBackground(BACKGROUND_COLOR);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
	}

	private void setResizedImg(ImageIcon icon) {
		setResizedImg(icon, IMAGE_SIZE_WIDTH, IMAGE_SIZE_HEIGHT);
	}

	public void setResizedImg(ImageIcon icon, int width, int height) {
		Image resizedImg = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon resizedImgIcon = new ImageIcon(resizedImg);

		this.setIcon(resizedImgIcon);
	}
	
	private static final long serialVersionUID = 5693028348740582531L;
}
