package models.fixtures;

import static org.junit.Assert.*;

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
	public void test() {
		Applicant applicant = Lakewood.findFirstApplicantByLastName(WaitlistTestHelper.SCHOBER);
		assertNotNull(applicant);
	}

}
