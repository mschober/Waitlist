package utils;

import java.util.List;

import models.Applicant;
import models.Contact;
import models.PostalAddress;

public class Lakewood {

	public static final String ALL_BY_ID = "id >= ? order by id asc";
	public static final String BY_PHONE_NUMBER = "byPhoneNumber";
	public static final String BY_EMAIL = "byEmail";
	public static final String BY_POSTAL_ADDRESS = "byPostalAddress";
	public static final String BY_LAST_NAME = "byLastName";
	public static final String BY_FIRST_NAME = "byFirstName";

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
	
	public static Applicant findFirstApplicantByFirstName(String firstName){
		return Applicant.find(BY_FIRST_NAME, firstName).first();
	}

	public static List<Applicant> findAllApplicantsBy(String string) {
		return Applicant.find("id >= ? order by id asc", 1l).fetch();
	}

}
