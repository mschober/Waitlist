package models.fixtures;

import static utils.Lakewood.findAllContacts;
import static utils.Lakewood.findFirstContactByEmail;
import static utils.WaitlistTestHelper.MIKE_SCHOBER_GMAIL_COM;
import static utils.WaitlistTestHelper.assertOnlyOne;
import static utils.WaitlistTestHelper.assertNone;
import models.Applicant;
import models.Contact;

import org.junit.Test;

import utils.WaitlistTestHelper;

public class ContactFixture extends WLFixture {

	@Test
	public void shouldExist() {
		Contact contact = findFirstContactByEmail(MIKE_SCHOBER_GMAIL_COM);
		assertNotNull(contact);
	}
	
	@Test
	public void countsMatch(){
		assertOnlyOne(Contact.count());
		assertOnlyOne(findAllContacts().size());
	}
	
	@Test
	public void deleteWorks(){
		Applicant applicant = WaitlistTestHelper.findByFirstName(WaitlistTestHelper.MICHAEL);
		applicant.delete();
		
		Contact contact = findFirstContactByEmail(MIKE_SCHOBER_GMAIL_COM);
		contact.delete();
		assertNone(Contact.count());
	}

}
