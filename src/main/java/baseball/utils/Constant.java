package baseball.utils;

public class Constant {
	//game Rule
	public static final int GAME_NUMBER_OF_DIGITS = 3;
	public static final int GAME_MIN_NUMBER = 1;
	public static final int GAME_MAX_NUMBER = 9;

	//request Message
	public static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";

	//response Message
	public static final String RESPONSE_NOTHING_MESSAGE = "낫싱";
	public static final String RESPONSE_STRIKE_MESSAGE = "스트라이크";
	public static final String RESPONSE_BALL_MESSAGE = "볼";
	public static final String RESPONSE_CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	public static final String RESPONSE_START_AGAIN_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	//error Message
	public static final String INVALID_LENGTH_MESSAGE = "Inputted String is not vaild length.";
	public static final String INVALID_FORMAT_MESSAGE = "전달된 값이 숫자가 아닙니다.";
	public static final String INVALID_RANGE_MESSAGE = "유효한 범위의 숫자가 아닙니다.";
	public static final String INVALID_DUPLICATED_MESSAGE = "중복된 숫자를 입력하였습니다.";
}
