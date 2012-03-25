package utils;

import static utils.WaitlistTestHelper.*;
import models.Applicant;
import models.Contact;
import models.PostalAddress;

public class Lakewood {

	public static Contact findFirstContactByPhoneNumber(String number) {
		return Contact.find(BY_PHONE_NUMBER, number).first();
	}

	public static Contact findFirstContactByEmail(String email) {
		return Contact.find(BY_EMAIL, email).first();
	}

	public static Contact findFirstContactByPostalAddress(PostalAddress address) {
		return Contact.find(BY_POSTAL_ADDRESS, address).first();
	}

	public static Applicant findFirstApplicantByLastName(String lastName) {
		return Applicant.find(BY_LAST_NAME, lastName).first();
	}

}
