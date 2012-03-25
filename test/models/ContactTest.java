package models;

import static org.junit.Assert.*;
import static utils.WaitlistTestHelper.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import utils.WaitlistTestHelper;

public class ContactTest extends UnitTest {

	private Contact contact;
	private PostalAddress sbHome;

	@Before
	public void setUp() throws Exception {
		sbHome = createDefaultPostalAddress();
		contact = createDefaultContact(sbHome);
	}

	@Test
	public void canCreateContact() {
		assertNotNull(contact);
	}
	
	@Test
	public void contactHasEmail(){
		Contact found = Contact.find(BY_EMAIL, MIKE_SCHOBER_GMAIL_COM).first();
		assertEquals(MIKE_SCHOBER_GMAIL_COM, found.email);
	}
	
	@Test
	public void contactHasPhoneNumber(){
		Contact found = Contact.find(BY_PHONE_NUMBER, _253_468_4141).first();
		assertEquals(_253_468_4141, found.phoneNumber);
	}
	
	@Test
	public void contactHasAddress(){
		Contact contact = Contact.find(BY_ADDRESS, sbHome).first();
		
		String[] expects = {_3706_AMALFI_WAY, SANTA_BARBARA, CA};
		String[] actuals = {contact.address.address, contact.address.city, contact.address.state};
		checkFields(expects, actuals);
		
		assertEquals(93105, contact.address.zip);
	}

	private void checkFields(String[] expects, String[] actuals) {
		for(int i = 0; i < expects.length; i++)
			assertEquals(expects[i], actuals[i]);
	}
}
