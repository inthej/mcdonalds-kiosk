package dev.empkiosk.page.order;

import dev.empkiosk.page.KioskPage;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Created by kimjaehyeon
 * Class Role : 한 면에 보이는 메뉴들을 붙일수있는 테이블이다.
 */
class MenuTablePanel extends JPanel {

  private final ArrayList<MenuButton> MENU_BUTTON_LIST = new ArrayList<>();

  public static final int TABLE_WIDTH = KioskPage.PAGE_WIDTH;
  public static final int TABLE_HEIGHT = KioskPage.PAGE_HEIGHT;

  MenuTablePanel(int menuRows, int menuCols) {
    // 초기화
    this.setLayout(new GridLayout(menuRows, menuCols));

    // 사이즈 & 컬러
    this.setSize(TABLE_WIDTH, TABLE_HEIGHT);
    this.setBackground(Color.WHITE);
  }

  // 메뉴등록
  private void registerMenu() {
    for (MenuButton menuBtn : MENU_BUTTON_LIST) {
      this.add(menuBtn);
    }
  }

  // 메뉴 추가
  void addMenu(MenuButton... menuButtons) {
    if (menuButtons.length != 0) {
      for (MenuButton menuBtn : menuButtons) {
        MENU_BUTTON_LIST.add(menuBtn);
        this.add(menuBtn);
      }
    }
  }

  private static final long serialVersionUID = 1977962089759574014L;
}
