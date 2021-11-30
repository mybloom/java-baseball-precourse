package baseball.controller;


import baseball.domain.Opponent;
import baseball.domain.Player;

public class GameController {
	Opponent opponent;
	Player player;

	//게임 시작을 위해 사용자 입력을 받는다.
	public void startGame(){
		opponent = new Opponent();
		opponent.createGameNumber();
		opponent.requestPlayNumber();
	}
}
