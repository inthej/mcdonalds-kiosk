package dev.mcdonaldkiosk.page.confirm;

import dev.mcdonaldkiosk.lang.LangCheck;
import dev.mcdonaldkiosk.main.MainFrame;
import dev.mcdonaldkiosk.page.KioskPageLoader;
import dev.mcdonaldkiosk.page.menu.MenuPage;
import dev.mcdonaldkiosk.page.menu.OrderPlace;
import dev.mcdonaldkiosk.page.payment.card.PaymentCardPage;
import dev.mcdonaldkiosk.page.payment.place.PayPlace;
import dev.mcdonaldkiosk.page.thank.ThankPage;
import dev.mcdonaldkiosk.util.KioskAudioPlayer;

/**
 * Class Role : ConfirmPage의 다음페이지 로드, 이전페이지 로드, 로드페이지 소리재생, 페이지 새로고침을 처리한다.
 * 
 * @author kimjaehyeon
 */
class ConfirmPageKioskPageLoader implements KioskPageLoader {

	@Override
	public void loadNextPage() {
		if (OrderPlace.getInstance().getPayPlace() == PayPlace.COUNTER.toString()) {
			MainFrame.attachPanel(new ThankPage());
		} else if (OrderPlace.getInstance().getPayPlace() == PayPlace.KIOSK.toString()) {
			MainFrame.attachPanel(new PaymentCardPage());
		}
	}

	@Override
	public void loadPreviousPage() {
		MainFrame.attachPanel(new MenuPage());
	}

	@Override
	public void playLoadPageSound() {
		KioskAudioPlayer kioskAudioPlayer = KioskAudioPlayer
				.createKioskAudioPlayer(LangCheck.isKorean() ? "sound/check.wav" : "sound/check_eng.wav");
		kioskAudioPlayer.play();
	}

	@Override
	public void refreshPage() {
		// TODO Auto-generated method stub
	}
}
