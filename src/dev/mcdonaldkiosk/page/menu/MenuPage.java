package dev.mcdonaldkiosk.page.menu;

import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.menu.order.CartPanel;
import dev.mcdonaldkiosk.util.ImageEdit;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.menu.order.OrderDataModel;

/**
 * Class Role : 메뉴를 선택할 수 있는 메뉴페이지의 구성을 가지고 있다.
 * 기본 레이아웃은 BorderLayout 이며
 * 상단 이미지베너 라벨, 중간 메뉴탭(MenuTabbedPane) 페인, 하단 장바구니(Cart) 패널로 구성되어 있다.
 *
 * @author Jaehyeon, Kim
 */
public class MenuPage extends KioskPage {

  private final OrderDataModel orderDataModel = new OrderDataModel(this);

  private final ImageIcon bannerImageIcon = new ImageIcon("image/banner_top.jpg");
  private final MenuTabbedPane menuTabbedPane = new MenuTabbedPane(orderDataModel);
  private final CartPanel cartPanel = new CartPanel(orderDataModel);

  public MenuPage(KioskPageType kioskPageType) {
    super(kioskPageType);
    initPage();
    setLayout();
  }

  private void initPage() {
    this.setLayout(new BorderLayout());
    this.add(createImageLabel(bannerImageIcon), BorderLayout.NORTH);
    this.add(menuTabbedPane, BorderLayout.CENTER);
    this.add(cartPanel, BorderLayout.SOUTH);
  }

  private JLabel createImageLabel(final ImageIcon imageIcon) {
    final JLabel imageLabel = new JLabel(
        ImageEdit.getResizeIcon(imageIcon, MainFrame.FRAME_WIDTH, MainFrame.AVALIABLE_FRAME_HEIGHT
            / 5));

    imageLabel.add(BACK_BUTTON);

    return imageLabel;
  }

  private void setLayout() {
    this.BACK_BUTTON.addActionListener((e) -> {
      orderDataModel.clear();
      currentPage.loadPreviousPage();
    });
  }
}
