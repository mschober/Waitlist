package utils;


public class PhoneNumberValidator {

	private static final int NINE = 57;
	private static final int ZERO = 48;

	public static boolean validate(String phoneNumber) {
		return isAllNumbers(phoneNumber) && isTenDigits(phoneNumber) && doesNotStartWithZero(phoneNumber);
	}

	private static boolean doesNotStartWithZero(String phoneNumber) {
		return !(phoneNumber.charAt(0) == ZERO);
	}

	private static boolean isTenDigits(String phoneNumber) {
		return phoneNumber.length() == 10;
	}

	private static boolean isAllNumbers(String phoneNumber) {
		boolean is = true;
		for (char c : phoneNumber.toCharArray())
			is &= isANumber(c);
		return is;
	}

	public static boolean isANumber(char c) {
		return ZERO <= c && c <= NINE;
	}

}
