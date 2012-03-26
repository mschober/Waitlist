package utils;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class SimpleEmailValidator implements EmailValidator {
	
	@Override
	  public boolean validate(String hex){
		  try {
			  new InternetAddress(hex).validate();
		  } catch (AddressException e) {
			  return false;
		  }
		  return checkForNameDomain(hex.split("@"));
	  }

	private static boolean checkForNameDomain(String[] split) {
		return split.length >= 2;
	}

}
