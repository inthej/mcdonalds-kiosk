package dev.mcdonaldkiosk.page.menu;

import dev.mcdonaldkiosk.page.KioskPageType;
import dev.mcdonaldkiosk.page.menu.order.CartPanel;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPage;
import dev.mcdonaldkiosk.page.menu.order.OrderDataModel;

/**
 * Class Role : 메뉴를 선택할 수 있는 메뉴페이지의 구성을 가지고 있다.
 * 기본 레이아웃은 BorderLayout 이며
 * 상단 이미지베너 라벨, 중간 메뉴탭(MenuTabbedPane) 페인, 하단 장바구니(Cart) 패널로 구성되어 있다.
 *
 * @author Jaehyeon, Kim
 */

/**
 * 
 *  (Class Role : 메뉴관련 페이지이다.) 라는 말만 들어서 이 클래스가 무엇인지 설명 할 수 있을까요?? 
 * MenuPage라는 이름은 나쁘진 않습니다만, 이 페이지가 담당하고 처리하는 일이 무엇인지는 적어주셔야 합니다.
 * 정보가 너무 없어서, 저는 프로그램을 직접 켜보고 하나씩 추적해서 이 클래스가 담당하는 구역을 찾았습니다.
 * 
 *  클래스의 설명이 부족하면, 클래스는 정체성을 잃게 되구요, 정체성을 잃으면 캡슐화가 깨지게 됩니다.
 * 이 클래스가 가지고 있는 하위 멤버변수도 이름이 너무 않좋습니다. 프로그램을 직접 켜보고 담당 구역을 찾았지만,
 * 어디가 어디인지 코드를 까보고 알았습니다. 멤버변수를 잘 표현 하셨다면 더 쉬웠을텐데요.
 * 
 *  MenuPage의 구성자체는 좋습니다 만, 객체지향의 본질인 인간이 이해가능한 코드를 '잘'짜진 못했습니다.
 * 인간이 이해가능 하려면 표현이 좋아야 하고, 표현을 이해하려면 코드를 짜는 사람이 확실한 이해를 해야하는것이지요.
 * 하지만, 더 중요한것은 그 이해한걸 표현하는것 입니다. 마치 처음보는 사람이 형 코드를 읽었을때 바로 이해할 수 있도록이요.
 * 
 *  MenuPage의 구성은 크게,
 * 상단 : 이미지 배너
 * 메인 : 메뉴 테이블
 * 하단 : 선택한 주문 안내 창과 주문을 취소,진행 할 수 있는 컨트롤 패널
 * 
 * 이렇게 3가지 입니다. 그 3가지를 나타낼 수 있게 코드를 짜셨어야 합니다.
 * 
 *  첫번째 매개변수 IMAGE_LABEL이란 멤버변수는 과연 상단 이미지 배너라고 제가 생각 할 수 있었을까요?
 * LABEL은 텍스트를 넣는 것이지 ImageView처럼 쓰는게 사실상 아닙니다. 
 * 하지만 이런식으로 이미지를 위해 JLabel 객체자체는 쓸 순 있어요. 그렇다면 이름을 잘 지으셨어야죠.
 * 저는 Text가 들어가는 줄 알았습니다. 프로그램을 보기전까지는
 * 반면에, 이름을 IAMGE_LAEL대신 TOP_IMAGE_BANNER라고 이름을 지었으면 어땠을까요?
 * 저는 Text가 들어간다곤 생각 안하고 그냥 JLabel을 이미지배너처럼 쓰는구나 하고 넘어갔을 것입니다.
 * 
 *  Scroll객체는 위에서 설명한 3가지 구성중 메인패널이 가져야할 속성입니다.
 * 왜 MenuPage가 이 스크롤패널을 보관해야 하는가요?
 * MenuTabbedPane 이라는 이름 보다는 ScrollableMenuPane의 이름을 지어서 (스크롤가능한 메뉴판)
 * 그 패널자체를 스크롤 가능하게 만드는것이 중요합니다.
 * 캡슐화가 부족했던 것이지요. 이런식의 책임전가는 항상 형이 실수 하는것 중 하납니다. 
 * 이제 또 실수를 하게 되면 실력이 되버립니다. 잘 안되면 외우세요.
 * 
 *  MyOrderPanel이란 이름은 뭔가요? My의 주체는 개발자 자신입니다. 프로그램을 쓰는 User 대상이 아니란 말이죠.
 * OrderPanel 은 주문패널이라는 뜻 입니다.
 * 하지만 형이 만들어야 할 OrderPanel 의 역할은 선택한 주문 안내 창과 주문을 취소,진행 할 수 있는 컨트롤 할 수 있는 패널을 만드는것이지요.
 * 솔직히, 크게 2가지로 나눈 기능을 하나의 클래스로 담고, 이름짓기가 쉽진 않습니다. 
 * 따라서, SelectedOrderGuidePanel 과 OrderTakeControlPanel 과 같이 2개로 나눠서 클래스화 해도 나쁘지 않습니다.
 * 뭐 한꺼번에 나타낼 수 있는 좋은 이름이 있다면 상관 없습니다.
 *  
 *  MenuPage가 OrderDataModel을 가지고 있기 때문에, View이자 Controller 역할을 수행해야 합니다.
 * 컨트롤러의 역할은 유저의 액션을 받았을시, model을 호출한 후 그 model의 데이터 값을 토데로 갱신해야할 View를
 * 갱신해주는 역할을 합니다. 즉, MenuPage가 컨트롤러 대장으로써, MenuPage가 View들을 refresh 해줘야하죠.
 * 하지만 형이 코딩한 MVC패턴은 컨트롤러가 존재 하지 않고 Model이 이곳저곳 퍼져있으며, 갱신하는 방법도 각기 다름니다.
 * (이해가 가지 않거나, 이해가 가지만 코딩이 안된다면 일단 넘어가세요.)
 *  
 *  또한 메서드 이름을 지을때는 항상 신경써서 지어주세요. 복붙식이나, 생각나는데로 짓지말구요.
 * 아래의 setLayout() 메서드는 이름을 잘못지은거 같습니다.
 * 계속 이런 실수가 나온다면, 그것은 실수가 아니라 실력이 됩니다. 신경써야 한다는걸 메모에 적어두거나 외우세요.
 *  
 *  
 *  ## 지금까지 쭉 설명을 했지만, 제가 쓴 글의 목적이 뭔지 이해한걸 저한테 카톡으로 알려주셨으면 합니다.
 *  ## 형의 약점중 하나가, 글을 그냥 그뜻으로만 이해한다는 뜻입니다. 제가 이 글을 왜 쓰게 됬고,
 *  ## 이 글이 궁극적으로 의마하는게 무엇인가 생각해보세요. 이 글은 분명 MenuPage의 캡슐화를 다룬 글이지만,
 *  ## MenuPage의 캡슐화 목적으로만 읽으면 곤란합니다.
 *
 */
