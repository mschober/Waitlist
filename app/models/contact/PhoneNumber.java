package models.contact;

import utils.PhoneNumberValidator;

public class PhoneNumber {

	private String phoneNumber;

	public PhoneNumber(String phoneNumber) {
		this.phoneNumber = stripNonDigits(phoneNumber);
	}
	
	@Override
	public String toString(){
		return formatWithDashes(phoneNumber);
	}

	private String stripNonDigits(String phoneNumber2) {
		StringBuilder number = new StringBuilder();
		for(char c : phoneNumber2.toCharArray())
			appendOnlyNumbers(number, c);
		return number.toString();
	}

	private void appendOnlyNumbers(StringBuilder number, char c) {
		if(PhoneNumberValidator.isANumber(c))
			number.append(String.valueOf(c));
	}

	public boolean isValid() {
		return PhoneNumberValidator.validate(phoneNumber);
	}

	public String formatWithDashes(String phoneNumber2) {
		String areaCode = phoneNumber2.substring(0, 3);
		String preFix = phoneNumber2.substring(3, 6);
		String lineNumber = phoneNumber2.substring(6);
		return areaCode + "-" + preFix + "-" + lineNumber;
	}

}
