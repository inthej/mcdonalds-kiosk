package dev.mcdonaldkiosk.page.payment.place;

public enum PayPlace {
	COUNTER, KIOSK;

	@Override
	public String toString() {
		return this.name();
	}
}
