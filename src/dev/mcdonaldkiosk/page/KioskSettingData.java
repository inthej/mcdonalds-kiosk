package dev.mcdonaldkiosk.page;

public class KioskSettingData {

  private final String audioPath;
  private final KioskPageType nextPage;
  private final KioskPageType previousPage;

  private KioskSettingData(String audioPath, KioskPageType nextPageType,
      KioskPageType previousPageType) {
    this.audioPath = audioPath;
    this.nextPage = nextPageType;
    this.previousPage = previousPageType;
  }

  public String getAudioPath() {
    return audioPath;
  }

  public KioskPageType getNextPage() {
    return nextPage;
  }

  public KioskPageType getPreviousPage() {
    return previousPage;
  }
  
  public static class Builder {
    
    private String audioPath;
    private KioskPageType nextPageType = KioskPageType.EMPTY_PAGE;
    private KioskPageType previousPageType = KioskPageType.EMPTY_PAGE;
    
    public Builder setAudioPath(String audioPath) {
      this.audioPath = audioPath;
      return this;
    }
    
    public Builder setNextPage(KioskPageType nextPage) {
      this.nextPageType = nextPage;
      return this;
    }
    
    public Builder setPreviousPage(KioskPageType previousPage) {
      this.previousPageType = previousPage;
      return this;
    }
    
    public KioskSettingData build() {
      return new KioskSettingData(audioPath, nextPageType, previousPageType);
    }
  }
}
