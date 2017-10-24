package dev.mcdonaldkiosk.page.menu.order;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JScrollPane;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.page.menu.Menu;

/**
 * Class Role : 이용자가 선택한 메뉴를 스크롤화면으로 보여주는 컴포넌트이다.
 *
 * 기능 :
 * Menu Array를 입력할 경우 리스트에 표기되고 스크롤이 최하단으로 보여준다.
 * 
 * @author Jaehyeon Kim
 */
class OrderListPanel extends JScrollPane {

  public final JList<Menu> J_LIST = new JList<>();

  public OrderListPanel() {
    initScrollPane();
  }

  private void initScrollPane() {
    this.setViewportView(J_LIST);
    this.setBorder(
        BorderFactory.createTitledBorder(LangCheck.isKorean() ? "선택메뉴" : "Select Menu")); // 경계설정
    this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 가로바
  }

  void setJListMenu(Menu[] menuArray) {
    J_LIST.setListData(menuArray);
    scrollDown();
  }

  // 스크롤을 최하단으로 내린다.
  private void scrollDown() {
    getVerticalScrollBar().setValue(getVerticalScrollBar().getMaximum());
  }
}
