package dev.mcdonaldkiosk.page;

import static dev.mcdonaldkiosk.page.KioskPageType.CONFIRM_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.EATING_PLACE_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.END_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.MENU_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.PAYMENT_CARD_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.PAYMENT_PLACE_PAGE;
import static dev.mcdonaldkiosk.page.KioskPageType.START_PAGE;

import dev.mcdonaldkiosk.page.confirm.ConfirmPageKioskPageLoader;
import dev.mcdonaldkiosk.page.eatplace.EatingPlaceKioskPageLoader;
import dev.mcdonaldkiosk.page.end.EndPageKioskPageLorder;
import dev.mcdonaldkiosk.page.menu.MenuPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPageKioskPageLoader;
import dev.mcdonaldkiosk.page.payment.place.PaymentPlacePageKioskPageLoader;
import dev.mcdonaldkiosk.page.start.StartPageKioskPageLoader;

/**
 * @author Jaehyeon Kim
 * @since 2017. 6. 23.
 */
public class KioskPageLoaderFactory {

  public KioskPageLoader createKioskPageLoader(KioskPageType kioskPageType) {
    KioskPageLoader kioskPageLoader = null;

    if (kioskPageType == START_PAGE) {
      kioskPageLoader = new StartPageKioskPageLoader();
    } else if (kioskPageType == EATING_PLACE_PAGE) {
      kioskPageLoader = new EatingPlaceKioskPageLoader();
    } else if (kioskPageType == PAYMENT_PLACE_PAGE) {
      kioskPageLoader = new PaymentPlacePageKioskPageLoader();
    } else if (kioskPageType == MENU_PAGE) {
      kioskPageLoader = new MenuPageKioskPageLoader();
    } else if (kioskPageType == CONFIRM_PAGE) {
      kioskPageLoader = new ConfirmPageKioskPageLoader();
    } else if (kioskPageType == PAYMENT_CARD_PAGE) {
      kioskPageLoader = new PaymentCardPageKioskPageLoader();
    } else if (kioskPageType == END_PAGE) {
      kioskPageLoader = new EndPageKioskPageLorder();
    }

    return kioskPageLoader;
  }
}
