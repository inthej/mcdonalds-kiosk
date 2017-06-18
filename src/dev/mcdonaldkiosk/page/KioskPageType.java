package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.page.confirm.ConfirmPageKioskPageLoader;
import dev.mcdonaldkiosk.page.eatplace.EatPlaceKioskPageLoader;
import dev.mcdonaldkiosk.page.menu.MenuPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePageKioskPageLoader;
import dev.mcdonaldkiosk.page.thank.ThankPageKioskPageLorder;
import dev.mcdonaldkiosk.page.welcome.WelcomePageKioskPageLoader;

/**
 * @author Jaehyeon Kim
 * @since 2017. 6. 18.
 */
public enum KioskPageType {
  WELCOME_PAGE, EAT_PLACE_PAGE, PAYMENT_PLACE_PAGE, MENU_PAGE, CONFIRM_PAGE, PAYMENT_CARD_PAGE, THANK_PAGE;

  public KioskPageLoader createKioskPageLoader() {
    KioskPageLoader kioskPageLoader = null;

    if (this == WELCOME_PAGE) {
      kioskPageLoader = new WelcomePageKioskPageLoader();
    } else if (this == EAT_PLACE_PAGE) {
      kioskPageLoader = new EatPlaceKioskPageLoader();
    } else if (this == PAYMENT_PLACE_PAGE) {
      kioskPageLoader = new PaymentPlacePageKioskPageLoader();
    } else if (this == MENU_PAGE) {
      kioskPageLoader = new MenuPageKioskPageLoader();
    } else if (this == CONFIRM_PAGE) {
      kioskPageLoader = new ConfirmPageKioskPageLoader();
    } else if (this == PAYMENT_CARD_PAGE) {
      kioskPageLoader = new PaymentCardPageKioskPageLoader();
    } else if (this == THANK_PAGE) {
      kioskPageLoader = new ThankPageKioskPageLorder();
    }

    return kioskPageLoader;
  }
}
