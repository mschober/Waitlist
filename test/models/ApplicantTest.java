package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.JPABase;
import play.test.Fixtures;
import play.test.UnitTest;

public class ApplicantTest extends UnitTest {

	private Applicant applicant;

	@Before
	public void setUp() throws Exception {
		Fixtures.deleteDatabase();
		applicant = new Applicant("first", "last").save();
	}

	@Test
	public void canCreateNewApplicant() {
		assertNotNull(applicant);
	}

}
