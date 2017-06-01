package dev.empkiosk.page.thank;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextPanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.language.LangCheck;
import dev.empkiosk.page.order.CartPanel;
import dev.empkiosk.page.order.OrderPlace;
import dev.empkiosk.page.payment.place.PayPlace;
import dev.empkiosk.page.welcome.WelcomePage;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

/**
 * Created by kimjaehyeon on 2017. 5. 19
 * Class Role : 주문완료 페이지
 *
 * 특징 :
 * 1. KioskPage의 구성을 가지고 있다.
 * 2. ImageTextPanel의 특징을 가지고 있다.
 * 3. 주문 데이터가 초기화된다.
 */
public class ThankPage extends KioskPage {

    private final ImageTextPanel IMG_TEXT_PANEL = new ImageTextPanel(
            new ImageIcon("image/bg_info3.jpg"),
            LangCheck.isKorean() ? "주문이 완료되었습니다." : "YOUR ORDER IS COMPLETE");

    public ThankPage() {
        initPage();
        initImgTextPanel();

        setListener();
    }

    private void initPage() {
        this.showBackgroundImg(false);
        this.showBackButton(false);

        String orderPlace = OrderPlace.getInstance().getPayPlace();
        if (orderPlace == PayPlace.COUNTER.toString()) {
            KioskVoice.playSound(LangCheck.isKorean() ? "sound/counter.wav" : "sound/counter_eng.wav");
        } else if (orderPlace == PayPlace.KIOSK.toString()) {
            KioskVoice.playSound(LangCheck.isKorean() ? "sound/thank.wav" : "sound/thank_eng.wav");
        }

        CartPanel.clearOrderData();
    }

    private void initImgTextPanel() {
        IMG_TEXT_PANEL.setSize(KioskPage.PAGE_WIDTH, KioskPage.PAGE_HEIGHT);
        IMG_TEXT_PANEL.setLocation(0, 0);
        IMG_TEXT_PANEL.setTextBackground(Color.BLUE);

        this.add(IMG_TEXT_PANEL);
    }

    private void setListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                MainFrame.attachPanel(new WelcomePage());
            }
        });
    }
}
