package dev.empkiosk.page.order;

enum MenuType {
  BURGER, SNACK, SET_MENU, MC_CAFE, MC_LUNCH, DRINK, MC_MONING, DESSERT;

  @Override
  public String toString() {
    return this.name();
  }
}
