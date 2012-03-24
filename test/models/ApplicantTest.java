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
import utils.WaitlistTestHelper;

public class ApplicantTest extends UnitTest {

	private Applicant applicant;
	private Contact mikeGmail;

	@Before
	public void setUp() throws Exception {
		Fixtures.deleteDatabase();
		mikeGmail = new Contact("mike.schober@gmail.com").save();
		applicant = new Applicant(MICHAEL, SCHOBER, mikeGmail).save();
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
	
	@Test
	public void canFindBeEmail(){
		assertEquals(applicant, Applicant.find("byContact", mikeGmail).first());
	}
	
	@Test
	public void deletingApplicantDeletesContact(){
		WaitlistTestHelper.assertOnlyOne(Contact.count());
		WaitlistTestHelper.assertOnlyOne(Applicant.count());
		applicant.delete();
		WaitlistTestHelper.assertNone(Applicant.count());
		mikeGmail.delete();
		WaitlistTestHelper.assertNone(Contact.count());
	}

}
