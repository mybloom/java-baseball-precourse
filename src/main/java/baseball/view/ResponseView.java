package baseball.view;

import java.util.HashMap;

import baseball.utils.Constant;

public class ResponseView {
	//입력값 확인 후 출력
	public void responseAnswer(HashMap<String, Integer> answerMap) {
		StringBuilder responseAnswer = new StringBuilder(100);
		//map.size() == 0 이면 낫싱
		if (answerMap.size() == 0) {
			responseAnswer.append(Constant.RESPONSE_NOTHING_MESSAGE);
			return;
		}

		//볼
		if (answerMap.containsKey(Constant.RESPONSE_BALL_MESSAGE)) {
			responseAnswer.append(answerMap.get(Constant.RESPONSE_BALL_MESSAGE));
			responseAnswer.append(Constant.RESPONSE_BALL_MESSAGE);
			responseAnswer.append(" ");
		}
		//스트라이크
		if (answerMap.containsKey(Constant.RESPONSE_STRIKE_MESSAGE)) {
			responseAnswer.append(answerMap.get(Constant.RESPONSE_STRIKE_MESSAGE));
			responseAnswer.append(Constant.RESPONSE_STRIKE_MESSAGE);
			//3스트라이크
			if(answerMap.get(Constant.RESPONSE_STRIKE_MESSAGE) == 3){
				responseAnswer.append(System.getProperty("line.separator"));
				responseAnswer.append(Constant.RESPONSE_CORRECT_MESSAGE);
				responseAnswer.append(System.getProperty("line.separator"));
				responseAnswer.append(Constant.RESPONSE_START_AGAIN_MESSAGE);
			}
		}

		System.out.println(responseAnswer);
	}
}
