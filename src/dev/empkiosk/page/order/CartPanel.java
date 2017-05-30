package dev.empkiosk.page.order;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.confirm.ConfirmPage;

/**
 * Created by kimjaehyeon 
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class CartPanel extends JPanel {
	
	private static final CartTitlePanel CART_TITLE_PANEL = new CartTitlePanel();
	private static final CartScrollPane SELECTED_MENU_SCROLL = new CartScrollPane();
	private static final CartConfirmPanel CART_DATA_CONFIRM_PANEL = new CartConfirmPanel();
	
	// 선택 메뉴 리스트
	private final Vector<String> SELECTED_MENU_LIST = new Vector<>();

	public static JScrollPane scroll = new JScrollPane();
	private Border border = BorderFactory.createTitledBorder(LangCheck.isKorean() ? "선택메뉴" : "Select Menu");
	public static final JList<String> J_LIST = new JList<>();
	public static final Vector<String> SELECTED_MENU = new Vector<>();

	public CartPanel() {
		// 초기화
		this.setLayout(null);

		initTopPanel();

		initBottomPanel();

		setListener();

		J_LIST.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 2 + OrderPage.BOTTOM_HEIGHT / 4 / 2);
		J_LIST.setLocation(0, OrderPage.BOTTOM_HEIGHT / 4 - OrderPage.BOTTOM_HEIGHT / 4 / 2);
		J_LIST.setListData(SELECTED_MENU);

		scroll.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 2 + OrderPage.BOTTOM_HEIGHT / 4 / 2);
		scroll.setLocation(0, OrderPage.BOTTOM_HEIGHT / 4 - OrderPage.BOTTOM_HEIGHT / 4 / 2);
		scroll.setViewportView(J_LIST);
		scroll.setBorder(border); // 경계 설정
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로바정책

		this.add(scroll);
	}

	private void initTopPanel() {
		CART_TITLE_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 8);
		CART_TITLE_PANEL.setLocation(0, 0);

		this.add(CART_TITLE_PANEL);
	}

	private void initBottomPanel() {
		CART_DATA_CONFIRM_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 4);
		CART_DATA_CONFIRM_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT * 3 / 4);

		this.add(CART_DATA_CONFIRM_PANEL);
	}

	private void setListener() {
		CART_DATA_CONFIRM_PANEL.getCancleButton().addActionListener((args) -> {
			SelectedMenuList.getInstance().empty();
			emptyCart();
		});

		CART_DATA_CONFIRM_PANEL.getPaymentButton().addActionListener((args) -> {
			if (CartPanel.SELECTED_MENU.size() == 0) {
				KioskVoice.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
			} else {
				MainFrame.attachPanel(new ConfirmPage());
			}
		});
	}
	
	// 메뉴넣기
	public void addMenu(String menu) {
		SELECTED_MENU_LIST.add(menu);
	}

	// 카드비우기
	public static void emptyCart() {
		SELECTED_MENU.clear();
		J_LIST.setListData(SELECTED_MENU);
		CART_DATA_CONFIRM_PANEL.resetDataLabel();
	}

	private static final long serialVersionUID = -6024864297025960463L;
}
