package dev.empkiosk.page.order;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.confirm.ConfirmPage;
import dev.empkiosk.page.KioskVoice;

/**
 * Created by kimjaehyeon 
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class CartPanel extends JPanel {

	private static final CartTopPanel TOP_PANEL = new CartTopPanel();

	private Border border = BorderFactory.createTitledBorder(LangCheck.isKorean() ? "선택메뉴" : "Select Menu");
	public static JScrollPane scroll = new JScrollPane();
	public static final JList<String> J_LIST = new JList<>();
	public static final Vector<String> SELECTED_MENU = new Vector<>();

	public static JLabel cartTotalData = new JLabel("<html>" + SelectedMenu.orderQuantity + "<br>"
			+ SelectedMenu.orderAmount + "<br>" + SelectedMenu.totalKCal + "</html>", JLabel.CENTER);

	private final JPanel BOTTOM_PANEL = new JPanel();

	public CartPanel() {
		// 초기화
		this.setLayout(null);
		
		initTopPanel();
		
		BOTTOM_PANEL.setLayout(new GridLayout(0, 4));
		BOTTOM_PANEL.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 4);
		BOTTOM_PANEL.setOpaque(true);
		BOTTOM_PANEL.setLocation(0, OrderPage.BOTTOM_HEIGHT * 3 / 4);
		BOTTOM_PANEL.setBackground(Color.WHITE);
		
		
		J_LIST.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 2 + OrderPage.BOTTOM_HEIGHT / 4 / 2);
		J_LIST.setLocation(0, OrderPage.BOTTOM_HEIGHT / 4 - OrderPage.BOTTOM_HEIGHT / 4 / 2);
		J_LIST.setListData(SELECTED_MENU);
		
		
		
		scroll.setSize(KioskPage.PAGE_WIDTH, OrderPage.BOTTOM_HEIGHT / 2 + OrderPage.BOTTOM_HEIGHT / 4 / 2);
		scroll.setLocation(0, OrderPage.BOTTOM_HEIGHT / 4 - OrderPage.BOTTOM_HEIGHT / 4 / 2);
		scroll.setViewportView(J_LIST);
		scroll.setBorder(border); // 경계 설정
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로바정책

		// 컬러
		
		// 하위컴포넌트
		JLabel menuLabel = new JLabel(LangCheck.isKorean() ? "메뉴" : "MENU", JLabel.CENTER);
		JLabel amountLabel = new JLabel(LangCheck.isKorean() ? "수량" : "QUANTITY", JLabel.CENTER);
		JLabel priceLabel = new JLabel(LangCheck.isKorean() ? "가격" : "PRICE", JLabel.CENTER);
		JLabel cartTotal = new JLabel(LangCheck.isKorean() ? "<html>주문수량<br>주문금액<br>총 칼로리</html>"
				: "<html>Order quantity<br>Order amount<br>Total calories</html>", JLabel.CENTER);
		JButton cancleButton = new JButton(LangCheck.isKorean() ? "주문취소" : "CANCEL ORDER");
		JButton paymentButton = new JButton(LangCheck.isKorean() ? "주문진행" : "COMPLETE ORDER");

		// 하위컴포넌트 컬러
		menuLabel.setForeground(Color.WHITE);
		amountLabel.setForeground(Color.WHITE);
		priceLabel.setForeground(Color.WHITE);
		cancleButton.setBackground(Color.GRAY);
		paymentButton.setBackground(Color.ORANGE);

	
		BOTTOM_PANEL.add(cartTotal);
		BOTTOM_PANEL.add(cartTotalData);
		BOTTOM_PANEL.add(cancleButton);
		BOTTOM_PANEL.add(paymentButton);

		

		this.add(TOP_PANEL);
		this.add(BOTTOM_PANEL);
		this.add(scroll);

		cancleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SelectedMenu.init();
				initCart();
			}
		});

		paymentButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (CartPanel.SELECTED_MENU.size() == 0) {
					KioskVoice.playSound(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");
				} else {
					MainFrame.attachPanel(new ConfirmPage());
				}
			}
		});
	}

	private void initTopPanel() {
		TOP_PANEL.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT / 40);
		TOP_PANEL.setLocation(0, 0);
	}

	public static void initCart() {
		SELECTED_MENU.clear();
		J_LIST.setListData(SELECTED_MENU);
		cartTotalData.setText("<html>" + SelectedMenu.orderQuantity + "<br>" + SelectedMenu.orderAmount + "<br>"
				+ SelectedMenu.totalKCal + "</html>");
	}

	private static final long serialVersionUID = -6024864297025960463L;
}
