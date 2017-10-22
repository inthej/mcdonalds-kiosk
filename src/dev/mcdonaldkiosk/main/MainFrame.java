package dev.mcdonaldkiosk.main;

import javax.swing.JFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.start.StartPage;

/**
 * class role : 프로그램이 구동되면 보여지는 기본 프레임이다.
 * KioskPage View 컴포넌트 구성할 수 있다.
 * 
 * @author Jaehyeon Kim
 */
public final class MainFrame extends JFrame {
  
  private static final MainFrame INSTANCE = new MainFrame();
  
  public static final MainFrame getInstance() {
    return INSTANCE;
  }
  
  private MainFrame() {
    initMainFrame();
    setLocationByCenter();
    addStartPage();
  }

  private void initMainFrame() {
    this.setLayout(null);
    this.setTitle("ORDER HERE!");
    this.setSize(Display.WINDOWS_WIDTH_HALF, Display.WINDOWS_HEIGHT);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private void setLocationByCenter() {
    this.setLocation((Display.WINDOWS_WIDTH - Display.WINDOWS_WIDTH_HALF) / 2, 0);
  }
  
  private void addStartPage() {
    this.getContentPane().add(new StartPage());
  }

  public static void attachPanel(final KioskPage page) {
    INSTANCE.getContentPane().removeAll();
    INSTANCE.getContentPane().add(page);

    refresh();
  }
  
  private static void refresh() {
    INSTANCE.revalidate();
    INSTANCE.repaint();
  }
  
  static void start() {
    INSTANCE.setVisible(true);
  }
}