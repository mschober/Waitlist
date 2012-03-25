package utils;

import org.junit.Test;

import wl.WLTest;

public class PhoneNumberTest extends WLTest {
	

	@Test
	public void isValid(){
		assertTrue(PhoneNumberValidator.validate("2534684141"));
		assertFalse(PhoneNumberValidator.validate("adfa"));
		assertFalse(PhoneNumberValidator.validate("01234567890"));
		assertFalse(PhoneNumberValidator.validate("0123456789"));
	}
	
	@Test
	public void isHyphenated(){
		assertEquals("253-468-4141", PhoneNumberValidator.formatWithDashes("2534684141"));
	}
}
