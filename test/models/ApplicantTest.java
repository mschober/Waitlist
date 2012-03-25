package models;

import static org.junit.Assert.*;
import static utils.WaitlistTestHelper.*;
import wl.WLTest;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.JPABase;
import play.test.Fixtures;
import play.test.UnitTest;
import utils.WaitlistTestHelper;

public class ApplicantTest extends WLTest {

	private Applicant applicant;
	private Contact mikeGmail;

	@Before
	public void setUp() throws Exception {
		PostalAddress sbHome = createDefaultPostalAddress();
		mikeGmail = createDefaultContact(sbHome);
		applicant = createDefaultApplicant(mikeGmail);
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
		assertEquals(applicant, Applicant.find(BY_CONTACT, mikeGmail).first());
	}
	
	@Test
	public void deletingApplicantDeletesContact(){
		assertOnlyOne(Contact.count());
		assertOnlyOne(Applicant.count());
		applicant.delete();
		assertNone(Applicant.count());
		mikeGmail.delete();
		assertNone(Contact.count());
	}

	@Test
	public void firstNameFirstLetterCapitalized(){
		String firstName = createLowerCaseApplicant().firstName;
		assertTrue(isCapitalized(firstName));
	}

	@Test
	public void lastNameFirstLetterCapitalized(){
		String lastName = createLowerCaseApplicant().lastName;
		assertTrue(isCapitalized(lastName));
	}
}
