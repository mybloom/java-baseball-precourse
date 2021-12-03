package baseball.domain;

import static baseball.utils.Constant.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import baseball.utils.Validator;
import camp.nextstep.edu.missionutils.Randoms;

public class Player {
	private List<Baseball> baseballs;

	//게임넘버(숫자/위치)->Baseballs 선택 : 컴퓨터
	public List<Baseball> createBaseballs() {
		Set<Integer> numbers = createNumbers();

		baseballs = new ArrayList<>(NUMBER_OF_BASEBALL);
		Iterator<Integer> it = numbers.iterator();
		int position = NUMBER_OF_BASEBALL;
		while (it.hasNext()) {
			baseballs.add(new Baseball(it.next(), position--));
		}

		System.out.println("computer.baseballs :" + baseballs);
		return baseballs;
	}

	private Set<Integer> createNumbers() {
		Set<Integer> numbers = new HashSet<>();
		while (numbers.size() < NUMBER_OF_BASEBALL) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}
		return numbers;
	}

	//사용자 게임넘버 Baseball객체로 생성
	public List<Baseball> convertBaseballs(String userInput) {
		//123 이면, n1p3, n2p2, n3p1
		validateGameNumber(userInput);

		baseballs = new ArrayList<>(NUMBER_OF_BASEBALL);
		int position = NUMBER_OF_BASEBALL;
		for (char chr : userInput.toCharArray()) {
			baseballs.add(new Baseball(Validator.toInt(chr), position--));
		}

		System.out.println("user.baseballs:" + baseballs);
		return baseballs;
	}

	private void validateGameNumber(String userInput) {
		Validator.length(userInput, NUMBER_OF_BASEBALL);
		Validator.isNumber(userInput);
		Validator.range(userInput, Baseball.MIN_VALUE_NUMBER, Baseball.MAX_VALUE_NUMBER);
		Validator.duplicateNumber(userInput);
	}

	public boolean chooseIsRestart(String userInput) {
		validateIsRestart(userInput);
		if(Validator.toInt(userInput.charAt(0)) == INPUT_FOR_RESTART){
			return true;
		}
		return false;
	}

	private void validateIsRestart(String userInput) {
		Validator.isNumber(userInput);
		Validator.range(userInput, INPUT_FOR_RESTART, INPUT_FOR_FINISH);
	}
}
