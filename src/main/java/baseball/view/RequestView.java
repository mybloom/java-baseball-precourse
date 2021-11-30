package baseball.view;

import static baseball.utils.Constant.*;

import camp.nextstep.edu.missionutils.Console;

public class RequestView {
	//사용자 입력 요청
	public String requestPlayerNumber() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		String inputPlayerString = Console.readLine();

		return inputPlayerString;
	}
}
