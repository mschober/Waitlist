package utils;

import java.util.regex.Pattern;


public class PhoneNumberValidator {

	private static final int NINE = 57;
	private static final int ZERO = 48;

	public static boolean validate(String phoneNumber) {
		return isAllNumbers(phoneNumber) && doesNotStartWithZero(phoneNumber);
	}

	private static boolean doesNotStartWithZero(String phoneNumber) {
		return !(phoneNumber.charAt(0) == ZERO);
	}

	private static boolean isAllNumbers(String phoneNumber) {
		return Pattern.matches("[0-9]{10}", phoneNumber);
	}

	public static boolean isANumber(char c) {
		return ZERO <= c && c <= NINE;
	}

}
