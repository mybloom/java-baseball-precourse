package baseball.service;

import java.util.List;
import java.util.Map;

import baseball.domain.Baseball;
import baseball.domain.Hint;
import baseball.domain.HintType;
import baseball.domain.Player;

//도메인 간 순서 보장 : 흐름제어
public class GameService {
	//도메인 객체 생성
	Player computer = new Player();
	Player user = new Player();
	Hint hint;
	//인스턴스 변수로 있어야할까, 좋은 방법은 없을까
	List<Baseball> computerBaseballs;
	List<Baseball> userBaseballs;

	//게임 진행 flow

	//컴퓨터 게임숫자 선택
	public void createBaseballs() {
		computerBaseballs = computer.createBaseballs();
	}

	//사용자 입력값 게임숫자로 변환, + 힌트얻기 > 한 메서드에 2개 기능
	public void convertBaseballs(String userInput) {
		userBaseballs = user.convertBaseballs(userInput);
		hint = new Hint(computerBaseballs, userBaseballs);
		Map<HintType, Integer> hintResult =  hint.getResult();

		System.out.println("hint.result:" + hintResult);
	}

	//user Baseballs값 힌트얻기
	public void getHint() {

	}

	//입력값이 정답이 될때까지 반복

	//게임 재시작 여부 입력값에 대한 유효성 체크. 앞에 객체명.checkValid()에서 더 쉽게 알거나 메소드명에 목적어가 들어가거나 (무엇을 체크한다는)
	private void checkValid() {

	}

	//게임 재시작
	private void reStart() {

	}

	//게임 종료
	private void stop() {

	}
}
