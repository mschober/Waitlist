package models;

import static org.junit.Assert.*;
import static utils.TestApplicantHelper.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.JPABase;
import play.test.Fixtures;
import play.test.UnitTest;
import utils.TestApplicantHelper;

public class ApplicantTest extends UnitTest {

	private Applicant applicant;

	@Before
	public void setUp() throws Exception {
		Fixtures.deleteDatabase();
		applicant = new Applicant(MICHAEL, SCHOBER).save();
	}

	@Test
	public void canCreateNewApplicant() {
		assertNotNull(applicant);
		Applicant found = findByFirstName(MICHAEL);
		assertEquals(applicant, found);
		found = Applicant.find(BY_LAST_NAME, SCHOBER).first();
		assertEquals(applicant, found);
		assertEquals(MICHAEL, found.firstName);
		assertEquals(SCHOBER, found.lastName);
		assertTrue(new Date().compareTo(found.date) > 0);
	}

}
