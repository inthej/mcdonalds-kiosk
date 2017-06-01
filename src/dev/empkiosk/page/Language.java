package dev.empkiosk.page;

public enum Language {
  KOREAN, ENGLISH;

  @Override
  public String toString() {
    return this.name();
  }
}
