package dev.mcdonaldkiosk.page;

import dev.mcdonaldkiosk.main.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : KioskPage에서 공통적으로 사용되고 있는 가이드 패널이다.
 *
 * 특징 :
 * 1. BorderLayout 형태를 가지고 있다.
 * 2. 상단 타이틀 라벨과 중간의 GridLayout 형태의 아이템 패널로 구성된 형태와
 * 상단 타이틀 라벨이 없는 2가지의 사용형태가 존재한다.
 * 3. 생성자에서 아이템 패널의 GridLayout의 행과 열을 지정 한다.
 *
 * 기능 :
 * 1. 아이탬 패널에 아이탬을 추가할수 있는 기능을 제공한다.
 * 2. 상단 타이틀 라벨의 텍스트 색상을 지정 할 수 있는 기능을 제공한다.
 */
public class KioskGuidePanel {

  private final Color BACKGROUND_COLOR = Color.BLACK;

  private final JPanel GUIDE_PANEL = new JPanel();
  private int guidePanelWidth = MainFrame.FRAME_WIDTH * 4 / 5;
  private int guidePanelHeight = MainFrame.FRAME_HEIGHT * 2 / 5;

  private final JPanel ITEM_PANEL = new JPanel();

  public KioskGuidePanel(final int itemRow, final int itemCol) {
    this(null, itemRow, itemCol);
  }

  public KioskGuidePanel(String title, final int itemRow, final int itemCol) {
    initGuidePanel(title);
    initItemPanel(itemRow, itemCol);
  }

  private void initGuidePanel(String title) {
    GUIDE_PANEL.setLayout(new BorderLayout());
    GUIDE_PANEL.setBackground(BACKGROUND_COLOR);
    if (title != null) {
      GUIDE_PANEL.add(new TitleLabel(title, JLabel.CENTER), BorderLayout.NORTH);
    }

    GUIDE_PANEL.setSize(guidePanelWidth, guidePanelHeight);
    GUIDE_PANEL.setLocation((MainFrame.FRAME_WIDTH - guidePanelWidth) / 2, MainFrame.FRAME_HEIGHT / 4);

    GUIDE_PANEL.add(ITEM_PANEL, BorderLayout.CENTER);
  }

  private void initItemPanel(final int row, final int col) {
    ITEM_PANEL.setLayout(new GridLayout(row, col));
  }

  public void addItem(Component... comps) {
    for (Component comp : comps) {
      ITEM_PANEL.add(comp);
    }
  }

  public void setTitleColor(Color color) {
    if (GUIDE_PANEL.getComponentCount() == 2) {
      GUIDE_PANEL.getComponent(0).setForeground(color);
    }
  }

  public void setGuidePanelSize(int width, int height) {
    guidePanelWidth = (width > 0) ? width : 0;
    guidePanelHeight = (height > 0) ? height : 0;

    GUIDE_PANEL.setSize(guidePanelWidth, guidePanelHeight);
  }

  public void setGuidePanelLocation(int x, int y) {
    x = (x > 0) ? x : 0;
    y = (y > 0) ? y : 0;

    GUIDE_PANEL.setLocation(x, y);
  }

  public Component getPanel() {
    return GUIDE_PANEL;
  }
}
