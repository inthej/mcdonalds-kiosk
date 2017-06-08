package dev.mcdonaldkiosk.page.menu.order;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.menu.Menu;

/**
 * Class Role : 이용자가 선택한 메뉴를 스크롤화면으로 보여주는 컴포넌트이다.
 * 
 * 기능 :
 * 화면을 갱신할 경우 메뉴리스트의 메뉴정보가 리스트에 표기되고 스크롤이 최하단으로 보여준다.
 */
class SelectMenuBoxScrollPane extends JScrollPane {

	private final Menu[] SELECTED_MENU_ARRAY;
	
	public final JList<Menu> J_LIST = new JList<>();

	public SelectMenuBoxScrollPane(Menu[] selectMenu) {
		SELECTED_MENU_ARRAY = selectMenu;

		initScrollPane();
		initJList();
		refresh();
	}

	private void initScrollPane() {
		this.setViewportView(J_LIST);
		this.setBorder(BorderFactory.createTitledBorder(LangCheck.isKorean() ? "선택메뉴" : "Select Menu")); // 경계설정
		this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로바
	}

	private void initJList() {
		J_LIST.setSize(this.getWidth(), this.getHeight());
		J_LIST.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT / 10 + MainFrame.FRAME_HEIGHT / 40);
	}
	
	void refresh() {
		setJListMenu();
		scrollDown();
	}

	private void setJListMenu() {
		J_LIST.setListData(SELECTED_MENU_ARRAY);
	}

	// 스크롤을 최하단으로 내린다.
	private void scrollDown() {
		getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
	}
}
