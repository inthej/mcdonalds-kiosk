package dev.mcdonaldkiosk.page;

public class PageData {

  private final String AUDIO_PATH;
  private final KioskPageType nextPageType;
  private final KioskPageType previousPageType;

  private PageData(Builder builder) {
    AUDIO_PATH = builder.audioPath;
    nextPageType = builder.nextPageType;
    previousPageType = builder.previousPageType;
  }

  String getAudioPath() {
    return AUDIO_PATH;
  }

  KioskPageType getNextPageType() {
    return nextPageType;
  }

  KioskPageType getPreviousPageType() {
    return previousPageType;
  }
  
  public static class Builder {
    
    private final String audioPath;
    private KioskPageType nextPageType = KioskPageType.EMPTY_PAGE;
    private KioskPageType previousPageType = KioskPageType.EMPTY_PAGE;
    
    public Builder(String audioPath) {
      this.audioPath = audioPath;
    }
    
    public Builder nextPageType(KioskPageType pageType) {
      this.nextPageType = pageType;
      return this;
    }
    
    public Builder previousPageType(KioskPageType pageType) {
      this.previousPageType = pageType;
      return this;
    }
    
    public PageData build() {
      return new PageData(this);
    }
  }
}
