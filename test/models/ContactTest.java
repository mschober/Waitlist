package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class ContactTest extends UnitTest {

	private Contact contact;
	private Address sbHome;

	@Before
	public void setUp() throws Exception {
		sbHome = new Address("3706 Amalfi Way", "Santa Barbara", "CA", 93105);
		sbHome.save();
		
		contact = new Contact("jennie.schober@gmail.com", "253-350-0220", sbHome);
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
	
	@Test
	public void contactHasAddress(){
		Contact contact = Contact.find("byAddress", sbHome).first();
		assertEquals("3706 Amalfi Way", contact.address.address);
		assertEquals("Santa Barbara", contact.address.city);
		assertEquals("CA", contact.address.state);
		assertEquals(93105, contact.address.zip);
	}
}
