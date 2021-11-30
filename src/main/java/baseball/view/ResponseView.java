package baseball.view;

import java.util.HashMap;

import baseball.utils.Constant;

public class ResponseView {
	//입력값 확인 후 출력
	public void responseAnswer(HashMap<String, Integer> answerMap) {
		StringBuffer responseAnswer = new StringBuffer();
		//map.size() == 0 이면 낫싱
		if (answerMap.size() == 0) {
			responseAnswer.append(Constant.RESPONSE_NOTHING_MESSAGE);
			return;
		}

		if (answerMap.containsKey(Constant.RESPONSE_BALL_MESSAGE)) {
			responseAnswer.append(answerMap.get(Constant.RESPONSE_BALL_MESSAGE))
				.append(Constant.RESPONSE_BALL_MESSAGE)
				.append(" ");
		}
		if (answerMap.containsKey(Constant.RESPONSE_STRIKE_MESSAGE)) {
			responseAnswer.append(answerMap.get(Constant.RESPONSE_STRIKE_MESSAGE))
				.append(Constant.RESPONSE_STRIKE_MESSAGE);
		}

		System.out.println(responseAnswer);
	}
}
