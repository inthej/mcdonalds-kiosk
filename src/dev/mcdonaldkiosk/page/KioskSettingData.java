package dev.mcdonaldkiosk.page;

public class KioskSettingData {

  private final String audioPath;
  private final KioskPageType nextPageType;
  private final KioskPageType previousPageType;

  public KioskSettingData(String audioPath, KioskPageType nextPageType,
      KioskPageType previousPageType) {
    this.audioPath = audioPath;
    this.nextPageType = nextPageType;
    this.previousPageType = previousPageType;
  }

  public String getAudioPath() {
    return audioPath;
  }

  public KioskPageType getNextPageType() {
    return nextPageType;
  }

  public KioskPageType getPreviousPageType() {
    return previousPageType;
  }
}
