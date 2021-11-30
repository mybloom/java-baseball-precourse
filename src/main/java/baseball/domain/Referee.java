package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.LinkedHashSet;

import baseball.utils.VaildChecker;
import camp.nextstep.edu.missionutils.Console;

public class Referee {
	VaildChecker validChecker = new VaildChecker();
	String inputPlayerString = "";

	//사용자 입력 요청
	public String requestPlayerNumber() {
		System.out.print(REQUEST_INPUT_MESSAGE);
		inputPlayerString = Console.readLine();

		return inputPlayerString;
	}

	//입력값 판별 - 유효성 체크 모든 단계 + integer형으로 변환해 리턴.
	public void checkPlayerNumber(String playerNumberString) {
		//[Q] validLength 체크할 때, 유효한 길이값을 메서드에 인자로 주는 것이 좋은지, 아님 체크하는 메서드에서 체크하는 게 좋은지.
		//전자인 것 같으나 , 해당 게임의 규칙이 여러 개가 아니므로 후자를 택함. -> 다시 전자로 택함.
		validChecker.isValidLength(playerNumberString, GAME_NUMBER_OF_DIGITS);
		LinkedHashSet<Integer> playerNumberSet = validChecker.checkIntegerTypeAndToSet(playerNumberString);
		validChecker.isValidLength(playerNumberSet, GAME_NUMBER_OF_DIGITS);
		validChecker.isValidRange(playerNumberSet, GAME_MIN_NUMBER, GAME_MAX_NUMBER);

		System.out.println("playerNumberSet:" + playerNumberSet);
	}

}
