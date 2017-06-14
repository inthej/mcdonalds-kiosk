package dev.mcdonaldkiosk.lang;

public enum Language {
  KOREAN, ENGLISH;

  @Override
  public String toString() {
    return this.name();
  }
}
