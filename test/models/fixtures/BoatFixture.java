package models.fixtures;

import static org.junit.Assert.*;
import static utils.Lakewood.findAllContacts;
import static utils.Lakewood.findFirstContactByEmail;
import static utils.WaitlistTestHelper.MIKE_SCHOBER_GMAIL_COM;
import static utils.WaitlistTestHelper.assertNone;
import static utils.WaitlistTestHelper.assertOnlyOne;

import models.Applicant;
import models.Boat;
import models.Contact;

import org.junit.Test;

import utils.WaitlistTestHelper;

public class BoatFixture extends WLFixture {

	@Test
	public void shouldExist() {
		Boat boat = Boat.find("byType", Boat.BoatType.POWER.toString()).first();
		assertNotNull(boat);
	}
	
	@Test
	public void countsMatch(){
		assertOnlyOne(Boat.count());
		assertOnlyOne(Boat.find("byType", Boat.BoatType.POWER.toString()).fetch().size());
	}
	
	@Test
	public void deleteWorks(){
		Applicant applicant = WaitlistTestHelper.findByFirstName(WaitlistTestHelper.MICHAEL);
		applicant.delete();
		
		Boat boat = Boat.find("byType", Boat.BoatType.POWER.toString()).first();
		boat.delete();
		assertNone(Boat.count());
	}
}
