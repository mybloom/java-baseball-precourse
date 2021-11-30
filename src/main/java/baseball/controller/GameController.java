package baseball.controller;


import baseball.domain.Opponent;
import baseball.domain.Referee;

public class GameController {
	Opponent opponent;
	Referee referee;

	//게임 시작: 게임 넘버를 준비하고, 사용자 입력을 받는다.
	public void startGame(){
		opponent = new Opponent();
		referee = new Referee();
		String playNumberString = "";

		opponent.createGameNumber();
		playNumberString = referee.requestPlayerNumber();
		referee.checkPlayerNumber(opponent.getGameNumber(), playNumberString);
	}
}
