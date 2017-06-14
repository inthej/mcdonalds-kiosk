package dev.mcdonaldkiosk.lang;

public class LangCheck {

  private static Language language = Language.KOREAN;

  private LangCheck() {
  }

  public static void setLang(Language language) {
    LangCheck.language = language;
  }

  public static boolean isKorean() {
    return language == Language.KOREAN;
  }
}
