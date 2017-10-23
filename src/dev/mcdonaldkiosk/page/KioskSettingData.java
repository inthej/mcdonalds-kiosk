package dev.mcdonaldkiosk.page;

public class KioskSettingData {

  private final String AUDIO_PATH;
  private final KioskPageType nextPage;
  private final KioskPageType previousPage;

  private KioskSettingData(Builder builder) {
    AUDIO_PATH = builder.audioPath;
    nextPage = builder.nextPageType;
    previousPage = builder.previousPageType;
  }

  String getAudioPath() {
    return AUDIO_PATH;
  }

  KioskPageType getNextPage() {
    return nextPage;
  }

  KioskPageType getPreviousPage() {
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
      return new KioskSettingData(this);
    }
  }
}