public class MenuPage extends KioskPage {

  private final OrderDataModel orderDataModel = new OrderDataModel(this);

  private final ImageIcon bannerImageIcon = new ImageIcon("image/banner_top.jpg");
  private final MenuTabbedPane menuTabbedPane = new MenuTabbedPane(orderDataModel);
  private final CartPanel cartPanel = new CartPanel(orderDataModel);

  public MenuPage(KioskPageType kioskPageType) {
    super(kioskPageType);
    initPage();
    setLayout();
  }

  private void initPage() {
    this.setLayout(new BorderLayout());
    this.add(createImageLabel(bannerImageIcon), BorderLayout.NORTH);
    this.add(menuTabbedPane, BorderLayout.CENTER);
    this.add(cartPanel, BorderLayout.SOUTH);
  }

  private JLabel createImageLabel(final ImageIcon imageIcon) {
    final JLabel imageLabel = new JLabel(
        this.imageEdit.getResizeIcon(imageIcon, MainFrame.FRAME_WIDTH, MainFrame.FRAME_HEIGHT / 5));

    imageLabel.add(BACK_BUTTON);

    return imageLabel;
  }

  private void setLayout() {
    this.BACK_BUTTON.addActionListener((e) -> {
      orderDataModel.clear();
      currentPage.loadPreviousPage();
    });
  }
}
