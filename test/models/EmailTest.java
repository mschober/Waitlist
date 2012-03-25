package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import utils.EmailValidator;
import utils.SimpleEmailValidator;
import wl.WLTest;

public class EmailTest extends WLTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void isValid() {
		assertTrue(EmailValidator.validate("___.______@gmail.com"));
		assertTrue(EmailValidator.validate("----.----@gmail.com"));
		assertTrue(EmailValidator.validate("mike.schober@gmail.com"));

		assertTrue(EmailValidator.validate("mike.schober.will.smith.whatever.whatever.123412.23412@gmail.com"));
		assertTrue(EmailValidator.validate("myemail@mike.schober.will.smith.whatever.whatever.123412.23412.com"));
		assertTrue(EmailValidator.validate("mike.schober@gmail.com.ab.cd.ef.gh.ij.kl"));
		assertTrue(EmailValidator.validate("mike.schober@gmail.commasdfsdafasfea"));
		assertTrue(EmailValidator.validate("mike.schober@1234.com"));
		assertTrue(EmailValidator.validate("mike.schober@gmail.123assdfaeaw.com"));
		assertTrue(EmailValidator.validate("a@b.com"));


		assertFalse(EmailValidator.validate("~mike.schober@gmail.com"));
		assertFalse(EmailValidator.validate("mike.schober@~gmail.com"));
		assertFalse(EmailValidator.validate("mike.schober@gmail.~com"));
	}
	
	@Test
	public void isSimplyValid() {
	assertTrue(SimpleEmailValidator.validate("___.______@gmail.com"));
	assertTrue(SimpleEmailValidator.validate("----.----@gmail.com"));
	assertTrue(SimpleEmailValidator.validate("mike.schober@gmail.com"));

	assertTrue(SimpleEmailValidator.validate("mike.schober.will.smith.whatever.whatever.123412.23412@gmail.com"));
	assertTrue(SimpleEmailValidator.validate("myemail@mike.schober.will.smith.whatever.whatever.123412.23412.com"));
	assertTrue(SimpleEmailValidator.validate("mike.schober@gmail.com.ab.cd.ef.gh.ij.kl"));
	assertTrue(SimpleEmailValidator.validate("mike.schober@gmail.commasdfsdafasfea"));
	assertTrue(SimpleEmailValidator.validate("mike.schober@1234.com"));
	assertTrue(SimpleEmailValidator.validate("mike.schober@gmail.123assdfaeaw.com"));
	assertTrue(SimpleEmailValidator.validate("a@b.com"));


	assertFalse(SimpleEmailValidator.validate("~^(*&^(mike.schober@gmail.com"));
	assertFalse(SimpleEmailValidator.validate("mike.schober@~^(*&^(gmail.com"));
	assertFalse(SimpleEmailValidator.validate("mike.schober@gmail.~^(*&^(com"));
	}
	

}
