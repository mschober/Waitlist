package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.Fixtures;
import play.test.UnitTest;

public class ApplicantTest extends UnitTest {

	@Before
	public void setUp() throws Exception {
		Fixtures.deleteDatabase();
		Applicant applicant = new Applicant("first", "last").save();
	}

	@Test
	public void test() {
		assertTrue(true);
	}

}
