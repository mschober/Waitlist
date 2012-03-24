package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class ContactTest extends UnitTest {

	private Contact contact;

	@Before
	public void setUp() throws Exception {
		contact = new Contact("jennie.schober@gmail.com");
		contact.save();
	}

	@Test
	public void test() {
		assertNotNull(contact);
	}

}
