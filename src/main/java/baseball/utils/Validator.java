package baseball.utils;

import static baseball.view.ErrorMessage.*;

import java.util.HashSet;
import java.util.Set;

public class Validator {
	public static void length(String string, int validLength) {
		if (string.length() != validLength) {
			throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
		}
	}

	public static void length(Set set, int validLength) {
		if (set.size() != validLength) {
			throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER_MESSAGE);
		}
	}

	public static void isNumber(String string) {
		for (char chr : string.toCharArray()) {
			isNumber(chr);
		}
	}

	public static void isNumber(char chr) {
		if (!Character.isDigit(chr)) {
			throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE);
		}
	}

	public static void range(String string, int minValue, int maxValue) {
		for (char chr : string.toCharArray()) {
			int digit = toInt(chr);
			if (!(digit >= minValue && digit <= maxValue)) {
				throw new IllegalArgumentException(INVALID_RANGE_MESSAGE);
			}
		}
	}

	public static int toInt(char chr) {
		return (int)chr - '0';
	}

	public static void duplicateNumber(String string) {
		Set<Integer> set = new HashSet<>();
		for (char chr : string.toCharArray()) {
			set.add(toInt(chr));
		}
		length(set, string.length());
	}
}
