package dev.mcdonaldkiosk.page.payment.card;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.TitleLabel;
import dev.mcdonaldkiosk.util.Display;
import dev.mcdonaldkiosk.util.ImageEdit;

class PaymentCardPanel extends JPanel {

  private final TitleLabel TITLE_LABEL = new TitleLabel();
  private final JLabel IMAGE_LABEL = new JLabel();
  private final ImageTextButton IMAGE_TEXT_BUTTON = new ImageTextButton();

  private static final int BUTTON_IMG_SIZE_WIDTH = Display.WINDOWS_HALF_WIDTH * 4 / 25;
  private static final int BUTTON_IMG_SIZE_HEIGHT = Display.WINDOWS_AVALIABLE_HEIGHT * 3 / 25;

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
    IMAGE_LABEL
        .setIcon(ImageEdit.getResizeIcon("image/insert_card.jpg", Display.WINDOWS_HALF_WIDTH * 3 / 5,
            Display.WINDOWS_AVALIABLE_HEIGHT * 2 / 5));
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
}
