package models;

import static org.junit.Assert.*;
import static utils.WaitlistTestHelper.*;
import static utils.Lakewood.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import utils.Lakewood;
import utils.WaitlistTestHelper;
import wl.WLTest;

public class ContactTest extends WLTest {

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
		assertEquals(MIKE_SCHOBER_GMAIL_COM, findFirstContactByEmail(contact.email).email);
	}
	
	@Test
	public void contactHasPhoneNumber(){
		assertEquals(_253_468_4141, findFirstContactByPhoneNumber(contact.phoneNumber).phoneNumber);
	}
	
	@Test
	public void contactHasAddress(){
		Contact contact = findFirstContactByPostalAddress(sbHome);
		
		String[] expects = {_3706_AMALFI_WAY, SANTA_BARBARA, CA};
		String[] actuals = {contact.postalAddress.address, contact.postalAddress.city, contact.postalAddress.state};
		checkFields(expects, actuals);
		
		assertEquals(93105, contact.postalAddress.zip);
	}
}
