package utils;

import static org.junit.Assert.*;
import models.Address;
import models.Applicant;
import models.Contact;

public class WaitlistTestHelper {

	public static final String CA = "CA";
	public static final String SANTA_BARBARA = "Santa Barbara";
	public static final String _3706_AMALFI_WAY = "3706 Amalfi Way";
	public static final String BY_ADDRESS = "byAddress";
	public static final String _253_468_4141 = "253-468-4141";
	public static final String BY_PHONE_NUMBER = "byPhoneNumber";
	public static final String BY_EMAIL = "byEmail";
	public static final String MIKE_SCHOBER_GMAIL_COM = "mike.schober@gmail.com";
	public static final String BY_FIRST_NAME = "byFirstName";
	public static final String BY_LAST_NAME = "byLastName";
	public static final String SCHOBER = "Schober";
	public static final String MICHAEL = "Michael";

	public static void assertOnlyOne(long count) {
		assertEquals(1, count);
	}

	public static void assertNone(long count) {
		assertEquals(0, count);
	}

	public static Address createDefaultPostalAddress() {
		return new Address("3706 Amalfi Way", "Santa Barbara", "CA", 93105).save();
	}

	public static Contact createDefaultContact(Address address) {
		return new Contact("mike.schober@gmail.com", "253-468-4141", address).save();
	}

	public static Applicant createDefaultApplicant(Contact mikeGmail) {
		return new Applicant(MICHAEL, SCHOBER, mikeGmail).save();
	}

	public static Applicant findByFirstName(String michael) {
		return Applicant.find(BY_FIRST_NAME, MICHAEL).first();
	}

}
