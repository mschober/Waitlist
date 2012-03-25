package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class ContactTest extends UnitTest {

	private Contact contact;

	@Before
	public void setUp() throws Exception {
		contact = new Contact("jennie.schober@gmail.com", "253-350-0220");
		contact.save();
	}

	@Test
	public void canCreateContact() {
		assertNotNull(contact);
	}
	
	@Test
	public void contactHasEmail(){
		Contact found = Contact.find("byEmail", "jennie.schober@gmail.com").first();
		assertEquals("jennie.schober@gmail.com", found.email);
	}
	
	@Test
	public void contactHasPhoneNumber(){
		Contact found = Contact.find("byPhoneNumber", "253-350-0220").first();
		assertEquals("253-350-0220", found.phoneNumber);
	}
}
