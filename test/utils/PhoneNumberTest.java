package utils;

import models.Contact;
import models.contact.PhoneNumber;

import org.junit.Before;
import org.junit.Test;

import sun.awt.image.PNGImageDecoder.PNGException;

import wl.WLTest;

public class PhoneNumberTest extends WLTest {
	
	private PhoneNumber phoneNumber;
	
	@Before
	public void setup(){
		phoneNumber = new PhoneNumber("(253)4684141");
	}

	@Test
	public void isValid(){
		assertTrue(PhoneNumberValidator.validate("2534684141"));
		assertFalse(PhoneNumberValidator.validate("adfa"));
		assertFalse(PhoneNumberValidator.validate("01234567890"));
		assertFalse(PhoneNumberValidator.validate("0123456789"));
	}
	
	@Test
	public void canEnterWithParens(){
		assertTrue("Failed: " + phoneNumber, phoneNumber.isValid());
		assertEquals("253-468-4141", phoneNumber.toString());
	}
	
}
