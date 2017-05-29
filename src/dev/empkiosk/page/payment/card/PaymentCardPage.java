package dev.empkiosk.page.payment.card;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageEdit;
import dev.empkiosk.page.ImageTextButton;
import dev.empkiosk.page.KioskGuidePanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.confirm.ConfirmPage;
import dev.empkiosk.page.order.CartPanel;
import dev.empkiosk.page.order.SelectedMenu;
import dev.empkiosk.page.thank.ThankPage;

/**
 * Created by kimjaehyeon on 2017. 5. 25 
 * Class Role : 카드 결제지불 페이지
 */
public class PaymentCardPage extends KioskPage {
	
	private final int MID_PANEL_WIDTH = KioskPage.PAGE_WIDTH * 4 / 5;
	private final int MID_PANEL_HEIGHT = KioskPage.PAGE_HEIGHT * 3 / 5;
	
	private final PaymentCardPanel PAYMENT_CARD_PANEL = new PaymentCardPanel();

	public PaymentCardPage() {
		initPaymentCardPage();
		initPaymentCardPanel();
		setListener();
	}
	
	private void initPaymentCardPage() {
		this.setBackgroundImg("image/bg_green.png");
		this.showBackgroundImg(true);
		this.showBackButton(true);

		KioskVoice.playSound(LangCheck.isKorean() ? "sound/card.wav" : "sound/card_eng.wav");
	}
	
	private void initPaymentCardPanel() {
		PAYMENT_CARD_PANEL.setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
		PAYMENT_CARD_PANEL.setLocation((KioskPage.PAGE_WIDTH - MID_PANEL_WIDTH) / 2, KioskPage.PAGE_HEIGHT / 4);
		
		this.add(PAYMENT_CARD_PANEL);
	}
	
	private void setListener() {
		BACK_BUTTON.addActionListener((args) -> MainFrame.attachPanel(new ConfirmPage()));
		
		PAYMENT_CARD_PANEL.getImageTextButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				KioskVoice.playSound(LangCheck.isKorean() ? "sound/ing.wav" : "sound/ing_eng.wav");
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					MainFrame.attachPanel(new ThankPage());
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				PAYMENT_CARD_PANEL.getImageLabel().setIcon(ImageEdit.getResizeIcon("image/loding.jpg",
						PaymentCardPanel.LABEL_IMG_SIZE_WIDTH, PaymentCardPanel.LABEL_IMG_SIZE_HEIGHT));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.ORANGE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				PAYMENT_CARD_PANEL.getImageTextButton().setBackground(Color.WHITE);
			}
		});
	}

	private static final long serialVersionUID = -8349746229128895984L;
}