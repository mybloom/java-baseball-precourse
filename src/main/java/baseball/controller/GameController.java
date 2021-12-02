package baseball.controller;

import static baseball.view.OutputView.*;

import baseball.service.GameService;
import camp.nextstep.edu.missionutils.Console;

//외부 요청/응답에 대한 전반적 영역
public class GameController {
	private GameService gameService = new GameService();

	//사용자가 숫자 입력하도록 입력 메세지 송출
	public void requestBaseballs() {
		System.out.println(REQUEST_BASEBALLS_MESSAGE);
		String numbers = Console.readLine();

		gameService.setUserNumber(numbers.trim());
	}

	//게임 종료 후, 게임재시작 여부 요청// 또는 getIsRestart() 이건 Controller로 가도 되는 듯.
	public void requestIsRestart() {

	}
}
