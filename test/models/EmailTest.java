package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import utils.WaitlistTestHelper;

public class EmailTest extends UnitTest {


	private Email email;
	private Applicant jennie;

	@Before
	public void setUp() throws Exception {
		jennie = new Applicant("Jennie", "Schober").save();
		email = new Email(jennie, "jennie.schober@gmail.com");
	}

	@Test
	public void canSaveEmail() {
		email.save();
		Email found = Email.find("byApplicant", jennie).first();
		assertNotNull(found);
		assertEquals(jennie, found.applicant);
		
		WaitlistTestHelper.assertOnlyOne(Email.count());
		email.delete();
		WaitlistTestHelper.assertNone(Email.count());
		
	}

}
