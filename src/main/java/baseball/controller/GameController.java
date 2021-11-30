package baseball.controller;


import java.util.HashMap;

import baseball.domain.Opponent;
import baseball.domain.Referee;
import baseball.utils.Constant;
import baseball.view.RequestView;
import baseball.view.ResponseView;

public class GameController {
	private Opponent opponent;
	private Referee referee;
	private RequestView requestView;
	private ResponseView responseView;
	private boolean isGameStart;

	//main()통신
	public void startProgram(){
		isGameStart = true;

		while(isGameStart){
			startGame();
			isGameStart = isReStartGame();
		}
	}

	//게임 시작: 게임 넘버를 준비하고, 사용자 입력을 받는다.
	private void startGame(){
		opponent = new Opponent();
		referee = new Referee();
		requestView = new RequestView();
		responseView = new ResponseView();
		HashMap<String, Integer> answerMap = new HashMap<>();

		//1 게임번호 설정
		opponent.createGameNumber();

		while(!(answerMap.containsKey(Constant.RESPONSE_STRIKE_MESSAGE) && answerMap.get(Constant.RESPONSE_STRIKE_MESSAGE) == 3)){
			//2 사용자 정답 입력 요청
			String playNumberString = requestView.requestPlayerNumber();
			//3.4. 사용자 입력값 유효성/정답 판별
			answerMap =  referee.checkPlayerNumber(opponent.getGameNumber(), playNumberString);
			//5. 정답 판별값 출력
			responseView.responseAnswer(answerMap);
		}
	}

	//게임 재시작 또는 종료
	private boolean isReStartGame(){
		//6.게임 재시작 여부 요청
		String gameReStartYn = requestView.requestReStartGame();
		//유효성 체크
		referee.checkReStartGame(gameReStartYn);
		if(gameReStartYn.trim().equals("1")){
			//게임 재시작
			return true;
		}
		return false;
	}
}
