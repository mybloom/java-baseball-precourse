package baseball.view;

import java.util.Map;

import baseball.domain.Hint;
import baseball.domain.HintType;

public class OutputView {
	private Hint hint;
	//요청메세지
	public static final String REQUEST_BASEBALLS_MESSAGE = "숫자를 입력해주세요 : ";

	//사용자 입력값에 대한 응답메세지
	public static final String STRIKE_MESSAGE = "스트라이크";
	public static final String BALL_MESSAGE = "볼";
	public static final String NOTHING_MESSAGE = "낫싱";

	public static final StringBuilder successMessage = new StringBuilder();

	static {
		successMessage.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		successMessage.append(System.getProperty("line.separator"));
		successMessage.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public void responseHint(Hint hint) {
		Map<HintType, Integer> result = hint.getResult();
		if (result.get(HintType.NOTHING) > 0) {
			System.out.println(NOTHING_MESSAGE);
			return;
		}
		if (result.get(HintType.BALL) > 0) {
			System.out.print(result.get(HintType.BALL) + BALL_MESSAGE + " ");
		}

		if (result.get(HintType.STRIKE) > 0) {
			System.out.println(result.get(HintType.STRIKE) + STRIKE_MESSAGE + "");
		}

		if (result.get(HintType.STRIKE) == 3) {
			System.out.println(successMessage);
		}
	}

}
