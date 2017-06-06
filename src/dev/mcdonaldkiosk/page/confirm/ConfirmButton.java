package dev.mcdonaldkiosk.page.confirm;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 * Created by kimjaehyeon 
 * Class Role : ConfirmPage에서 사용되는 버튼의 rollover 효과를 담당한다.
 */
class ConfirmButton extends JButton {

	private static final long serialVersionUID = -8917948048223184209L;

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
}
