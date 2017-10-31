package dev.mcdonaldkiosk.main;

import javax.swing.JFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.start.StartPage;
import dev.mcdonaldkiosk.util.Display;

/**
 * Class Role : 프로그램이 구동되면 보여지는 프레임이다.
 * 
 * @author Jaehyeon Kim
 */
public class MainFrame extends JFrame {
  
  MainFrame() {
    init();
    setLocationByCenter();
    addPage(new StartPage());
  }

  private void init() {
    this.setLayout(null);
    this.setTitle("ORDER HERE!");
    this.setSize(Display.WINDOWS_HALF_WIDTH, Display.WINDOWS_HEIGHT);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private void setLocationByCenter() {
    this.setLocation(Display.WINDOWS_HALF_WIDTH / 2, 0);
  }
  
  public void attachPage(KioskPage page) {
    removeAllComponents();
    addPage(page);
    refresh();
  }
  
  private void removeAllComponents() {
    this.getContentPane().removeAll();
  }
  
  private void addPage(KioskPage page) {
    page.setMainFrame(this);
    this.getContentPane().add(page);
  }
  
  private void refresh() {
    this.revalidate();
    this.repaint();
  }
}