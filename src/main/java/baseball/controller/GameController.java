package baseball.controller;


import java.util.HashMap;

import baseball.domain.Opponent;
import baseball.domain.Referee;
import baseball.view.ResponseView;

public class GameController {
	Opponent opponent;
	Referee referee;
	ResponseView responseView;

	//게임 시작: 게임 넘버를 준비하고, 사용자 입력을 받는다.
	public void startGame(){
		opponent = new Opponent();
		referee = new Referee();
		responseView = new ResponseView();

		opponent.createGameNumber();
		String playNumberString = referee.requestPlayerNumber();
		HashMap<String, Integer> answerMap =  referee.checkPlayerNumber(opponent.getGameNumber(), playNumberString);

		responseView.responseAnswer(answerMap);
	}
}
