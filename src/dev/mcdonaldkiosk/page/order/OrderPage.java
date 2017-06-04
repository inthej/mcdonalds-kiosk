package dev.mcdonaldkiosk.page.order;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.edit.ImageEdit;
import dev.mcdonaldkiosk.util.KioskVoice;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 * Created by kimjaehyeon 
 * Class Role : 주문관련 페이지이다. 
 * 상단 이미지 라벨, 중간 스크롤이 사용된 메뉴탭, 하단 카트패널로 구성되어 있다.
 */
public class OrderPage extends KioskPage {

	static int TOP_HEIGHT = KioskPage.PAGE_HEIGHT / 5;
	static int CENTER_HEIGHT = KioskPage.PAGE_HEIGHT * 3 / 5;
	static int BOTTOM_HEIGHT = KioskPage.PAGE_HEIGHT / 5;

	private final JLabel ImageLabel = new JLabel(
			ImageEdit.getResizeIcon("image/banner_top.jpg", KioskPage.PAGE_WIDTH, TOP_HEIGHT));
	private final MenuTab MENU_TAB = new MenuTab();
	private final JScrollPane SCROLL = new JScrollPane();
	private final CartPanel CART_PANEL = new CartPanel();

	public OrderPage() {
		initPage();
		initImageLabel();
		initMenuTab();
		initScroll();
		initCartPanel();

		setLayout();
	}

	private void initPage() {
		this.setLayout(null);
		this.setComponentZOrder(BACK_BUTTON, 0);
		KioskVoice.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
	}

	private void initImageLabel() {
		ImageLabel.setSize(KioskPage.PAGE_WIDTH, TOP_HEIGHT);
		ImageLabel.setLocation(0, 0);
		this.add(ImageLabel);
	}

	private void initMenuTab() {
		MENU_TAB.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
		MENU_TAB.setLocation(0, ImageLabel.getHeight());
	}

	private void initScroll() {
		SCROLL.setSize(KioskPage.PAGE_WIDTH, CENTER_HEIGHT);
		SCROLL.setLocation(0, ImageLabel.getHeight());
		SCROLL.getVerticalScrollBar().setUnitIncrement(18); // 스크롤 속도
		SCROLL.setViewportView(MENU_TAB);

		this.add(SCROLL);
	}

	private void initCartPanel() {
		CART_PANEL.setSize(KioskPage.PAGE_WIDTH, BOTTOM_HEIGHT);
		CART_PANEL.setLocation(0, TOP_HEIGHT + CENTER_HEIGHT);
		CART_PANEL.setOpaque(true);
		this.add(CART_PANEL);
	}

	private void setLayout() {
		BACK_BUTTON.addActionListener((e) -> {
			MainFrame.attachPanel(new PaymentPlacePage());
			CartPanel.emptyOrder();
		});
	}
	
	private static final long serialVersionUID = 1341403300325678930L;
}
