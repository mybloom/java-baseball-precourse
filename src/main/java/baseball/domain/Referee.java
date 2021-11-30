package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import baseball.utils.Constant;
import baseball.utils.VaildChecker;
import camp.nextstep.edu.missionutils.Console;

public class Referee {
	VaildChecker validChecker = new VaildChecker();
	String inputPlayerString = "";
	HashMap<String, Integer> answerMap = new HashMap<>();

	//사용자 입력 요청
	public String requestPlayerNumber() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		inputPlayerString = Console.readLine();

		return inputPlayerString;
	}

	//입력값 판별
	public HashMap<String, Integer> checkPlayerNumber(LinkedHashSet<Integer> gameNumberSet, String playerNumberString) {
		LinkedHashSet<Integer> playerNumberSet;

		//[Q] validLength 체크할 때, 유효한 길이값을 메서드에 인자로 주는 것이 좋은지, 아님 체크하는 메서드에서 체크하는 게 좋은지.
		validChecker.isValidLength(playerNumberString, GAME_NUMBER_OF_DIGITS);
		playerNumberSet = validChecker.checkIntegerTypeAndToSet(playerNumberString);
		validChecker.isValidLength(playerNumberSet, GAME_NUMBER_OF_DIGITS);
		validChecker.isValidRange(playerNumberSet, GAME_MIN_NUMBER, GAME_MAX_NUMBER);

		checkCorrect(gameNumberSet, playerNumberSet);

		return answerMap;
	}

	private void checkCorrect(LinkedHashSet<Integer> gameNumberSet, LinkedHashSet<Integer> playerNumberSet) {
		List<Integer> gameNumberList = new ArrayList<>(gameNumberSet);
		List<Integer> playerNumberList = new ArrayList<>(playerNumberSet);

		HashMap<String, Integer> correctResult = new HashMap<>();
		for (int gIdx = 0; gIdx < gameNumberList.size(); gIdx++) {
			for (int pIdx = 0; pIdx < playerNumberList.size(); pIdx++) {
				boolean isEqualNumber = isEqualNum(gameNumberList.get(gIdx), playerNumberList.get(pIdx));
				boolean isEqualIndex = isEqualNum(gIdx, pIdx);

				handleStrikeOrBall(isEqualNumber, isEqualIndex);
			}
		}
	}

	//[Q]아래 3개의 메소드가 여기에 있어야 할까? ValidChecker에 있어야 할까?
	private boolean isEqualNum(Integer num1, Integer num2) {
		return num1.equals(num2);
	}

	private void handleStrikeOrBall(boolean isEqualNumber, boolean isEqualIndex) {
		if (isEqualNumber && isEqualIndex) {
			answerMap.put(Constant.RESPONSE_STRIKE_MESSAGE,
				answerMap.getOrDefault(Constant.RESPONSE_STRIKE_MESSAGE, 0) + 1);
		}

		if (isEqualNumber && !isEqualIndex) {
			answerMap.put(Constant.RESPONSE_BALL_MESSAGE,
				answerMap.getOrDefault(Constant.RESPONSE_BALL_MESSAGE, 0) + 1);
		}
	}
}
