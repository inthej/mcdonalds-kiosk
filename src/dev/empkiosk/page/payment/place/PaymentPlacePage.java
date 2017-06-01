package dev.empkiosk.page.payment.place;

import dev.empkiosk.main.MainFrame;
import dev.empkiosk.page.ImageTextButton;
import dev.empkiosk.page.KioskGuidePanel;
import dev.empkiosk.page.KioskPage;
import dev.empkiosk.page.KioskVoice;
import dev.empkiosk.page.LangCheck;
import dev.empkiosk.page.eatplace.EatPlacePage;
import dev.empkiosk.page.order.OrderPage;
import dev.empkiosk.page.order.OrderPlace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 * Created by kimjaehyeon on 2017. 5. 20
 * Class Role : 결제장소 선택 페이지
 */
public class PaymentPlacePage extends KioskPage {

    private static final int MID_PANEL_WIDTH = KioskPage.PAGE_WIDTH * 4 / 5;
    private static final int MID_PANEL_HEIGHT = KioskPage.PAGE_HEIGHT * 2 / 5;

    private final KioskGuidePanel PAYMENT_SELECT_PANEL = new KioskGuidePanel(
            LangCheck.isKorean() ? "어디에서 지불하시겠습니까?" : "WHERE DO YOU WANT TO PAY?", 0, 2);

    private final ImageTextButton COUNTER_BUTTON = new ImageTextButton();
    private final ImageTextButton CARD_BUTTON = new ImageTextButton();

    public PaymentPlacePage() {
        initPaymentPlacePage();
        initPaymentSelectPanel();
        setListeners();
    }

    private void initPaymentPlacePage() {
        this.setBackgroundImg("image/bg_green.png");
        this.showBackgroundImg(true);
        this.showBackButton(true);

        KioskVoice.playSound(LangCheck.isKorean() ? "sound/pay.wav" : "sound/pay_eng.wav");
    }

    private void initPaymentSelectPanel() {
        initKioskButton();
        PAYMENT_SELECT_PANEL.addItem(COUNTER_BUTTON, CARD_BUTTON);
        PAYMENT_SELECT_PANEL.getPanel().setSize(MID_PANEL_WIDTH, MID_PANEL_HEIGHT);
        PAYMENT_SELECT_PANEL.getPanel()
                .setLocation((KioskPage.PAGE_WIDTH - MID_PANEL_WIDTH) / 2, KioskPage.PAGE_HEIGHT / 4);

        this.add(PAYMENT_SELECT_PANEL.getPanel());
    }

    private void initKioskButton() {
        final int BUTTON_WIDTH = MID_PANEL_WIDTH / 3;
        final int BUTTON_HEIGHT = MID_PANEL_HEIGHT / 2;

        COUNTER_BUTTON.setText(LangCheck.isKorean() ? "카운터에서 결제" : "PAYMENT AT THE COUNTER");
        COUNTER_BUTTON.setResizedImg(new ImageIcon("image/counter.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);

        CARD_BUTTON.setText("<html><center>" + (LangCheck.isKorean() ? "바로 결제<br>(카드 가능)"
                : "DIRECT PAYMENT IN KIOSK<br>(CARD)")
                + "</center></html>");
        CARD_BUTTON.setResizedImg(new ImageIcon("image/kiosk.jpg"), BUTTON_WIDTH, BUTTON_HEIGHT);
    }

    private void setListeners() {
        this.BACK_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.attachPanel(new EatPlacePage());
            }
        });

        COUNTER_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderPlace.getInstance().setPayPlace(PayPlace.COUNTER);
                MainFrame.attachPanel(new OrderPage());
            }
        });

        CARD_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderPlace.getInstance().setPayPlace(PayPlace.KIOSK);
                MainFrame.attachPanel(new OrderPage());
            }
        });
    }

    private static final long serialVersionUID = 2752774799931324880L;
}
