package dev.mcdonaldkiosk.page;

public class KioskSettingData {

  private final KioskOrderData kioskOrderData;
  private final String audioPath;
  private final KioskPageType nextPageType;
  private final KioskPageType previousPageType;

  public KioskSettingData(KioskOrderData kioskOrderData, String audioPath,
      KioskPageType nextPageType, KioskPageType previousPageType) {
    this.kioskOrderData = kioskOrderData;
    this.audioPath = audioPath;
    this.nextPageType = nextPageType;
    this.previousPageType = previousPageType;
  }

  public KioskOrderData getKioskOrderData() {
    return kioskOrderData;
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
