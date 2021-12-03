package baseball.service;

import java.util.List;
import java.util.Map;

import baseball.domain.Baseball;
import baseball.domain.Hint;
import baseball.domain.HintType;
import baseball.domain.Player;
import baseball.view.OutputView;

//도메인 간 순서 보장 : 흐름제어
public class GameService {
	//도메인 객체 생성
	Player computer = new Player();
	Player user = new Player();
	Hint hint;
	OutputView outputView = new OutputView();
	//인스턴스 변수로 있어야할까, 좋은 방법은 없을까
	List<Baseball> computerBaseballs;
	List<Baseball> userBaseballs;

	//컴퓨터 게임숫자 선택
	public void createBaseballs() {
		computerBaseballs = computer.createBaseballs();
	}

	//사용자 입력값 게임숫자로 변환, + 힌트얻기 > 한 메서드에 2개 기능
	public Map<HintType, Integer> convertBaseballs(String userInput) {
		userBaseballs = user.convertBaseballs(userInput);
		hint = new Hint(computerBaseballs, userBaseballs);

		return hint.getResult();
	}

	//힌트 출력
	public void responseHint() {
		outputView.responseHint(hint);
	}

	//게임 재시작 여부
	public void isReStart(String userInput) {
		user.chooseIsRestart(userInput);
	}

	//게임 종료
	private void stop() {

	}
}
