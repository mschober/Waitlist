package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class EmailTest extends UnitTest {


	private Email email;
	private Applicant jennie;

	@Before
	public void setUp() throws Exception {
		jennie = new Applicant("Jennie", "Schober").save();
		email = new Email(jennie, "3706 Amalfi Way", "Santa Barbara", "CA", 93105);
	}

	@Test
	public void canSaveEmail() {
		email.save();
		Email found = Email.find("byApplicant", jennie).first();
		assertNotNull(found);
		assertEquals(jennie, found.applicant);
		
	}

}
