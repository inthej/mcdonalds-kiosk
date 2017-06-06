package dev.mcdonaldkiosk.page.payment.place;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.eatplace.EatPlacePage;
import dev.mcdonaldkiosk.page.order.OrderPage;
import dev.mcdonaldkiosk.page.order.OrderPlace;

/**
 * Created by kimjaehyeon on 2017. 5. 20 
 * Class Role : 결제장소 선택 페이지
 */
public class PaymentPlacePage extends KioskPage {

	private final int MID_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
	private final int MID_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 5;

	private final KioskGuidePanel PAYMENT_SELECT_PANEL = new KioskGuidePanel(
			LangCheck.isKorean() ? "어디에서 지불하시겠습니까?" : "WHERE DO YOU WANT TO PAY?", 0, 2);

	private final ImageTextButton COUNTER_BUTTON = new ImageTextButton();
	private final ImageTextButton CARD_BUTTON = new ImageTextButton();

	public PaymentPlacePage() {
		initPage();
		initPaymentSelectPanel();
		setListeners();
	}

	private void initPage() {
		this.setBackgroundImg("image/bg_green.png");
		this.showBackButton();

		this.playSound(LangCheck.isKorean() ? "sound/pay.wav" : "sound/pay_eng.wav");
	}

	private void initPaymentSelectPanel() {
		initKioskButton();
		PAYMENT_SELECT_PANEL.addItem(COUNTER_BUTTON, CARD_BUTTON);
		PAYMENT_SELECT_PANEL.getPanel().setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
		PAYMENT_SELECT_PANEL.getPanel().setLocation((MainFrame.FRAME_WIDTH - MID_PANEL_WIDTH) / 2,
				MainFrame.FRAME_HEIGHT / 4);

		this.add(PAYMENT_SELECT_PANEL.getPanel());
	}

	private void initKioskButton() {
		final int BUTTON_WIDTH = MID_PANEL_WIDTH / 3;
		final int BUTTON_HEIGHT = MID_PANEL_HEIGHT / 2;

		COUNTER_BUTTON.setText(LangCheck.isKorean() ? "카운터에서 결제" : "PAYMENT AT THE COUNTER");
		COUNTER_BUTTON.setResizedImg(new ImageIcon("image/counter.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);

		CARD_BUTTON.setText(
				"<html><center>" + (LangCheck.isKorean() ? "바로 결제<br>(카드 가능)" : "DIRECT PAYMENT IN KIOSK<br>(CARD)")
						+ "</center></html>");
		CARD_BUTTON.setResizedImg(new ImageIcon("image/kiosk.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);
	}

	private void setListeners() {
		this.BACK_BUTTON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.attachPanel(new EatPlacePage());
			}
		});

		COUNTER_BUTTON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderPlace.getInstance().setPayPlace(PayPlace.COUNTER);
				MainFrame.attachPanel(new OrderPage());
			}
		});

		CARD_BUTTON.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrderPlace.getInstance().setPayPlace(PayPlace.KIOSK);
				MainFrame.attachPanel(new OrderPage());
			}
		});
	}
}
