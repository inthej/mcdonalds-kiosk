package dev.mcdonaldkiosk.page.eatplace;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.lang.Language;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.ImageTextButton;
import dev.mcdonaldkiosk.page.KioskGuidePanel;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.OrderData;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Class Role : 식사장소 데이터 및 식사장소/언어 선택 화면을 담당한다.
 *
 * @author Jaeheyon Kim
 * @since 2017. 05. 22
 */
public class EatPlacePage extends KioskPage {

  private final int MIDDLE_PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
  private final int MIDDLE_PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 5;

  private final KioskGuidePanel eatingLocationPanel = new KioskGuidePanel(
      LangCheck.isKorean() ? "식사하실 장소를 선택해 주세요" : "PLEASE SELECT A PLACE TO EAT", 0, 2);

  private final ImageTextButton eatInButton = new ImageTextButton(
      LangCheck.isKorean() ? "매장 식사" : "EAT IN",
      new ImageIcon("image/icon_eat.jpg"));
  private final ImageTextButton takeOutButton = new ImageTextButton(
      LangCheck.isKorean() ? "테이크 아웃(포장)" : "TAKE OUT",
      new ImageIcon("image/icon_take.jpg"));

  private final KioskGuidePanel languagePanel = new KioskGuidePanel(
      "PLASE SELECT YOUR LANGUAGE", 0, 2);

  private final ImageTextButton koreanButton = new ImageTextButton(
      LangCheck.isKorean() ? "한국어" : "KOREAN");
  private final ImageTextButton englishButton = new ImageTextButton("ENGLISH");

  private ActionListener placeListener = null;

  private ActionListener langListener = null;

  public EatPlacePage(OrderData orderData) {
    super(KioskPageType.EATING_PLACE_PAGE, orderData);

    initPage();
    initEatingLocationPanel();
    initLanguagePanel();
    initListeners();
    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackButton();
  }

  private void initEatingLocationPanel() {
    eatingLocationPanel.addItem(eatInButton, takeOutButton);

    Component placeSelectGuideComp = eatingLocationPanel.getPanel();
    placeSelectGuideComp.setSize(MainFrame.FRAME_WIDTH * 4 / 5, MIDDLE_PANEL_HEIGHT);
    placeSelectGuideComp
        .setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2, MainFrame.FRAME_HEIGHT
            / 4);

    this.add(placeSelectGuideComp);
  }

  private void initLanguagePanel() {
    koreanButton.setForeground(Color.BLACK);
    englishButton.setForeground(Color.BLACK);
    languagePanel.addItem(koreanButton, englishButton);

    Component languageSelectComp = languagePanel.getPanel();
    languageSelectComp.setSize(MIDDLE_PANEL_WIDTH, MIDDLE_PANEL_HEIGHT / 3);
    languageSelectComp.setLocation((MainFrame.FRAME_WIDTH - MIDDLE_PANEL_WIDTH) / 2,
        MainFrame.FRAME_HEIGHT * 3 / 4);

    this.add(languageSelectComp);
  }

  private void initListeners() {
    this.placeListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(eatInButton)) {
        orderData.setEatingPlace(EatingPlace.EAT_IN);
      } else if (source.equals(takeOutButton)) {
        orderData.setEatingPlace(EatingPlace.TAKE_OUT);
      }

      currentPage.loadNextPage(orderData);
    };

    this.langListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(koreanButton)) {
        LangCheck.setLang(Language.KOREAN);
      } else if (source.equals(englishButton)) {
        LangCheck.setLang(Language.ENGLISH);
      }

      currentPage.refreshPage(orderData);
    };
  }

  private void setListeners() {
    BACK_BUTTON.addActionListener((args) -> currentPage.loadPreviousPage(orderData));

    eatInButton.addActionListener(placeListener);

    takeOutButton.addActionListener(placeListener);

    koreanButton.addActionListener(langListener);

    englishButton.addActionListener(langListener);
  }
}