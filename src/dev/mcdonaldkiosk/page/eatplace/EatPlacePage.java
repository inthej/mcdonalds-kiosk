package dev.mcdonaldkiosk.page.eatplace;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.lang.Language;
import dev.mcdonaldkiosk.page.CommonGuidePanel;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.PageData;
import dev.mcdonaldkiosk.util.Display;

/**
 * Class Role : 식사장소를 선택할 수 있는 View 컴포넌트.
 * 
 * 주문언어 선택을 제공한다.
 * 페이지에 공통으로 가이드 패널(CommonGuidePanel)이 사용된다.
 *
 * @author Jaeheyon Kim
 */
public class EatPlacePage extends KioskPage {
  
  private enum SelectType {
    EAT_PLACE, LANG;
  }

  public EatPlacePage() {
    super(new PageData.Builder(LangCheck.isKorean() ? "sound/place.wav" : "sound/place_eng.wav")
                      .nextPageType(KioskPageType.PAYMENT_PLACE_PAGE)
                      .previousPageType(KioskPageType.START_PAGE)
                      .build());
    
    this.setBackgroundImg("image/bg_green.png");
    this.showBackBtn();
    
    addEatPlaceGuidePanel();
    addLangGuidePanel();
  }
  
  private void addEatPlaceGuidePanel() {
    this.add(createGuidePanel(SelectType.EAT_PLACE,
        LangCheck.isKorean() ? "식사하실 장소를 선택해 주세요" : "PLEASE SELECT A PLACE TO EAT"));
  }
  
  private void addLangGuidePanel() {
    this.add(createGuidePanel(SelectType.LANG, "PLASE SELECT YOUR LANGUAGE"));
  }
  
  private CommonGuidePanel createGuidePanel(final SelectType type, final String text) {
    final CommonGuidePanel guidePanel = new CommonGuidePanel(text, 0, 2);
    switch (type) {
      case EAT_PLACE : 
        guidePanel.addItem(
            createPlaceBtn(EatPlace.EAT_IN, LangCheck.isKorean() ? "매장 식사" : "EAT IN", "image/icon_eat.jpg"),
            createPlaceBtn(EatPlace.TAKE_OUT, LangCheck.isKorean() ? "테이크 아웃(포장)" : "TAKE OUT", "image/icon_take.jpg"));
        break;
      case LANG :
        initLangPanel(guidePanel);
        guidePanel.addItem(
            createLangBtn(Language.KOREAN, LangCheck.isKorean() ? "한국어" : "KOREAN"),
            createLangBtn(Language.ENGLISH, "ENGLISH"));
        break;
      default :
    }
    return guidePanel;
  }
  
  private ImageTextButton createPlaceBtn(final EatPlace place, final String text, final String imgPath) {
    final ImageTextButton imgTextBtn = new ImageTextButton(text, new ImageIcon(imgPath));
    imgTextBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        KioskPage.getKioskOrderData().setEatPlace(place);
        EatPlacePage.this.loadNextPage();
      }
    });

    return imgTextBtn;
  }
  
  private void initLangPanel(final CommonGuidePanel guidePanel) {
    final int width = Display.WINDOWS_HALF_WIDTH * 4 / 5;
    guidePanel.setGuidePanelSize(width, Display.WINDOWS_AVALIABLE_HEIGHT * 2 / 15);
    guidePanel.setGuidePanelLocation((Display.WINDOWS_HALF_WIDTH - width) / 2,
        Display.WINDOWS_AVALIABLE_HEIGHT * 3 / 4);
  }
  
  private ImageTextButton createLangBtn(final Language lang, final String text) {
    final ImageTextButton imgTextBtn = new ImageTextButton(text);
    imgTextBtn.setForeground(Color.BLACK);
    imgTextBtn.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        LangCheck.setLang(lang);
        EatPlacePage.this.reloadPage();
      }
    });

    return imgTextBtn;
  }
}