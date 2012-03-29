package models.fixtures;

import static org.junit.Assert.*;
import static utils.WaitlistTestHelper.*;
import static utils.Lakewood.*;


import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;

import utils.Lakewood;
import utils.WaitlistTestHelper;
import wl.WLTest;

import models.Applicant;
import models.PostalAddress;
import models.fixtures.WLFixture;

public class ApplicantFixture extends WLFixture {

	@Test
	public void shouldExist() {
		Applicant applicant = findFirstApplicantByLastName(SCHOBER);
		assertNotNull(applicant);
	}
	
	@Test
	public void countsMatch(){
		assertFour(Applicant.count());
		assertFour(findAllApplicantsBy(ALL_BY_ID).size());
	}
	
	@Test
	public void deleteWorks(){
		Applicant applicant = findFirstApplicantByFirstName("Michael");
		applicant.delete();
		assertThree(Applicant.count());
	}
}
