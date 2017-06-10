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

	private final JLabel IMAGE_LABEL = new JLabel();
	private final JScrollPane SCROLL = new JScrollPane();
	private final MenuTabbedPane MENU_TABBED_PANE;
	private final MyOrderPanel MY_ORDER_PANEL;
	
	private final OrderDataModel ORDER_DATA_MODEL;

	public MenuPage() {
		ORDER_DATA_MODEL = new OrderDataModel(this);
		MENU_TABBED_PANE = new MenuTabbedPane(ORDER_DATA_MODEL);
		MY_ORDER_PANEL = new MyOrderPanel(ORDER_DATA_MODEL);
		
		initPage();
		initImageLabel();
		initScroll();
		setLayout();
	}
	
	public MenuPage(OrderDataModel orderDataModel) {
		ORDER_DATA_MODEL = orderDataModel;
		MENU_TABBED_PANE = new MenuTabbedPane(orderDataModel);
		MY_ORDER_PANEL = new MyOrderPanel(orderDataModel);
		
		initPage();
		initImageLabel();
		initScroll();
		setLayout();
		
		reflesh();
	}

	private void initPage() {
		this.setLayout(new BorderLayout());
		this.add(IMAGE_LABEL, BorderLayout.NORTH);
		this.add(SCROLL, BorderLayout.CENTER);
		this.add(MY_ORDER_PANEL, BorderLayout.SOUTH);
		
		this.currentPage = new MenuPageKioskPageLoader();
		this.currentPage.playLoadPageSound();
	}

	private void initImageLabel() {
		IMAGE_LABEL.setIcon(this.imageEdit.getResizeIcon("image/banner_top.jpg", 
				MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT / 5));
		IMAGE_LABEL.add(BACK_BUTTON);
	}

	private void initScroll() {
		SCROLL.getVerticalScrollBar().setUnitIncrement(10); // 스크롤 속도 (세로)
		SCROLL.getHorizontalScrollBar().setUnitIncrement(10); // 가로 스크롤 (가로)
		SCROLL.setViewportView(MENU_TABBED_PANE);
	}

	private void setLayout() {
		this.BACK_BUTTON.addActionListener((e) -> {
			ORDER_DATA_MODEL.clear();
			currentPage.loadPreviousPage();
		});
	}
	
	public void reflesh() {
		MY_ORDER_PANEL.reflesh();
	}
}
