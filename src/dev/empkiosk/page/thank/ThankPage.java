package dev.empkiosk.page.thank;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextPanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.order.CartPanel;
import dev.empkiosk.page.order.OrderPlace;
import dev.empkiosk.page.order.SelectedMenuList;
import dev.empkiosk.page.payment.place.PayPlace;
import dev.empkiosk.page.welcome.WelcomePage;

/**
 * Created by kimjaehyeon 
 * Class Role : 주문 완료 안내 페이지
 */
public class ThankPage extends KioskPage {

	private final ImageTextPanel THANK_IMG_TEXT_PANEL = new ImageTextPanel(new ImageIcon("image/bg_info3.jpg"),
			LangCheck.isKorean() ? "주문이 완료되었습니다." : "YOUR ORDER IS COMPLETE");

	public ThankPage() {
		initPage();
		initThankImgTextPanel();
		initOrderData();
		setListener();
	}

	private void initPage() {
		this.showBackgroundImg(false);
		this.showBackButton(false);

		String orderPlace = OrderPlace.getInstance().getPayPlace();
		if (orderPlace== PayPlace.COUNTER.toString()) {
			KioskVoice.playSound(LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav");
		} else if (orderPlace == PayPlace.KIOSK.toString()) {
			KioskVoice.playSound(LangCheck.isKorean() ? "sound/thank.wav" : "sound/thank_eng.wav");
		}
	}
	
	private void initThankImgTextPanel() {
		THANK_IMG_TEXT_PANEL.setTextBackground(Color.BLUE);
		
		Component thankImgTextPanel = THANK_IMG_TEXT_PANEL.getPanel();
		thankImgTextPanel.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
		thankImgTextPanel.setLocation(0, 0);
		
		this.add(thankImgTextPanel);
	}

	private void initOrderData() {
		OrderPlace.getInstance().init();
		SelectedMenuList.getInstance().empty();
		CartPanel.emptyCart();
	}

	private void setListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainFrame.attachPanel(new WelcomePage());
			}
		});
	}

	private static final long serialVersionUID = 1859203669102728390L;
}
