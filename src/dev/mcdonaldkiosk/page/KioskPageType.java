package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.page.confirm.ConfirmPage;
import dev.mcdonaldkiosk.page.eatplace.EatingPlacePage;
import dev.mcdonaldkiosk.page.end.EndPage;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPage;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePage;
import dev.mcdonaldkiosk.page.start.StartPage;

/**
 * @author Jaehyeon Kim
 * @since 2017. 6. 18.
 */
public enum KioskPageType {
  EMPTY_PAGE, START_PAGE, EATING_PLACE_PAGE, PAYMENT_PLACE_PAGE, MENU_PAGE, CONFIRM_PAGE, PAYMENT_CARD_PAGE, END_PAGE;

  public KioskPage createKioskPage(KioskOrderData kioskOrderData) {
    KioskPage kioskPage = null;
    if (this == EMPTY_PAGE) {
      kioskPage = new KioskPage(){ };
    } else if (this == START_PAGE) {
      kioskPage = new StartPage();
    } else if (this == EATING_PLACE_PAGE) {
      kioskPage = new EatingPlacePage(kioskOrderData);
    } else if (this == PAYMENT_PLACE_PAGE) {
      kioskPage = new PaymentPlacePage(kioskOrderData);
    } else if (this == MENU_PAGE) {
      kioskPage = new MenuPage(kioskOrderData);
    } else if (this == CONFIRM_PAGE) {
      kioskPage = new ConfirmPage(kioskOrderData);
    } else if (this == PAYMENT_CARD_PAGE) {
      kioskPage = new PaymentCardPage(kioskOrderData);
    } else if (this == END_PAGE) {
      kioskPage = new EndPage(kioskOrderData);
    }

    return kioskPage;
  }
}
