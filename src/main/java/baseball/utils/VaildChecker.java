package baseball.utils;

import static baseball.utils.Constant.*;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class VaildChecker {

	//다른 사람은 inputString.length() 조차도 메서드로 뺐다.왜일까?
	public boolean isValidLength(String inputString, int validNumberOfDigits) {
		if (inputString.length() != validNumberOfDigits) {
			throw new IllegalArgumentException("Inputted String is not " + GAME_NUMBER_OF_DIGITS + " length.");
		}

		return true;
	}

	public boolean isValidLength(LinkedHashSet<Integer> set, int validNumberOfDigits) {
		if (set.size() != validNumberOfDigits) {
			throw new IllegalArgumentException(INVALID_DUPLICATED_MESSAGE);
		}

		return true;
	}

	//숫자포맷인지 확인하면서 Set에 넣기
	public LinkedHashSet<Integer> checkIntegerTypeAndToSet(String inputString) {
		LinkedHashSet<Integer> set = new LinkedHashSet<>();
		for (String str : inputString.split("")) {
			try {
				set.add(Integer.valueOf(str));
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE);
			}
		}

		return set;
	}

	//설정한 범위의 값인지 확인
	public boolean isValidRange(LinkedHashSet<Integer> set, int min_number, int max_number) {
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			int num = it.next();
			if (!(num >= min_number && num <= max_number)) {
				throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
			}
		}

		return true;
	}

}
