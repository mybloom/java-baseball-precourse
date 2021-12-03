package baseball.controller;

import static baseball.view.OutputView.*;

import java.util.HashMap;
import java.util.Map;

import baseball.domain.HintType;
import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

//외부 요청/응답에 대한 전반적 영역
public class GameController {
	private GameService gameService = new GameService();

	//게임 실행
	public void run() {
		Map<HintType, Integer> resultHint = new HashMap<>();

		gameService.createBaseballs();
		while (resultHint.getOrDefault(HintType.STRIKE, 0) < 3) {
			resultHint = gameService.convertBaseballs(requestBaseballs());
			gameService.responseHint();
		}
	
		//구현중
		gameService.isReStart(requestIsRestart());
	}

	//사용자가 숫자 입력하도록 입력 메세지 송출
	private String requestBaseballs() {
		System.out.print(REQUEST_BASEBALLS_MESSAGE);
		return Console.readLine().trim();
	}

	//게임 종료 후, 게임재시작 여부 요청
	private String requestIsRestart() {
		return Console.readLine().trim();
	}
}
