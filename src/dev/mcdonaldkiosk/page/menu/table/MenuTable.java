package dev.mcdonaldkiosk.page.menu.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dev.mcdonaldkiosk.page.menu.Menu;
import dev.mcdonaldkiosk.page.menu.MenuButton;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.order.KioskOrderData;

/**
 * Class Role : 메뉴 버튼의 구성을 가진 패널에 스크롤이 제공되는 JScrollPane 컴포넌트이다.
 *
 * 메뉴 테이블의 패널은 기본적으로 GridLayout 형식을 가지고 있으며
 * GirdLayout의 특징인 열, 행 사이즈는 생성자에 입력된 매개변수 데이터에 의해 초기화된다.
 *
 * 입력된 메뉴에 따라서 프레임보다 사이즈가 더 클 수 있기 때문에
 * 패널 전체를 화면에 표시하기 위해서는 스크롤이 필요하다.
 *
 * 기능 :
 * 메뉴 입력(addMenu)을 통하여 패널에 메뉴 데이터(MenuButton) 입력을 제공한다.
 *
 * @author Jaehyeon Kim
 */
public abstract class MenuTable {

  private final JScrollPane scroll = new JScrollPane();
  private final JPanel menuPanel = new JPanel();
  private final MenuPage menuPage;

  MenuTable(MenuPage menuPage, final int rows, final int cols) {
    this.menuPage = menuPage;

    initScroll();
    initPanel(rows, cols);
  }

  private void initScroll() {
    scroll.getVerticalScrollBar().setUnitIncrement(10); // 스크롤 속도 (세로)
    scroll.getHorizontalScrollBar().setUnitIncrement(10); // 가로 스크롤 (가로)
    scroll.setViewportView(menuPanel);
  }

  private void initPanel(int rows, int cols) {
    rows = (rows > 0) ? rows : 0;
    cols = (cols > 0) ? cols : 0;
    menuPanel.setLayout(new GridLayout(rows, cols));
    menuPanel.setBackground(Color.WHITE);
  }

  Menu createMenu(final String name, final int price, final int kCal) {
    return new Menu(name, price, kCal);
  }

  MenuButton createMenuButton(final String imgPath, final Menu menu, final KioskOrderData kioskOrderData) {
    return new MenuButton(imgPath, menu, menuPage, kioskOrderData);
  }

  // 메뉴 추가
  void addMenu(final MenuButton... buttons) {
    for (MenuButton button : buttons) {
      menuPanel.add(button);
    }
  }

  public Component getComponent() {
    return scroll;
  }

  public abstract String toString();
}
