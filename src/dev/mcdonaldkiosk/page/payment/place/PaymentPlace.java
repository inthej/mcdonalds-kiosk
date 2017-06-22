package dev.mcdonaldkiosk.page.payment.place;

public enum PaymentPlace {
  COUNTER, KIOSK;

  @Override
  public String toString() {
    return this.name();
  }
}
