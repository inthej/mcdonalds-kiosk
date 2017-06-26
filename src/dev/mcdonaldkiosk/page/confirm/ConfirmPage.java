package dev.mcdonaldkiosk.page.confirm;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.KioskSettingData;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlace;
import java.awt.Color;
import java.awt.Component;

/**
 * Class Role : 주문데이터(KioskOrderData)의 확인 체크를 제공하는 페이지 이다.
 * 디자인이 반영된 ConfirmButton을 사용한다.
 *
 * @author Jaehyeon Kim
 * @see KioskOrderData ,ConfirmButton
 * @since 2017. 05. 25.
 */
public class ConfirmPage extends KioskPage {

  // 가운데 패널
  private final KioskGuidePanel ORDER_CONFIRM_GUIDE_PANEL = new KioskGuidePanel(
      LangCheck.isKorean() ? "주문을 확인해주세요" : "IS THIS ORDER CORRECT?", 0, 1);

  private OrderTotalDataPanel orderTotalDataPanel;

  // 하단 패널
  private final KioskGuidePanel YES_NO_SELECT_PANEL = new KioskGuidePanel(0, 2);
  private final ConfirmButton NO_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "취소" : "NO");
  private final ConfirmButton YES_BUTTON = new ConfirmButton(LangCheck.isKorean() ? "확인" : "YES");

  public ConfirmPage(KioskOrderData kioskOrderData) {
    super(
        new KioskSettingData(kioskOrderData,
            LangCheck.isKorean() ? "sound/check.wav" : "sound/check_eng.wav",
            kioskOrderData.getPaymentPlace().equals(PaymentPlace.COUNTER)
                ? KioskPageType.END_PAGE
                : KioskPageType.PAYMENT_CARD_PAGE,
            KioskPageType.MENU_PAGE));
    orderTotalDataPanel = new OrderTotalDataPanel(kioskOrderData);

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
  }

  private void initYesNoSelectPanel() {
    YES_NO_SELECT_PANEL.addItem(NO_BUTTON, YES_BUTTON);

    final int PANEL_WIDTH = MainFrame.FRAME_WIDTH * 2 / 5;
    final int PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 25;
    Component yesNoSelectComp = YES_NO_SELECT_PANEL.getPanel();
    yesNoSelectComp.setSize(PANEL_WIDTH, PANEL_HEIGHT);
    yesNoSelectComp
        .setLocation((MainFrame.FRAME_WIDTH - PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT * 3 / 4);
  }

  // set 설정하는 느낌
  private void setListener() {
    this.NO_BUTTON.addActionListener((e) -> this.loadPreviousPage()); // 한줄짜리는 { } 지울수 있음.

    this.YES_BUTTON.addActionListener((e) -> this.loadNextPage());
  }
}
