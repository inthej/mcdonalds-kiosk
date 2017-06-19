package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.page.confirm.ConfirmPageKioskPageLoader;
import dev.mcdonaldkiosk.page.eatplace.EatingLocationKioskPageLoader;
import dev.mcdonaldkiosk.page.menu.MenuPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePageKioskPageLoader;
import dev.mcdonaldkiosk.page.thank.EndPageKioskPageLorder;
import dev.mcdonaldkiosk.page.start.StartPageKioskPageLoader;

/**
 * @author Jaehyeon Kim
 * @since 2017. 6. 18.
 */
public enum KioskPageType {
  START_PAGE, EATING_LOCATION_PAGE, PAYMENT_PLACE_PAGE, MENU_PAGE, CONFIRM_PAGE, PAYMENT_CARD_PAGE, END_PAGE;

  public KioskPageLoader createKioskPageLoader() {
    KioskPageLoader kioskPageLoader = null;

    if (this == START_PAGE) {
      kioskPageLoader = new StartPageKioskPageLoader();
    } else if (this == EATING_LOCATION_PAGE) {
      kioskPageLoader = new EatingLocationKioskPageLoader();
    } else if (this == PAYMENT_PLACE_PAGE) {
      kioskPageLoader = new PaymentPlacePageKioskPageLoader();
    } else if (this == MENU_PAGE) {
      kioskPageLoader = new MenuPageKioskPageLoader();
    } else if (this == CONFIRM_PAGE) {
      kioskPageLoader = new ConfirmPageKioskPageLoader();
    } else if (this == PAYMENT_CARD_PAGE) {
      kioskPageLoader = new PaymentCardPageKioskPageLoader();
    } else if (this == END_PAGE) {
      kioskPageLoader = new EndPageKioskPageLorder();
    }

    return kioskPageLoader;
  }
}
