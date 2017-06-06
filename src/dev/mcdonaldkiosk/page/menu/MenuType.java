package dev.mcdonaldkiosk.page.menu;

enum MenuType {
	BURGER, SNACK, SET_MENU, MC_CAFE, MC_LUNCH, DRINK, MC_MONING, DESSERT;

	@Override
	public String toString() {
		return this.name();
	}
}
