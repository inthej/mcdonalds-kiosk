package dev.empkiosk.page.payment.card;

import dev.empkiosk.page.ImageEdit;
import dev.empkiosk.page.ImageTextButton;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.TitleLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

class PaymentCardPanel extends JPanel {

    private static final TitleLabel TITLE_LABEL = new TitleLabel();
    private static final JLabel IMAGE_LABEL = new JLabel();
    private static final ImageTextButton IMAGE_TEXT_BUTTON = new ImageTextButton();

    static final int LABEL_IMG_SIZE_WIDTH = KioskPage.PAGE_WIDTH * 3 / 5;
    static final int LABEL_IMG_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 5;

    private static final int BUTTON_IMG_SIZE_WIDTH = KioskPage.PAGE_WIDTH * 4 / 25;
    private static final int BUTTON_IMG_SIZE_HEIGHT = KioskPage.PAGE_HEIGHT * 3 / 25;

    PaymentCardPanel() {
        initPayProgressPanel();
        initTitleLabel();
        initImageLabel();
        initImageTextButton();
    }

    private void initPayProgressPanel() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
    }

    private void initTitleLabel() {
        TITLE_LABEL.setText(LangCheck.isKorean() ? "카드를 넣어주세요" : "INSERT YOUR CARD NOW");
        TITLE_LABEL.setHorizontalAlignment(JLabel.CENTER);

        this.add(TITLE_LABEL, BorderLayout.NORTH);
    }

    private void initImageLabel() {
        IMAGE_LABEL.setIcon(ImageEdit
                .getResizeIcon("image/insert_card.jpg", LABEL_IMG_SIZE_WIDTH, LABEL_IMG_SIZE_HEIGHT));
        IMAGE_LABEL.setHorizontalAlignment(JLabel.CENTER);
        IMAGE_LABEL.setOpaque(true);
        IMAGE_LABEL.setBackground(Color.WHITE);

        this.add(IMAGE_LABEL, BorderLayout.CENTER);
    }

    private void initImageTextButton() {
        IMAGE_TEXT_BUTTON.setText(LangCheck.isKorean() ? "카드넣기" : "INSERT CARD");
        IMAGE_TEXT_BUTTON.setHorizontalTextPosition(JLabel.CENTER);
        IMAGE_TEXT_BUTTON.setForeground(Color.BLACK);
        IMAGE_TEXT_BUTTON.setResizedImg(new ImageIcon("image/card.png"), BUTTON_IMG_SIZE_WIDTH,
                BUTTON_IMG_SIZE_HEIGHT);

        this.add(IMAGE_TEXT_BUTTON, BorderLayout.SOUTH);
    }

    JLabel getImageLabel() {
        return IMAGE_LABEL;
    }

    ImageTextButton getImageTextButton() {
        return IMAGE_TEXT_BUTTON;
    }

    private static final long serialVersionUID = 6172961471501167176L;
}
