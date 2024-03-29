package utils;

import static org.junit.Assert.*;
import static utils.WaitlistTestHelper.LOWERCASE;
import static utils.Lakewood.*;

import models.Boat;
import models.Boat.BoatType;
import models.PostalAddress;
import models.Applicant;
import models.Contact;

public class WaitlistTestHelper {

	public static final String CA = "CA";
	public static final String SANTA_BARBARA = "Santa Barbara";
	public static final String _3706_AMALFI_WAY = "3706 Amalfi Way";
	public static final String _253_468_4141 = "253-468-4141";
	public static final String MIKE_SCHOBER_GMAIL_COM = "mike.schober@gmail.com";
	public static final String SCHOBER = "Schober";
	public static final String MICHAEL = "Michael";
	public static final int CAP_Z = 90;
	public static final int CAP_A = 65;
	public static final String LOWERCASE = "lowercase";
	public static final String BY_CONTACT = "byContact";

	public static void assertOnlyOne(long count) {
		assertEquals(1, count);
	}

	public static void assertNone(long count) {
		assertEquals(0, count);
	}

	public static PostalAddress createDefaultPostalAddress() {
		return new PostalAddress("3706 Amalfi Way", "Santa Barbara", "CA", 93105).save();
	}

	public static Contact createDefaultContact(PostalAddress address) {
		return new Contact("mike.schober@gmail.com", _253_468_4141, address).save();
	}

	public static Applicant createDefaultApplicant(Contact mikeGmail, Boat powerBoat) {
		return new Applicant(MICHAEL, SCHOBER, mikeGmail, powerBoat).save();
	}

	public static Applicant findByFirstName(String michael) {
		return Applicant.find(BY_FIRST_NAME, MICHAEL).first();
	}

	public static boolean isCapitalized(char charAt) {
		return CAP_A <= charAt && charAt <= CAP_Z;
	}

	public static boolean isCapitalized(String firstName) {
		return isCapitalized(firstName.charAt(0));
	}

	public static Applicant createLowerCaseApplicant() {
		return new Applicant(LOWERCASE, LOWERCASE, null, null);
	}

	public static void checkFields(String[] expects, String[] actuals) {
		for(int i = 0; i < expects.length; i++)
			assertEquals(expects[i], actuals[i]);
	}

	public static void assertThree(long count) {
		assertEquals(3, count);
	}
	
	public static void assertFour(long count) {
		assertEquals(4, count);
	}
	
	public static void assertTwo(long count) {
		assertEquals(2, count);
	}

	public static Boat createPowerBoat() {
		return new Boat(BoatType.POWER).save();
	}

}
