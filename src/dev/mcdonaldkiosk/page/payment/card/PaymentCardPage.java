package dev.mcdonaldkiosk.page.payment.card;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.confirm.ConfirmPage;
import dev.mcdonaldkiosk.page.thank.ThankPage;
import dev.mcdonaldkiosk.util.ImageEdit;

/**
 * Created by kimjaehyeon on 2017. 5. 25 
 * Class Role : 카드 결제지불 페이지
 */
public class PaymentCardPage extends KioskPage {
	
	private static final long serialVersionUID = -823009228065966049L;

	private final int MID_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
	private final int MID_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 3 / 5;

	private final PaymentCardPanel PAYMENT_CARD_PANEL = new PaymentCardPanel();

	public PaymentCardPage() {
		initPage();
		initPaymentCardPanel();
		setListener();
	}

	private void initPage() {
		this.setBackgroundImg("image/bg_green.png");
		this.showBackButton();

		this.playSound(LangCheck.isKorean() ? "sound/card.wav" : "sound/card_eng.wav");
	}

	private void initPaymentCardPanel() {
		PAYMENT_CARD_PANEL.setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
		PAYMENT_CARD_PANEL.setLocation((MainFrame.FRAME_WIDTH - MID_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT / 4);

		this.add(PAYMENT_CARD_PANEL);
	}

	private void setListener() {
		BACK_BUTTON.addActionListener((args) -> MainFrame.attachPanel(new ConfirmPage()));

		PAYMENT_CARD_PANEL.getImageTextButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PaymentCardPage.this.playSound(LangCheck.isKorean() ? "sound/ing.wav" : "sound/ing_eng.wav");

				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} finally {
					MainFrame.attachPanel(new ThankPage());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				PAYMENT_CARD_PANEL.getImageLabel().setIcon(ImageEdit.getResizeIcon("image/loding.jpg",
						MainFrame.FRAME_WIDTH * 3 / 5, MainFrame.FRAME_HEIGHT * 2 / 5));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.WHITE);
			}
		});
	}
}
