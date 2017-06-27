package dev.mcdonaldkiosk.page.menu;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.KioskSettingData;
import dev.mcdonaldkiosk.page.menu.order.SelectedOrderConfirmPanel;
import dev.mcdonaldkiosk.util.ImageEdit;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : 메뉴를 선택할 수 있는 메뉴페이지의 구성을 가지고 있다.
 * 기본 레이아웃은 BorderLayout 이며
 * 상단 이미지 베너 라벨, 중간 메뉴 탭(MenuTabbedPane) 페인, 하단 선택된 주문확인 패널(SelectedOrderConfirmPanel)로 구성되어 있다.
 *
 * @author Jaehyeon, Kim
 */
public class MenuPage extends KioskPage {

  private final JPanel menuPagePanel = new JPanel();

  private final ImageIcon bannerImageIcon = new ImageIcon("image/banner_top.jpg");
  private final MenuTabbedPane menuTabbedPane;
  private final SelectedOrderConfirmPanel selectedOrderConfirmPanel;

  public MenuPage() {
    super(
        new KioskSettingData(LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav",
            KioskPageType.CONFIRM_PAGE,
            KioskPageType.PAYMENT_PLACE_PAGE));

    menuTabbedPane = new MenuTabbedPane(this, KioskPage.getKioskOrderData());
    selectedOrderConfirmPanel = new SelectedOrderConfirmPanel(this, KioskPage.getKioskOrderData());

    initPage();
    initManuPagePanel();
    setLayout();
    reflesh();
  }

  private void initPage() {
    this.add(menuPagePanel);
    this.showBackButton();
  }

  private void initManuPagePanel() {
    menuPagePanel.setLayout(new BorderLayout());
    menuPagePanel.setSize(MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT);
    menuPagePanel.setLocation(0, 0);

    menuPagePanel.add(createImageLabel(bannerImageIcon), BorderLayout.NORTH);
    menuPagePanel.add(menuTabbedPane, BorderLayout.CENTER);
    menuPagePanel.add(selectedOrderConfirmPanel, BorderLayout.SOUTH);

  }

  private JLabel createImageLabel(final ImageIcon imageIcon) {
    return new JLabel(
        ImageEdit.getResizeIcon(imageIcon, MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT / 5));
  }

  private void setLayout() {
    this.getBackButton().addActionListener((e) -> KioskPage.getKioskOrderData().clearMenu());
  }

  public void reflesh() {
    selectedOrderConfirmPanel.reflesh();
  }

  public void nextPage() {
    this.loadNextPage();
  }
}
