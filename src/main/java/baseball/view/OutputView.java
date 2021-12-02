package baseball.view;

public class OutputView {
	//요청메세지
	public static final String requestBaseballsMessage = "숫자를 입력해주세요 : ";

	//사용자 입력값에 대한 응답메세지
	public static final String strike = "스트라이크";
	public static final String ball = "볼";
	public static final String nothing = "낫싱";

	public static final StringBuilder successMessage = new StringBuilder();

	static {
		successMessage.append("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		successMessage.append(System.getProperty("line.separator"));
		successMessage.append("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

}
