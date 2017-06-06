package dev.mcdonaldkiosk.page.confirm;

import java.awt.Color;
import java.awt.Component;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.eatplace.EatPlace;
import dev.mcdonaldkiosk.page.menu.OrderDataList;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.OrderPlace;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPage;
import dev.mcdonaldkiosk.page.payment.place.PayPlace;
import dev.mcdonaldkiosk.page.thank.ThankPage;

/**
 * Create by kimjaehyeon on 2017. 5. 25
 * Class Role : 주문확인 페이지
 */
public class ConfirmPage extends KioskPage {

	/* 중간패널 사이즈 */
	private final int MIDDLE_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
	private final int MIDDLE_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 5;

	// 가운데 패널
	private final KioskGuidePanel ORDER_CONFIRM_GUIDE_PANEL = new KioskGuidePanel(
			LangCheck.isKorean() ? "주문을 확인해주세요" : "IS THIS ORDER CORRECT?", 0, 1);

	private OrderDataList orderDataList = new OrderDataList();
	private final OrderTotalDataPanel ORDER_TOTAL_LIST_PANEL = new OrderTotalDataPanel(EatPlace.EAT_IN, orderDataList);

	// 하단 패널
	private final KioskGuidePanel YES_NO_SELECT_PANEL = new KioskGuidePanel(0, 2);
	private final ConfirmButton NO_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "취소" : "NO");
	private final ConfirmButton YES_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "확인" : "YES");

	public ConfirmPage(OrderDataList orderDataList) {
		this.orderDataList = orderDataList;

		initPage();
		initOrderTotalListPanel();
		initYesNoSelectPanel();
		setListener();
	}

	public ConfirmPage() {
		initPage();
		initOrderTotalListPanel();
		initYesNoSelectPanel();
		setListener();
	}

	private void initPage() {
		this.setBackgroundImg("image/bg_green.png");

		this.playSound(LangCheck.isKorean() ? "sound/check.wav" : "sound/check_eng.wav");
	}

	private void initOrderTotalListPanel() {
		ORDER_CONFIRM_GUIDE_PANEL.setTitleColor(Color.GREEN);
		ORDER_CONFIRM_GUIDE_PANEL.addItem(ORDER_TOTAL_LIST_PANEL);

		Component orderConfirmGuideComp = ORDER_CONFIRM_GUIDE_PANEL.getPanel();
		orderConfirmGuideComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT);
		orderConfirmGuideComp.setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT / 4);

		this.add(ORDER_CONFIRM_GUIDE_PANEL.getPanel());
	}

	private void initYesNoSelectPanel() {
		YES_NO_SELECT_PANEL.addItem(NO_BUTTON, YES_BUTTON);

		final int PANEL_WIDTH = MIDDLE_PANEL_WIDTH / 2;
		Component yesNoSelectComp = YES_NO_SELECT_PANEL.getPanel();
		yesNoSelectComp.setSize(PANEL_WIDTH, MIDDLE_PANEL_HEIGHT / 5);
		yesNoSelectComp.setLocation((MainFrame.FRAME_WIDTH - PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT * 3 / 4);

		this.add(yesNoSelectComp);
	}

	// set 설정하는 느낌
	private void setListener() {
		this.NO_BUTTON.addActionListener((args) -> MainFrame.attachPanel(new MenuPage())); // 한줄짜리는 { } 지울수 있음.

		this.YES_BUTTON.addActionListener((args) -> {
			if (OrderPlace.getInstance().getPayPlace() == PayPlace.COUNTER.toString()) {
				MainFrame.attachPanel(new ThankPage());

			} else if (OrderPlace.getInstance().getPayPlace() == PayPlace.KIOSK.toString()) {
				MainFrame.attachPanel(new PaymentCardPage());
			}
		});
	}
}
