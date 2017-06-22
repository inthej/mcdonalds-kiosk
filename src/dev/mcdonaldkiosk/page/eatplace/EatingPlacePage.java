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
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Class Role : 식사장소/언어 선택 화면을 담당한다.
 *
 * @author Jaeheyon Kim
 * @see KioskGuidePanel,ImageTextButton
 * @since 2017. 05. 22
 */
public class EatingPlacePage extends KioskPage {

  private final KioskGuidePanel eatingPlaceSelectPanel = new KioskGuidePanel(
      LangCheck.isKorean() ? "식사하실 장소를 선택해 주세요" : "PLEASE SELECT A PLACE TO EAT", 0, 2);
  private final ImageTextButton eatInButton = new ImageTextButton(
      LangCheck.isKorean() ? "매장 식사" : "EAT IN", new ImageIcon("image/icon_eat.jpg"));
  private final ImageTextButton takeOutButton = new ImageTextButton(
      LangCheck.isKorean() ? "테이크 아웃(포장)" : "TAKE OUT", new ImageIcon("image/icon_take.jpg"));

  private KioskGuidePanel languageSelectPanel = new KioskGuidePanel("PLASE SELECT YOUR LANGUAGE", 0, 2);
  private ImageTextButton koreanButton = new ImageTextButton(LangCheck.isKorean() ? "한국어" : "KOREAN");
  private ImageTextButton englishButton = new ImageTextButton("ENGLISH");

  private ActionListener eatingPlaceListener;
  private ActionListener languageListener;

  public EatingPlacePage(OrderData orderData) {
    super(KioskPageType.EATING_PLACE_PAGE, orderData);

    initPage();
    initEatingPlaceSelectPanel();
    initLanguageSelectPanel();
    initListeners();
    setListeners();
  }

  private void initPage() {
    this.setBackgroundImg("image/bg_green.png");
    this.showBackButton();

    this.add(eatingPlaceSelectPanel.getPanel());
    this.add(languageSelectPanel.getPanel());
  }

  private void initEatingPlaceSelectPanel() {
    eatingPlaceSelectPanel.addItem(eatInButton, takeOutButton);
  }

  private void initLanguageSelectPanel() {
    final int PANEL_WIDTH = MainFrame.FRAME_WIDTH * 4 / 5;
    final int PANEL_HEIGHT = MainFrame.FRAME_HEIGHT * 2 / 15;
    languageSelectPanel.setGuidePanelSize(PANEL_WIDTH, PANEL_HEIGHT);
    languageSelectPanel.setGuidePanelLocation((MainFrame.FRAME_WIDTH - PANEL_WIDTH) / 2,
        MainFrame.FRAME_HEIGHT * 3 / 4);

    koreanButton.setForeground(Color.BLACK);
    englishButton.setForeground(Color.BLACK);

    languageSelectPanel.addItem(koreanButton, englishButton);
  }

  private void initListeners() {
    this.eatingPlaceListener = (eventSource) -> {
      Object source = eventSource.getSource();

      if (source.equals(eatInButton)) {
        orderData.setEatingPlace(EatingPlace.EAT_IN);
      } else if (source.equals(takeOutButton)) {
        orderData.setEatingPlace(EatingPlace.TAKE_OUT);
      }

      currentPage.loadNextPage(orderData);
    };

    this.languageListener = (eventSource) -> {
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

    eatInButton.addActionListener(eatingPlaceListener);
    takeOutButton.addActionListener(eatingPlaceListener);

    koreanButton.addActionListener(languageListener);
    englishButton.addActionListener(languageListener);
  }
}