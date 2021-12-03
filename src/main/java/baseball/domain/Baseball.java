package baseball.domain;

import static baseball.view.ErrorMessage.*;

public class Baseball {
	public final int number; //number는 1~9다.
	public final int position; //position은 1,2,3이다. [Q]이걸 정의할 수 있는 방법 없나? : 1)유효성검사,2)enum을 활용할수도?

	public static final int MIN_VALUE_NUMBER = 1;
	public static final int MAX_VALUE_NUMBER = 9;

	public static final int MIN_VALUE_POSITION = 1;
	public static final int MAX_VALUE_POSITION = 3;

	//[ME]생성자 대신 builder패턴을 써보자.
	public Baseball(int number, int position) {
		validateNumber(number);
		validatePosition(position);
		this.number = number;
		this.position = position;
	}

	private void validateNumber(int number) {
		if (!(number >= MIN_VALUE_NUMBER && number <= MAX_VALUE_NUMBER)) {
			throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
		}
	}

	private void validatePosition(int position) {
		if (!(position >= MIN_VALUE_POSITION && position <= MAX_VALUE_POSITION)) {
			throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Baseball)) {
			return false;
		}
		return this.number == ((Baseball)obj).number && this.position == ((Baseball)obj).position;
	}

	@Override
	public String toString() {
		return "number:" + number + "/ position:" + position;
	}
}
