package baseball.service;

import baseball.domain.Player;

//도메인 간 순서 보장 : 흐름제어
public class GameService {
	//도메인 객체 생성
	Player computer = new Player();
	String userInput = "";

	//게임 진행 flow
	private void doGame() {
		//컴퓨터 게임숫자 선택
		computer.createBaseballs();
		//사용자 입력값 게임숫자로 변환

	}

	public void setUserNumber(String userInput) {
		this.userInput = userInput;
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
