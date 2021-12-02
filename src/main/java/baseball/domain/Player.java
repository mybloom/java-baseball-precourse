package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Player {
	private final List<Baseball> baseballs = new ArrayList<>(3);

	//게임넘버(숫자/위치)->Baseballs 선택 : 컴퓨터
	public void createBaseballs() {
		Set<Integer> numbers = new HashSet<>();
		while (numbers.size() < 3) {
			numbers.add(Randoms.pickNumberInRange(1, 9));
		}

		Iterator<Integer> it = numbers.iterator();
		int position = 3;
		while (it.hasNext()) {
			baseballs.add(new Baseball(it.next(), position--));
		}

		System.out.println("computer.baseballs :" + baseballs);
	}

	//사용자 게임넘버 Balseball객체로 생성
	public void chooseBaseballs(String userNumber) {
		//123 이면, p3n1, p2n2, p1n3
		

	}

	//게임 재시작, 종료 선택
	public boolean chooseIsRestart() {

		return true;
	}
}
