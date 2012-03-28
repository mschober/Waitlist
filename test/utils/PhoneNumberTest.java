package utils;

import models.Contact;
import models.contact.PhoneNumber;

import org.junit.Before;
import org.junit.Test;

import play.Play;
import play.data.validation.Validation;

import sun.awt.image.PNGImageDecoder.PNGException;
import utils.data.validation.Phone;
import utils.data.validation.PhoneCheck;

import wl.WLTest;

public class PhoneNumberTest extends WLTest {
	
	@Test
	public void isValid(){
		assertTrue(PhoneCheck.validate("253 468 4141"));
		assertTrue(PhoneCheck.validate("253-468-4141"));
		assertTrue(PhoneCheck.validate("(253)468-4141"));
		assertTrue(PhoneCheck.validate("253.468.4141"));
		assertTrue(PhoneCheck.validate("2534684141"));

		assertFalse(PhoneCheck.validate("adfa"));
		assertFalse(PhoneCheck.validate("01234567890"));
//		assertFalse(Play.configuration.getProperty("validation.phone"), PhoneCheck.validate("253 468 414"));
	}
}
