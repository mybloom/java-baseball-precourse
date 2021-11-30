package baseball.controller;


import java.util.HashMap;

import baseball.domain.Opponent;
import baseball.domain.Referee;
import baseball.utils.Constant;
import baseball.view.RequestView;
import baseball.view.ResponseView;

public class GameController {
	Opponent opponent;
	Referee referee;
	RequestView requestView;
	ResponseView responseView;

	//게임 시작: 게임 넘버를 준비하고, 사용자 입력을 받는다.
	public void startGame(){
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
}
