package utils;

import org.junit.rules.TestWatchman;

import models.Address;
import models.Applicant;

public class TestApplicantHelper {

	public static final String BY_LAST_NAME = "byLastName";
	public static final String BY_FIRST_NAME = "byFirstName";
	public static final String SCHOBER = "Schober";
	public static final String MICHAEL = "Michael";

	public static Applicant findByFirstName(String michael) {
		return Applicant.find(BY_FIRST_NAME, MICHAEL).first();
	}
	
	

}
