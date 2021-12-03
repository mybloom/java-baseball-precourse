package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hint {
	Map<HintType, Integer> result;
	List<Baseball> computerBaseballs;
	List<Baseball> userBaseballs;

	public Hint(List<Baseball> computerBaseballs, List<Baseball> userBaseballs) {
		result = new HashMap<>();
		result.put(HintType.STRIKE, 0);
		result.put(HintType.BALL, 0);
		this.computerBaseballs = computerBaseballs;
		this.userBaseballs = userBaseballs;
	}

	//컴퓨터와 게임플레이어의 값 비교
	public Map<HintType, Integer> getResult() {
		compare();
		makeResult();
		return result;
	}

	private void compare() {
		int strikeCount = 0;
		int ballCount = 0;
		for (int cIdx = 0; cIdx < computerBaseballs.size(); cIdx++) {
			//strike
			if (computerBaseballs.get(cIdx).equals(userBaseballs.get(cIdx))) {
				strikeCount++;
				continue;
			}
			//ball
			for (Baseball userBaseball : userBaseballs) {
				ballCount += isBall(computerBaseballs.get(cIdx), userBaseball);
			}
		}
		result.put(HintType.STRIKE, strikeCount);
		result.put(HintType.BALL, ballCount);
	}

	private void makeResult() {
		if (result.get(HintType.STRIKE) == 0 && result.get(HintType.BALL) == 0) {
			result.put(HintType.NOTHING, 1);
		}
	}

	private int isBall(Baseball computerBaseball, Baseball userBaseball) {
		if (computerBaseball.position != userBaseball.position) {
			if (computerBaseball.number == userBaseball.number) {
				return 1;
			}
		}
		return 0;
	}

	//힌트 출력 giveHint, printHint 또는 hint.give() 로 할 수 있으니 give(),  print()
	public void printHint() {

	}

}
