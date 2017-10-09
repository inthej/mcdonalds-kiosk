package dev.mcdonaldkiosk.main;

import javax.swing.JFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.start.StartPage;

/**
 * Class Role : KioskPage 컴포넌트를 구성하는 컨테이너
 * 
 * @author Jaehyeon Kim
 * @since 2017. 05. 15.
 */
public final class MainFrame extends JFrame {
  
  public static final MainFrame INSTANCE = new MainFrame();
  
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