package dev.empkiosk.page.order;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import dev.empkiosk.page.ImageEdit;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.LangCheck;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Create by kimjaehyeon 
 * Class Role : 메뉴들은 각각의 버튼으로 구성되어있다. 
 * 해당 메뉴버튼을 담당하는 클래스이다.
 */
public class MenuButton extends JButton {
	
	private static int BUTTON_WIDTH = KioskPage.PAGE_WIDTH / 5;
	private static int BUTTON_HEIGHT = KioskPage.PAGE_HEIGHT / 10;
	
	private static final File SOUND_FILE = new File("sound/beep.wav");
	
	private final MenuType MENU_TYPE;
	private final String IMG_PATH;
	private final String MENU_NAME;
	private final int PRICE;
	private final int K_CAL;
	
	MenuButton(MenuType menuType, String imgPath, String menuName, int price, int kCal) {
		this.MENU_TYPE = menuType;
		this.IMG_PATH = imgPath;
		this.MENU_NAME = menuName;
		this.PRICE = price;
		this.K_CAL = kCal;
		
		initMenuButton(createTitle());
		setListener();
	}
	
	private String createTitle() {
		return new StringBuilder().append("<html><center>").append(MENU_NAME).append("<br>")
		.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='red'>").append(PRICE).append("</font><br>")
		.append(K_CAL).append("KCal").append("</center></html>").toString();
	}
	
	private void initMenuButton(String title) {
		this.setIcon(ImageEdit.getResizeIcon(IMG_PATH, BUTTON_WIDTH, BUTTON_HEIGHT));
		this.setText(title);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.setBackground(Color.WHITE);
		this.setBorderPainted(false);
	}
	
	private void setListener() {
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * TODO
				 * 사운드
				 * 주문데이터 입력
				 * 화면갱신 & 스크롤 최하단
				 */
				
				playSound();
				

				SelectedMenu.addOrder(PRICE, 1, K_CAL);
				CartPanel.SELECTED_MENU.add(MenuButton.this.toString());
				CartPanel.J_LIST.setListData(CartPanel.SELECTED_MENU);

				// JScrollPane의 바를 최 하단으로맞춤
				CartPanel.scroll.getVerticalScrollBar().setValue(CartPanel.scroll.getVerticalScrollBar().getMaximum());
				
				CartPanel.cartTotalData.setText("<html>" + SelectedMenu.orderQuantity + "<br>" + SelectedMenu.orderAmount
						+ "<br>" + SelectedMenu.totalKCal + "</html>");
			}
		});
	}
	
	private void playSound() {
		try {
			final FileInputStream FIS = new FileInputStream(SOUND_FILE);
			final AudioStream AS = new AudioStream(FIS);
			AudioPlayer.player.start(AS);
		} catch (IOException ex) {
			ex.printStackTrace();
		} 
		
	}
	
	@Override
	public String toString() {
		final String REMOVE_TAG_NAME = MENU_NAME.replaceAll("<html><center>", "").replaceAll("<br>", " ").replaceAll("</center></html>", "");
		
		return new StringBuilder().append(REMOVE_TAG_NAME).append(" || ").
				append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append(PRICE).append(" || ")
				.append(K_CAL).append("KCal").toString();
	}
	
	private static final long serialVersionUID = 1806232326009833938L;
}
