package dev.empkiosk.page.order;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import dev.empkiosk.page.ImageEdit;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.util.KioskAudioPlayer;

/**
 * Create by kimjaehyeon
 * Class Role : 메뉴들은 각각의 버튼으로 구성되어있다.
 * 해당 메뉴버튼을 담당하는 클래스이다.
 */
public class MenuButton extends JButton {

    private static final int BUTTON_WIDTH = KioskPage.PAGE_WIDTH / 5;
    private static final int BUTTON_HEIGHT = KioskPage.PAGE_HEIGHT / 10;

    private static final  String PRICE_FONT_COLOR = "red";

    private final String IMG_PATH;
    private final OrderData ORDER_DATA;

    private final KioskAudioPlayer clickBGMPlayer = KioskAudioPlayer.createKioskAudioPlayer("sound/beep.wav");
    private final OrderDataList ORDER_DATA_LIST = new OrderDataList();
    private final CartPanel CART_PANEL = new CartPanel();

    MenuButton(String imgPath, OrderData ORDER_DATA) {
        this.IMG_PATH = imgPath;
        this.ORDER_DATA = ORDER_DATA;

        initMenuButton();
        setListener();
    }

    private void initMenuButton() {
        this.setIcon(ImageEdit.getResizeIcon(IMG_PATH, BUTTON_WIDTH, BUTTON_HEIGHT));
        this.setText(ORDER_DATA.toMenuButtonText(PRICE_FONT_COLOR));
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);

        this.setBackground(Color.WHITE);
        this.setBorderPainted(false);
    }

    private void setListener() {
        this.addActionListener((e) -> {
            /*
             * TODO
             * 사운드
             * 주문데이터 입력
             * 화면갱신 & 스크롤 최하단
             */

            /* 음원에 관련된건 음원관련 객체에게 맡긴다. */
            clickBGMPlayer.play();

            // 주문데이터를 장바구니에 넣는다.
            CART_PANEL.addOrderData(ORDER_DATA);

            // 스크롤바를 최하단 & 데이터라벨 갱신.
            CART_PANEL.getOrderScrollPanel().scrollDown();
            CART_PANEL.getOrderConfirmPanel().refleshDataLabel();
        });
    }
}
