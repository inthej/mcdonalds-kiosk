package dev.empkiosk.page.confirm;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

class ConfirmButton extends JButton {

  ConfirmButton(String text) {
    super(text);
    this.setBackground(Color.WHITE);

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        ConfirmButton.this.setBackground(Color.ORANGE);
      }

      @Override
      public void mouseExited(MouseEvent e) {
        ConfirmButton.this.setBackground(Color.WHITE);
      }
    });
  }

  private static final long serialVersionUID = -6286699426610259517L;
}
