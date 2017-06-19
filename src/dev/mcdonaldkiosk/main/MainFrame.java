package dev.mcdonaldkiosk.main;

import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.start.StartPage;

import javax.swing.JFrame;

/**
 * Class Role : KioskPage 컴포넌트를 보여줄 수 있는 JFrame 타입의 컨테이너이다.
 * KioskPage를 보여주기 이전에 올려두었던건 KioskPage는 지워진다.
 *
 * 맴버변수의 정의된 프레임의 사이즈는 다른 컴포넌트들의 사이즈 할당에 대상이 된다.
 *
 * @author Jaehyeon Kim
 * @see KioskPage
 * @since 2017. 05. 15.
 */
public final class MainFrame extends JFrame {

  public static final int FRAME_WIDTH = Display.WINDOWS_WIDTH / 2;
  public static final int FRAME_HEIGHT = Display.AVALIABLE_WINDOWS_HEIGHT;

  private static final MainFrame MAIN_FRAME = new MainFrame();
  private final String TITLE = "ORDER HERE!";

  private MainFrame() {
    initMainFrame();
  }

  private void initMainFrame() {
    this.setLayout(null);
    this.setTitle(TITLE);
    this.setSize(FRAME_WIDTH, Display.WINDOWS_HEIGHT);
    this.setResizable(false); // 창 크기 조절
    this.setLocation((Display.WINDOWS_WIDTH - FRAME_WIDTH) / 2, 0); // 중앙으로 위치하는 연산식
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.add(new StartPage());
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