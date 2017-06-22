package dev.mcdonaldkiosk.page.confirm;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Class Role : ConfirmPage에서 사용되는 디자인이 적용된 버튼이다.
 * 버튼의 배경컬러와 Rollover 효과가 적용되어 있다.
 *
 * @authro Jaehyeon Kim
 * @see ConfirmPage
 */
class ConfirmButton extends JButton {

  private final Color backgroundColor = Color.WHITE;

  private final Color baseColor = Color.WHITE;
  private final Color hoverColor = Color.ORANGE;

  ConfirmButton(final String text) {
    super(text);

    initBackground();
    setListener();
  }

  private void initBackground() {
    this.setBackground(backgroundColor);
  }

  private void setListener() {
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(final MouseEvent e) {
        ConfirmButton.this.setBackground(hoverColor);
      }

      @Override
      public void mouseExited(final MouseEvent e) {
        ConfirmButton.this.setBackground(baseColor);
      }
    });
  }
}
