package dev.mcdonaldkiosk.page.menu.order;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class Role : TextLabel을 ToolBar형식으로 제공하는 패널이다.
 *
 * 특징 -
 * 1. 입력된 텍스트의 갯수만큼 GridLayout(0, textCnt) 형식의 레이아웃이 사용된다.
 * 2. 입력된 텍스트는 지정된 라벨의 디자인으로 툴바에 추가된다.
 *
 * 기능 -
 * 텍스트입력을 제공한다.
 *
 * @author Jaehyeon Kim
 */
class TextToolbarPanel {

  private final JPanel TEXT_TOOLBAR_PANEL = new JPanel();

  private final Color BG_COLOR = Color.BLACK;
  private final Color TEXT_COLOR = Color.WHITE;

  private int textCnt;

  TextToolbarPanel() {
    initTextToolbarPanel();
  }

  private void initTextToolbarPanel() {
    TEXT_TOOLBAR_PANEL.setBackground(BG_COLOR);
  }

  TextToolbarPanel addText(String text) {
    TEXT_TOOLBAR_PANEL.setLayout(new GridLayout(0, ++textCnt));
    TEXT_TOOLBAR_PANEL.add(createDesignedLabel(text));

    return this;
  }

  private JLabel createDesignedLabel(String text) {
    JLabel label = new JLabel(text, JLabel.CENTER);
    label.setForeground(TEXT_COLOR);

    return label;
  }

  Component getPanel() {
    return TEXT_TOOLBAR_PANEL;
  }
}
