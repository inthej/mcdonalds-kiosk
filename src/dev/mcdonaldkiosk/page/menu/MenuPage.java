package dev.mcdonaldkiosk.page.menu;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.menu.order.SelectedOrderConfirmPanel;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.util.ImageEdit;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Class Role : 메뉴를 선택할 수 있는 메뉴페이지의 구성을 가지고 있다.
 * 기본 레이아웃은 BorderLayout 이며
 * 상단 이미지 베너 라벨, 중간 메뉴 탭(MenuTabbedPane) 페인, 하단 선택된 주문확인 패널(SelectedOrderConfirmPanel)로 구성되어 있다.
 *
 * @author Jaehyeon, Kim
 */
public class MenuPage extends KioskPage {

  private final ImageIcon bannerImageIcon = new ImageIcon("image/banner_top.jpg");
  private final MenuTabbedPane menuTabbedPane;
  private final SelectedOrderConfirmPanel selectedOrderConfirmPanel;

  public MenuPage(KioskOrderData kioskOrderData) {
    super(kioskOrderData, LangCheck.isKorean() ? "sound/order.wav" : "sound/order_eng.wav");

    menuTabbedPane = new MenuTabbedPane(this, kioskOrderData);
    selectedOrderConfirmPanel = new SelectedOrderConfirmPanel(this, kioskOrderData);

    initPage();
    setLayout();
    reflesh();
  }

  private void initPage() {
    this.setLayout(new BorderLayout());
    this.add(createImageLabel(bannerImageIcon), BorderLayout.NORTH);
    this.add(menuTabbedPane, BorderLayout.CENTER);
    this.add(selectedOrderConfirmPanel, BorderLayout.SOUTH);
  }

  private JLabel createImageLabel(final ImageIcon imageIcon) {
    final JLabel imageLabel = new JLabel(
        ImageEdit.getResizeIcon(imageIcon, MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT
            / 5));

    imageLabel.add(BACK_BUTTON);

    return imageLabel;
  }

  private void setLayout() {
    this.BACK_BUTTON.addActionListener((e) -> {
      kioskOrderData.clearMenu();
      MainFrame.attachPanel(new PaymentPlacePage(this.kioskOrderData));
    });
  }

  public void reflesh() {
    selectedOrderConfirmPanel.reflesh();
  }
}
