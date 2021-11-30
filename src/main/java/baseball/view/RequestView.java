package baseball.view;

import static baseball.utils.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class RequestView {
	//게임번호 입력 요청
	public String requestPlayerNumber() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		return Console.readLine();
	}

	//재시작 여부 요청
	public String requestReStartGame() {
		return Console.readLine();
	}
	
}
