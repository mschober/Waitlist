package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegexEmailValidator implements EmailValidator{

	private static final String REPEAT = "*";
	private static final String CONTINUE_INCLUDE = "+";
	private static final String END_GROUP = ")";
	private static final String START_GROUP = "(";
	private static final String FROM_BEGINNING = "^";
	private static final String DOT = "\\.";
	private static final String A_Za_z0_9 = "[A-Za-z0-9]";

	private static final String SUB_DOMAIN = START_GROUP + DOT + "[A-Za-z]{2,})$";
	private static final String DOMAIN = A_Za_z0_9 + CONTINUE_INCLUDE + START_GROUP + DOT + A_Za_z0_9 + CONTINUE_INCLUDE + END_GROUP + REPEAT;
	private static final String UNDERSCORE_A_Za_z0_9_DASH = "[_A-Za-z0-9-]";
	private static final String NAME = FROM_BEGINNING + UNDERSCORE_A_Za_z0_9_DASH + CONTINUE_INCLUDE + START_GROUP + DOT + UNDERSCORE_A_Za_z0_9_DASH + CONTINUE_INCLUDE + END_GROUP + REPEAT;
	
	private static final String EMAIL_PATTERN = NAME + "@" + DOMAIN + SUB_DOMAIN;
 
	@Override
	public boolean validate(String hex){
		  Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		  Matcher matcher = pattern.matcher(hex);
		  return matcher.matches();
	  }
}