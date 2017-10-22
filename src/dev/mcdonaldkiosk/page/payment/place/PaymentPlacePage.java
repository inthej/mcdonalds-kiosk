package dev.mcdonaldkiosk.page.payment.place;

import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.Display;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.CommonGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.KioskSettingData;

/**
 * Created by kimjaehyeon on 2017. 5. 20
 * Class Role : 결제장소 선택 페이지
 */
public class PaymentPlacePage extends KioskPage {

  private final CommonGuidePanel PAYMENT_SELECT_PANEL = new CommonGuidePanel(
      LangCheck.isKorean() ? "어디에서 지불하시겠습니까?" : "WHERE DO YOU WANT TO PAY?", 0, 2);

  private final ImageTextButton COUNTER_BUTTON = new ImageTextButton();
  private final ImageTextButton KIOSK_BUTTON = new ImageTextButton();

  private ActionListener placeListener = null;

  public PaymentPlacePage() {
    super(new KioskSettingData.Builder()
                              .setAudioPath(LangCheck.isKorean() ? "sound/pay.wav" : "sound/pay_eng.wav")
                              .setNextPage(KioskPageType.MENU_PAGE)
                              .setPreviousPage(KioskPageType.EAT_PLACE_PAGE)
                              .build());

    initPage();
    initPaymentSelectPanel();
    initListeners();
    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackBtn();
  }

  private void initPaymentSelectPanel() {
    initKioskButton();
    PAYMENT_SELECT_PANEL.addItem(COUNTER_BUTTON, KIOSK_BUTTON);

    this.add(PAYMENT_SELECT_PANEL);
  }

  private void initKioskButton() {
    final int BUTTON_WIDTH = Display.WINDOWS_WIDTH_HALF * 4 / 15;
    final int BUTTON_HEIGHT = Display.AVALIABLE_WINDOW_HEIGHT * 1 / 5;

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
        KioskPage.getKioskOrderData().setPaymentPlace(PaymentPlace.COUNTER);
      } else if (source.equals(KIOSK_BUTTON)) {
        KioskPage.getKioskOrderData().setPaymentPlace(PaymentPlace.KIOSK);
      }

      this.loadNextPage();
    };
  }

  private void setListeners() {
    COUNTER_BUTTON.addActionListener(placeListener);

    KIOSK_BUTTON.addActionListener(placeListener);
  }
}
