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
import dev.empkiosk.util.KioskAudioPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * Create by kimjaehyeon 
 * Class Role : 메뉴들은 각각의 버튼으로 구성되어있다. 
 * 해당 메뉴버튼을 담당하는 클래스이다.
 */
public class MenuButton extends JButton {
	private static final int BUTTON_WIDTH = KioskPage.PAGE_WIDTH / 5;
	private static final int BUTTON_HEIGHT = KioskPage.PAGE_HEIGHT / 10;
	
	/**
	 *  MenuButton가 File 객체를 가져야 한다는걸 표현 하면 안된다.
	 *  MenuButton은 단순히 AudioPlay를 하고 싶은거지,
	 *  AudioPlay가 File 객체가 필요하다는걸 알 필요가 없다.
	 *  
	 * @see dev.empkiosk.page.order.MenuButton#clickBGMPlayer
	 * @see dev.empkiosk.util.KioskAudioPlayer 
	 */
	@Deprecated
	private static final File SOUND_FILE = new File("sound/beep.wav");
	static final String PRICE_FONT_TAG_COLOR = "red";
	
	private final KioskAudioPlayer clickBGMPlayer = KioskAudioPlayer.createKisokAudioPlayer("sound/beep.wav");
	
	/* 잠시 final 지움... */
	private MenuType MENU_TYPE;
	private String IMG_PATH;
	private String MENU_NAME;
	private int PRICE;
	private int K_CAL;
	
	private OrderData orderData;
	
	/** 매개변수가 너무 많다. 또한 menuType는 멤버변수로 쓰이질 않는다.(안쓰이면 일단은 지워 놓으라고 강조함)
	 * 
	 *  그리고 해당 데이터는 OrderData의 내용임. OrderData의 객체를 이용해야함.
	 *  @see dev.empkiosk.page.order.MenuButton#MenuButton(String, OrderData)
	 * */	
	@Deprecated
	MenuButton(MenuType menuType, String imgPath, String menuName, int price, int kCal) {
		this.MENU_TYPE = menuType;
		this.IMG_PATH = imgPath;
		this.MENU_NAME = menuName;
		this.PRICE = price;
		this.K_CAL = kCal;
		
		initMenuButton(createTitle()); 
		setListener();
	}
	
	MenuButton(String imgPath, OrderData orderData){
		this.IMG_PATH = imgPath;
		this.orderData = orderData;
	}
	
	/** 
	 * create는 물체를 만들때 많이씀(이름이 안좋음). 코드는 가로로 길면 가독성이 안좋음.(특징을 세로로 배치)
	 * @see dev.empkiosk.page.order.MenuButton#getDefinedTitle()
	 * 
	 * 하지만, 해당 데이터는 이미 OrderData가 담당하고 있는 데이터이므로, 포멧은 OrderData가 담당해야한다.
	 * @see dev.empkiosk.page.order.OrderData;
	 * */
	@Deprecated
	private String createTitle() {
		return new StringBuilder().append("<html><center>").append(MENU_NAME).append("<br>")
		.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='").append(PRICE_FONT_TAG_COLOR).append("'>").append(PRICE).append("</font><br>")
		.append(K_CAL).append("KCal").append("</center></html>").toString();
	}
	
	
	/**
	 * MenuButton의 text가 왜 외부에서 결정되어야 하는가? 그냥 자기 자신이 만들 수 있으면 만드는게 맞음.
	 * @see dev.empkiosk.page.order.MenuButton#initMenuButton()
	 */
	@Deprecated
	private void initMenuButton(String title) {
		this.setIcon(ImageEdit.getResizeIcon(IMG_PATH, BUTTON_WIDTH, BUTTON_HEIGHT));
		this.setText(title);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		this.setBackground(Color.WHITE);
		this.setBorderPainted(false);
	}
	
	/** 
	 *  createTitle보다는 이게 낫지만,
	 *  이거보다는 아래의 메서드를 쓰는걸 추천. 
	 *  @see dev.empkiosk.page.order.OrderData#toMenuButtonText(String)
	 *  
	 *  */
	@Deprecated
	private String getDefinedTitle(){
		return new StringBuilder().append("<html><center>")
				.append(MENU_NAME).append("<br>")
				.append(LangCheck.isKorean() ? "가격 ₩ " : "Price ₩ ").append("<font color='")
				.append(PRICE_FONT_TAG_COLOR).append("'>")
				.append(PRICE).append("</font><br>")
				.append(K_CAL).append("KCal").append("</center></html>").toString();
	}
	
	private void initMenuButton(){
		this.setIcon(ImageEdit.getResizeIcon(IMG_PATH, BUTTON_WIDTH, BUTTON_HEIGHT));
		//this.setText(getDefinedTitle());
		this.setText(orderData.toMenuButtonText(PRICE_FONT_TAG_COLOR));
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
				/* 음원에 관련된건 음원관련 객체에게 맡긴다. */
//				clickBGMPlayer.play(); 
				SelectedMenuList.getInstance().add(new OrderData(MenuButton.this.toString(), PRICE, K_CAL));

				CartPanel.J_LIST.setListData(CartPanel.SELECTED_MENU);

				// JScrollPane의 바를 최 하단으로맞춤
				CartPanel.scroll.getVerticalScrollBar().setValue(CartPanel.scroll.getVerticalScrollBar().getMaximum());
				
				CartConfirmPanel.resetDataLabel();
			}
		});
	}
	
	/** 음원 파일재생 코딩을 playSound 메서드로 가렸지만, 음원재생 자체가 이 Button 클래스가 담당하면 안된다. */
	@Deprecated
	private void playSound() {
		try {
			final FileInputStream FIS = new FileInputStream(SOUND_FILE);
			final AudioStream AS = new AudioStream(FIS);
			AudioPlayer.player.start(AS);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/** 아래의 메서드를 보고 toString 메서드를 고치고, Deprecated 지우기.
	 *  @see dev.empkiosk.page.order.MenuButton#print()
	 */
	@Deprecated
	@Override
	public String toString() {
		return MENU_NAME.replaceAll("<html><center>", "").replaceAll("<br>", " ").replaceAll("</center></html>", "");
	}
	
	private String print(){
		return orderData.toString();
	}
	
	private static final long serialVersionUID = 1806232326009833938L;
}
