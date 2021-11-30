package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.LinkedHashSet;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Opponent {
	//[Q]초기화 하는게 좋을까? 안하는게 좋을까? -> 안하는 게 좋을 것 같다. 이유는 공부해서 적어놓자.
	private LinkedHashSet<Integer> gameNumber;

	//서로 다른 3자리 수 설정
	public void createGameNumber() {
		gameNumber = new LinkedHashSet<>();
		while (gameNumber.size() < GAME_DIGITS) {
			gameNumber.add(Randoms.pickNumberInRange(GAME_MIN_NUMBER, GAME_MAX_NUMBER));
		}
	}

	//사용자 입력 요청
	public void requestPlayNumber() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		Console.readLine();
	}
}
