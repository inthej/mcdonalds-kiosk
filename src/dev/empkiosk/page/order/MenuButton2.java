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
import dev.empkiosk.page.LangCheck;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Create by kimjaehyeon 
 * Class Role : 메뉴들은 각각의 버튼으로 구성되어있다. 
 * 해당 메뉴버튼을 담당하는 클래스이다.
 */
public class MenuButton2 extends JButton {
		
	/* 버튼의 크기 */
	private static int BUTTON_WIDTH = MenuTablePanel.TABLE_WIDTH / 5;
	private static int BUTTON_HEIGHT = MenuTablePanel.TABLE_HEIGHT / 9;
	
	MenuButton2(String text, String imgPath, int price, int kCal) {
		
		
		this.setText("<html><center>" + text + "<br>" + (LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ")
				+ "<font color='red'>" + price + "</font>" + "<br>" + kCal + "Kcal" + "</center></html>");
		this.setIcon(ImageEdit.getResizeIcon(imgPath, BUTTON_WIDTH, BUTTON_HEIGHT));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.setBackground(Color.WHITE);
		this.setBorderPainted(false);

		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File file = new File("sound/beep.wav");
					FileInputStream fis = null;
					AudioStream as = null;
					fis = new FileInputStream(file);
					as = new AudioStream(fis);
					AudioPlayer.player.start(as);

				} catch (IOException ex) {
					ex.printStackTrace();
				}

				SelectedMenu.addOrder(price, 1, kCal);
				CartPanel.SELECTED_MENU.add(this.toString());
				CartPanel.J_LIST.setListData(CartPanel.SELECTED_MENU);

				// JScrollPane의 바를 최 하단으로맞춤
				CartPanel.scroll.getVerticalScrollBar().setValue(CartPanel.scroll.getVerticalScrollBar().getMaximum());
				
				CartPanel.cartTotalData.setText("<html>" + SelectedMenu.orderQuantity + "<br>" + SelectedMenu.orderAmount
						+ "<br>" + SelectedMenu.totalKCal + "</html>");
			}

			@Override
			public String toString() {
				return new StringBuilder().append(text).append(LangCheck.isKorean() ? "||가격 ₩" : "||Price ₩")
						.append(price).append("||").append(kCal).append("Kcal").toString();
			}
		});
	}
	
	private static final long serialVersionUID = 1806232326009833938L;
}
