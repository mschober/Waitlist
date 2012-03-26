package utils;

import org.junit.Before;
import org.junit.Test;

import wl.WLTest;

public class EmailTest extends WLTest {

	private static final String[] expectedTrue = {
		"___.______@gmail.com",
		"----.----@gmail.com",
		"mike.schober@gmail.com",
		"mike.schober.will.smith.whatever.whatever.123412.23412@gmail.com",
		"myemail@mike.schober.will.smith.whatever.whatever.123412.23412.com",
		"mike.schober@gmail.com.ab.cd.ef.gh.ij.kl",
		"mike.schober@gmail.commasdfsdafasfea",
		"mike.schober@1234.com",
		"mike.schober@gmail.123assdfaeaw.com",
		"a@b.com"
	};
	private static final String[] expectedFalse = {
		")(mike.schober@gmail.com",
		"mike.schober@)(gmail.com",
		"mike.schober@gmail.)(com"
	};

	@Test
	public void isValid() {
		assertTrue(expectedTrue, new RegexEmailValidator());
		assertFalse(expectedFalse, new RegexEmailValidator());
	}

	@Test
	public void isSimplyValid() {
		assertTrue(expectedTrue, new SimpleEmailValidator());
		assertFalse(expectedFalse, new SimpleEmailValidator());
	}
	
	private void assertFalse(String[] expectedFalse, EmailValidator validator) {
		for(String emailAddress: expectedFalse)
			assertFalse("Failed: " + emailAddress, validator.validate(emailAddress));
	}
	
	private void assertTrue(String[] expectedTrue, EmailValidator validator) {
		for(String emailAddress: expectedTrue)
			assertTrue("Failed: " + emailAddress, validator.validate(emailAddress));
	}
}
