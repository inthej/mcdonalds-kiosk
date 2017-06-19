package dev.mcdonaldkiosk.main;

import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.welcome.WelcomePage;

import javax.swing.JFrame;

/**
 * Class Role : 프로그램에서 유일하게 사용되는 JFrome 컨테이너이다.
 * 프로그램의 구동 형태는 Main으로 사용되는 한 개의 JFrame에 KioskPage의 컴포넌트가 갱신되는 구조이다.
 * 맴버변수의 정의된 프레임의 사이즈는 다른 컴포넌트들의 사이즈 할당에 대상이 된다.
 *
 * @author Jaehyeon Kim
 * @see KioskPage
 * @since 2017. 05. 15.
 */
public final class MainFrame extends JFrame {

  public static final int FRAME_WIDTH = Display.WINDOWS_WIDTH / 2;
  public static final int FRAME_HEIGHT = Display.WINDOWS_HEIGHT;
  public static final int AVALIABLE_FRAME_HEIGHT = Display.WINDOWS_HEIGHT - Display.WINDOWS_BAR_HEIGHT;

  private static final MainFrame MAIN_FRAME = new MainFrame();
  private final String TITLE = "ORDER HERE!";

  private MainFrame() {
    initMainFrame();
  }

  private void initMainFrame() {
    this.setLayout(null);
    this.setTitle(TITLE);
    this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    this.setResizable(false); // 창 크기 조절
    this.setLocation((Display.WINDOWS_WIDTH - FRAME_WIDTH) / 2, 0);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(new WelcomePage(KioskPageType.WELCOME_PAGE));
  }

  public static void attachPanel(KioskPage page) {
    MAIN_FRAME.getContentPane().removeAll();
    MAIN_FRAME.add(page);

    // 갱신
    MAIN_FRAME.revalidate();
    MAIN_FRAME.repaint();
  }

  static void showFrame() {
    MAIN_FRAME.setVisible(true);
  }
}