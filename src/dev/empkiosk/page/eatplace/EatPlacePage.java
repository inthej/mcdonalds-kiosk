package dev.empkiosk.page.eatplace;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextButton;
import dev.empkiosk.page.KioskGuidePanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.Language;
import dev.empkiosk.page.order.OrderPlace;
import dev.empkiosk.page.payment.place.PaymentPlacePage;
import dev.empkiosk.page.welcome.WelcomePage;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;

/**
 * Created by kimjaehyeon on 2017. 5. 22
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을
 * 담당한다.
 */
public class EatPlacePage extends KioskPage {

  private final int MIDDLE_PANEL_WIDTH = KioskPage.PAGE_WIDTH * 4 / 5;
  private final int MIDDLE_PANEL_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 5;

  private final KioskGuidePanel PLACE_SELECT_GUIDE_PANEL = new KioskGuidePanel(
      LangCheck.isKorean() ? "식사하실 장소를 선택해 주세요" : "PLEASE SELECT A PLACE TO EAT", 0, 2);
  private final KioskGuidePanel LANGUAGE_SELECT_GUIDE_PANEL = new KioskGuidePanel(
      "PLASE SELECT YOUR LANGUAGE", 0, 2);

  private final ImageTextButton EAT_BUTTON = new ImageTextButton(
      LangCheck.isKorean() ? "매장 식사" : "EAT IN",
      new ImageIcon("image/icon_eat.jpg"));
  private final ImageTextButton TAKE_BUTTON = new ImageTextButton(
      LangCheck.isKorean() ? "테이크 아웃(포장)" : "TAKE OUT",
      new ImageIcon("image/icon_take.jpg"));

  private final ImageTextButton KOR_BUTTON = new ImageTextButton(
      LangCheck.isKorean() ? "한국어" : "KOREAN");
  private final ImageTextButton ENG_BUTTON = new ImageTextButton("ENGLISH");

  public EatPlacePage() {
    initPage();

    initPlaceGuidePanel();

    initLanguageSelectPanel();

    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackgroundImg(true);
    this.showBackButton(true);

    KioskVoice.playSound(LangCheck.isKorean() ? "sound/place.wav" : "sound/place_eng.wav");
  }

  private void initPlaceGuidePanel() {
    PLACE_SELECT_GUIDE_PANEL.addItem(EAT_BUTTON, TAKE_BUTTON);

    Component placeSelectGuideComp = PLACE_SELECT_GUIDE_PANEL.getPanel();
    placeSelectGuideComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT);
    placeSelectGuideComp
        .setLocation((KioskPage.PAGE_WIDTH - MIDDLE_PANEL_WIDTH) / 2, KioskPage.PAGE_HEIGHT / 4);

    this.add(placeSelectGuideComp);
  }

  private void initLanguageSelectPanel() {
    KOR_BUTTON.setForeground(Color.BLACK);
    ENG_BUTTON.setForeground(Color.BLACK);
    LANGUAGE_SELECT_GUIDE_PANEL.addItem(KOR_BUTTON, ENG_BUTTON);

    Component languageSelectComp = LANGUAGE_SELECT_GUIDE_PANEL.getPanel();
    languageSelectComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT / 3);
    languageSelectComp.setLocation((KioskPage.PAGE_WIDTH - MIDDLE_PANEL_WIDTH) / 2,
        KioskPage.PAGE_HEIGHT * 3 / 4);

    this.add(languageSelectComp);
  }

  private void setListeners() {
    BACK_BUTTON.addActionListener((args) -> MainFrame.attachPanel(new WelcomePage()));

    EAT_BUTTON.addActionListener((args) -> {
      OrderPlace.getInstance().setEatPlace(EatPlace.EAT_IN);
      MainFrame.attachPanel(new PaymentPlacePage());
    });

    TAKE_BUTTON.addActionListener((args) -> {
      OrderPlace.getInstance().setEatPlace(EatPlace.TAKE_OUT);
      MainFrame.attachPanel(new PaymentPlacePage());
    });

    KOR_BUTTON.addActionListener((args) -> {
      LangCheck.setLang(Language.KOREAN);
      MainFrame.attachPanel(new EatPlacePage());
    });

    ENG_BUTTON.addActionListener((args) -> {
      LangCheck.setLang(Language.ENGLISH);
      MainFrame.attachPanel(new EatPlacePage());
    });
  }

  private static final long serialVersionUID = 8863747896450914982L;
}