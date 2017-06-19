package dev.mcdonaldkiosk.page.payment.place;

import dev.mcdonaldkiosk.page.KioskPageType;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.menu.OrderPlace;

/**
 * Created by kimjaehyeon on 2017. 5. 20
 * Class Role : 결제장소 선택 페이지
 */
public class PaymentPlacePage extends KioskPage {

  private final int MID_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
  private final int MID_PANEL_HEIGHT = MainFrame.AVALIABLE_FRAME_HEIGHT * 2 / 5;

  private final KioskGuidePanel PAYMENT_SELECT_PANEL = new KioskGuidePanel(
      LangCheck.isKorean() ? "어디에서 지불하시겠습니까?" : "WHERE DO YOU WANT TO PAY?", 0, 2);

  private final ImageTextButton COUNTER_BUTTON = new ImageTextButton();
  private final ImageTextButton CARD_BUTTON = new ImageTextButton();

  private ActionListener placeListener = null;

  public PaymentPlacePage() {
    super(KioskPageType.PAYMENT_PLACE_PAGE);
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
    PAYMENT_SELECT_PANEL.addItem(COUNTER_BUTTON, CARD_BUTTON);
    PAYMENT_SELECT_PANEL.getPanel().setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
    PAYMENT_SELECT_PANEL.getPanel().setLocation((MainFrame.FRAME_WIDTH - MID_PANEL_WIDTH) / 2,
        MainFrame.AVALIABLE_FRAME_HEIGHT / 4);

    this.add(PAYMENT_SELECT_PANEL.getPanel());
  }

  private void initKioskButton() {
    final int BUTTON_WIDTH = MID_PANEL_WIDTH / 3;
    final int BUTTON_HEIGHT = MID_PANEL_HEIGHT / 2;

    COUNTER_BUTTON.setText(LangCheck.isKorean() ? "카운터에서 결제" : "PAYMENT AT THE COUNTER");
    COUNTER_BUTTON.setResizedImg(new ImageIcon("image/counter.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);

    CARD_BUTTON.setText(
        "<html><center>" + (LangCheck.isKorean() ? "바로 결제<br>(카드 가능)"
            : "DIRECT PAYMENT IN KIOSK<br>(CARD)")
            + "</center></html>");
    CARD_BUTTON.setResizedImg(new ImageIcon("image/kiosk.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);
  }

  private void initListeners() {
    this.placeListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(COUNTER_BUTTON)) {
        OrderPlace.getInstance().setPayPlace(PayPlace.COUNTER);
      } else if (source.equals(CARD_BUTTON)) {
        OrderPlace.getInstance().setPayPlace(PayPlace.KIOSK);
      }

      currentPage.loadNextPage();
    };
  }

  private void setListeners() {
    this.BACK_BUTTON.addActionListener((eventSource) -> currentPage.loadPreviousPage());

    COUNTER_BUTTON.addActionListener(placeListener);

    CARD_BUTTON.addActionListener(placeListener);
  }
}
