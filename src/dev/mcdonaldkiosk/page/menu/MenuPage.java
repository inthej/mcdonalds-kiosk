package dev.mcdonaldkiosk.page.menu;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.menu.order.MyOrderPanel;
import dev.mcdonaldkiosk.page.menu.order.OrderDataModel;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;

/**
 * Created by kimjaehyeon 
 * Class Role : 메뉴관련 페이지이다. 
 * 상단 이미지 라벨, 중간 스크롤이 사용된 메뉴탭, 하단 MyOrder 패널로 구성되어 있다.
 */
public class MenuPage extends KioskPage {
	
	private OrderDataModel orderDataModel = new OrderDataModel();

	private final JLabel IMAGE_LABEL = new JLabel();
	private final JScrollPane SCROLL = new JScrollPane();
	private final MenuTabbedPane MENU_TABBED_PANE = new MenuTabbedPane(orderDataModel);
	private final MyOrderPanel CART_PANEL = new MyOrderPanel(orderDataModel);

	public MenuPage() {
		initPage();
		initImageLabel();
		initScroll();
		setLayout();
	}

	private void initPage() {
		this.setLayout(new BorderLayout());
		this.add(IMAGE_LABEL, BorderLayout.NORTH);
		this.add(SCROLL, BorderLayout.CENTER);
		this.add(CART_PANEL, BorderLayout.SOUTH);
		
		this.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
	}

	private void initImageLabel() {
		IMAGE_LABEL.setIcon(this.imageEdit.getResizeIcon("image/banner_top.jpg", 
				MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT / 5));
		IMAGE_LABEL.add(BACK_BUTTON);
	}

	private void initScroll() {
		SCROLL.getVerticalScrollBar().setUnitIncrement(20); // 스크롤 속도
		SCROLL.setViewportView(MENU_TABBED_PANE);
	}

	private void setLayout() {
		this.BACK_BUTTON.addActionListener((e) -> {
			MainFrame.attachPanel(new PaymentPlacePage());
			// TODO : 주문데이터 비우기
//			MyOrderPanel.emptyOrder();
		});
	}
}
