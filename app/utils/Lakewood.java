package utils;

import static utils.WaitlistTestHelper.BY_EMAIL;
import static utils.WaitlistTestHelper.BY_PHONE_NUMBER;
import static utils.WaitlistTestHelper.BY_POSTAL_ADDRESS;
import static utils.WaitlistTestHelper.MIKE_SCHOBER_GMAIL_COM;
import static utils.WaitlistTestHelper._253_468_4141;
import models.Contact;
import models.PostalAddress;

public class Lakewood {

	public static Contact findFirstContactByPhoneNumber() {
		return Contact.find(BY_PHONE_NUMBER, _253_468_4141).first();
	}

	public static Contact findFirstContactByEmail() {
		return Contact.find(BY_EMAIL, MIKE_SCHOBER_GMAIL_COM).first();
	}

	public static Contact findFirstContactByPostalAddress(PostalAddress address) {
		return Contact.find(BY_POSTAL_ADDRESS, address).first();
	}

}
