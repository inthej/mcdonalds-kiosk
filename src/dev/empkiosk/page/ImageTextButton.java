package dev.empkiosk.page;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

/**
 * Class Role : 페이지에서 공통적으로 사용되는 이미지버튼이다.
 * 상단의 리사이징 된 이미지와 하단의 텍스트 구성을 가지고 있다.
 */
public class ImageTextButton extends JButton {

    private static final int IMAGE_SIZE_WIDTH = KioskPage.PAGE_WIDTH * 4 / 15;
    private static final int IMAGE_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 15;

    private static final float FONT_SIZE = 15.0f; // float가 글자크기, int는 글자디자인
    private static final Color FONT_COLOR = Color.RED;
    private static final Color BACKGROUND_COLOR = Color.WHITE;

    public ImageTextButton() {
        init();
    }

    public ImageTextButton(Action a) {
        super(a);
        init();
    }

    public ImageTextButton(Icon icon) {
        super(icon);
        init();
    }

    public ImageTextButton(String text, ImageIcon icon) {
        super(text, icon);
        init();
        setResizedImg(icon);
    }

    public ImageTextButton(String text) {
        super(text);
        init();
    }

    private void init() {
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

    private static final long serialVersionUID = -2796156858926907017L;
}
