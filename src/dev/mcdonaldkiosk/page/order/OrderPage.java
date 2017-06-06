package dev.mcdonaldkiosk.page.order;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.util.ImageEdit;

/**
 * Created by kimjaehyeon 
 * Class Role : 주문관련 페이지이다. 
 * 상단 이미지 라벨, 중간 스크롤이 사용된 메뉴탭, 하단 카트패널로 구성되어 있다.
 */
public class OrderPage extends KioskPage {

	private int TOP_HEIGHT = MainFrame.FRAME_HEIGHT / 5;
	private int CENTER_HEIGHT = MainFrame.FRAME_HEIGHT * 3 / 5;
	private int BOTTOM_HEIGHT = MainFrame.FRAME_HEIGHT / 5;

	private final JLabel ImageLabel = new JLabel(
			ImageEdit.getResizeIcon("image/banner_top.jpg", MainFrame.FRAME_WIDTH, TOP_HEIGHT));
	private final MenuTab MENU_TAB = new MenuTab();
	private final JScrollPane SCROLL = new JScrollPane();
	private final MyOrderPanel CART_PANEL = new MyOrderPanel();

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
		this.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
	}

	private void initImageLabel() {
		ImageLabel.setSize(MainFrame.FRAME_WIDTH, TOP_HEIGHT);
		ImageLabel.setLocation(0, 0);
		this.add(ImageLabel);
	}

	private void initMenuTab() {
		MENU_TAB.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
		MENU_TAB.setLocation(0, ImageLabel.getHeight());
	}

	private void initScroll() {
		SCROLL.setSize(MainFrame.FRAME_WIDTH, CENTER_HEIGHT);
		SCROLL.setLocation(0, ImageLabel.getHeight());
		SCROLL.getVerticalScrollBar().setUnitIncrement(18); // 스크롤 속도
		SCROLL.setViewportView(MENU_TAB);

		this.add(SCROLL);
	}

	private void initCartPanel() {
		CART_PANEL.setSize(MainFrame.FRAME_WIDTH, BOTTOM_HEIGHT);
		CART_PANEL.setLocation(0, TOP_HEIGHT + CENTER_HEIGHT);
		CART_PANEL.setOpaque(true);
		this.add(CART_PANEL);
	}

	private void setLayout() {
		BACK_BUTTON.addActionListener((e) -> {
			MainFrame.attachPanel(new PaymentPlacePage());
			MyOrderPanel.emptyOrder();
		});
	}
	
	private static final long serialVersionUID = 1341403300325678930L;
}
