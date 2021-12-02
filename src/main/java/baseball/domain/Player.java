package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class Player {
	public static final int NUMBER_OF_BASEBALL = 3;
	private final List<Baseball> baseballs = new ArrayList<>(NUMBER_OF_BASEBALL);

	//게임넘버(숫자/위치)->Baseballs 선택 : 컴퓨터
	public void createBaseballs() {
		Set<Integer> numbers = new HashSet<>();
		while (numbers.size() < NUMBER_OF_BASEBALL) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}

		Iterator<Integer> it = numbers.iterator();
		int position = 3;
		while (it.hasNext()) {
			baseballs.add(new Baseball(it.next(), position--));
		}

		System.out.println("computer.baseballs :" + baseballs);
	}

	//사용자 게임넘버 Baseball객체로 생성
	public void convertBaseballs(String userInput) {
		//123 이면, p3n1, p2n2, p1n3
		validateUserInput(userInput);

	}

	private void validateUserInput(String userInput) {
		Validator.length(userInput, NUMBER_OF_BASEBALL);
		Validator.isNumber(userInput);
		Validator.range(userInput, Baseball.MIN_VALUE_NUMBER, Baseball.MAX_VALUE_NUMBER);
		Validator.duplicateNumber(userInput);
	}

	//게임 재시작, 종료 선택
	public boolean chooseIsRestart() {

		return true;
	}
}
