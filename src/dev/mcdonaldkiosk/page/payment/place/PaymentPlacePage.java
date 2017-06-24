package dev.mcdonaldkiosk.page.payment.place;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.KioskOrderData;
import dev.mcdonaldkiosk.page.eatplace.EatingPlacePage;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Created by kimjaehyeon on 2017. 5. 20
 * Class Role : 결제장소 선택 페이지
 */
public class PaymentPlacePage extends KioskPage {

  private final KioskGuidePanel PAYMENT_SELECT_PANEL = new KioskGuidePanel(
      LangCheck.isKorean() ? "어디에서 지불하시겠습니까?" : "WHERE DO YOU WANT TO PAY?", 0, 2);

  private final ImageTextButton COUNTER_BUTTON = new ImageTextButton();
  private final ImageTextButton KIOSK_BUTTON = new ImageTextButton();

  private ActionListener placeListener = null;

  public PaymentPlacePage(KioskOrderData kioskOrderData) {
    super(kioskOrderData, LangCheck.isKorean() ? "sound/pay.wav" : "sound/pay_eng.wav",
        KioskPageType.MENU_PAGE, KioskPageType.EATING_PLACE_PAGE);

    initPage();
    initPaymentSelectPanel();
    initListeners();
    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackButton();
  }

  private void initPaymentSelectPanel() {
    initKioskButton();
    PAYMENT_SELECT_PANEL.addItem(COUNTER_BUTTON, KIOSK_BUTTON);

    this.add(PAYMENT_SELECT_PANEL.getPanel());
  }

  private void initKioskButton() {
    final int BUTTON_WIDTH = MainFrame.FRAME_WIDTH * 4 / 15;
    final int BUTTON_HEIGHT = MainFrame.FRAME_HEIGHT * 1 / 5;

    COUNTER_BUTTON.setText(LangCheck.isKorean() ? "카운터에서 결제" : "PAYMENT AT THE COUNTER");
    COUNTER_BUTTON.setResizedImg(new ImageIcon("image/counter.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);

    KIOSK_BUTTON.setText(
        "<html><center>" + (LangCheck.isKorean() ? "바로 결제<br>(카드 가능)"
            : "DIRECT PAYMENT IN KIOSK<br>(CARD)")
            + "</center></html>");
    KIOSK_BUTTON.setResizedImg(new ImageIcon("image/kiosk.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  private void initListeners() {
    this.placeListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(COUNTER_BUTTON)) {
        kioskOrderData.setPaymentPlace(PaymentPlace.COUNTER);
      } else if (source.equals(KIOSK_BUTTON)) {
        kioskOrderData.setPaymentPlace(PaymentPlace.KIOSK);
      }

      this.loadNextPage();
    };
  }

  private void setListeners() {
    this.BACK_BUTTON.addActionListener((eventSource) -> this.loadPreviousPage());

    COUNTER_BUTTON.addActionListener(placeListener);

    KIOSK_BUTTON.addActionListener(placeListener);
  }
}
