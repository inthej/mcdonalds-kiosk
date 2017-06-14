package dev.mcdonaldkiosk.page.eatplace;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.lang.Language;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.menu.OrderPlace;

/**
 * Created by kimjaehyeon on 2017. 5. 22
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 */
public class EatPlacePage extends KioskPage {

  private final int MIDDLE_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
  private final int MIDDLE_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 5;

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

  private ActionListener placeListener = null;

  private ActionListener langListener = null;

  public EatPlacePage() {
    initPage();

    initPlaceGuidePanel();

    initLanguageSelectPanel();

    initListeners();

    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackButton();

    this.currentPage = new EatPlaceKioskPageLoader();
    this.currentPage.playSoundOfLoadPage();
  }

  private void initPlaceGuidePanel() {
    PLACE_SELECT_GUIDE_PANEL.addItem(EAT_BUTTON, TAKE_BUTTON);

    Component placeSelectGuideComp = PLACE_SELECT_GUIDE_PANEL.getPanel();
    placeSelectGuideComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT);
    placeSelectGuideComp
        .setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT / 4);

    this.add(placeSelectGuideComp);
  }

  private void initLanguageSelectPanel() {
    KOR_BUTTON.setForeground(Color.BLACK);
    ENG_BUTTON.setForeground(Color.BLACK);
    LANGUAGE_SELECT_GUIDE_PANEL.addItem(KOR_BUTTON, ENG_BUTTON);

    Component languageSelectComp = LANGUAGE_SELECT_GUIDE_PANEL.getPanel();
    languageSelectComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT / 3);
    languageSelectComp.setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2,
        MainFrame.FRAME_HEIGHT * 3 / 4);

    this.add(languageSelectComp);
  }

  private void initListeners() {
    this.placeListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(EAT_BUTTON)) {
        OrderPlace.getInstance().setEatPlace(EatPlace.EAT_IN);
      } else if (source.equals(TAKE_BUTTON)) {
        OrderPlace.getInstance().setEatPlace(EatPlace.TAKE_OUT);
      }

      currentPage.loadNextPage();
    };

    this.langListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(KOR_BUTTON)) {
        LangCheck.setLang(Language.KOREAN);
      } else if (source.equals(ENG_BUTTON)) {
        LangCheck.setLang(Language.ENGLISH);
      }

      currentPage.refreshPage();
    };
  }

  private void setListeners() {
    BACK_BUTTON.addActionListener((args) -> currentPage.loadPreviousPage());

    EAT_BUTTON.addActionListener(placeListener);

    TAKE_BUTTON.addActionListener(placeListener);

    KOR_BUTTON.addActionListener(langListener);

    ENG_BUTTON.addActionListener(langListener);
  }
}