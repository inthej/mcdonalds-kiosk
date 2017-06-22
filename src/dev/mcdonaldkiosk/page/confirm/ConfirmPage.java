package dev.mcdonaldkiosk.page.confirm;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.OrderData;
import java.awt.Color;
import java.awt.Component;

/**
 * Class Role : 주문확인 페이지
 *
 * @authro Jaehyeon Kim
 * @since 2017. 05. 25.
 */
public class ConfirmPage extends KioskPage {

  /* 중간패널 사이즈 */
  private final int MIDDLE_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
  private final int MIDDLE_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 5;

  // 가운데 패널
  private final KioskGuidePanel ORDER_CONFIRM_GUIDE_PANEL = new KioskGuidePanel(
      LangCheck.isKorean() ? "주문을 확인해주세요" : "IS THIS ORDER CORRECT?", 0, 1);

  private OrderTotalDataPanel orderTotalDataPanel;

  // 하단 패널
  private final KioskGuidePanel YES_NO_SELECT_PANEL = new KioskGuidePanel(0, 2);
  private final ConfirmButton NO_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "취소" : "NO");
  private final ConfirmButton YES_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "확인" : "YES");

  public ConfirmPage(OrderData orderData) {
    super(KioskPageType.CONFIRM_PAGE, orderData);
    orderTotalDataPanel = new OrderTotalDataPanel(orderData);

    initPage();
    initOrderTotalListPanel();
    initYesNoSelectPanel();
    setListener();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");

    this.add(ORDER_CONFIRM_GUIDE_PANEL.getPanel());
    this.add(YES_NO_SELECT_PANEL.getPanel());
  }

  private void initOrderTotalListPanel() {
    ORDER_CONFIRM_GUIDE_PANEL.setTitleColor(Color.GREEN);
    ORDER_CONFIRM_GUIDE_PANEL.addItem(orderTotalDataPanel);

    Component orderConfirmGuideComp = ORDER_CONFIRM_GUIDE_PANEL.getPanel();
    orderConfirmGuideComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT);
    orderConfirmGuideComp
        .setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT
            / 4);
  }

  private void initYesNoSelectPanel() {
    YES_NO_SELECT_PANEL.addItem(NO_BUTTON, YES_BUTTON);

    int width = MIDDLE_PANEL_WIDTH / 2;
    int height = MIDDLE_PANEL_HEIGHT / 5;
    Component yesNoSelectComp = YES_NO_SELECT_PANEL.getPanel();
    yesNoSelectComp.setSize(width, height);
    yesNoSelectComp
        .setLocation((MainFrame.FRAME_WIDTH - width) / 2, MainFrame.FRAME_HEIGHT
            * 3 / 4);
  }

  // set 설정하는 느낌
  private void setListener() {
    this.NO_BUTTON.addActionListener((e) -> currentPage.loadPreviousPage(orderData)); // 한줄짜리는 { } 지울수 있음.

    this.YES_BUTTON.addActionListener((e) -> currentPage.loadNextPage(orderData));
  }
}
