package models.fixtures;

import static org.junit.Assert.*;
import static utils.Lakewood.findAllContacts;
import static utils.Lakewood.findFirstContactByEmail;
import static utils.WaitlistTestHelper.MIKE_SCHOBER_GMAIL_COM;
import static utils.WaitlistTestHelper.assertNone;
import static utils.WaitlistTestHelper.assertTwo;

import models.Applicant;
import models.Boat;
import models.Contact;

import org.junit.Before;
import org.junit.Test;

import utils.WaitlistTestHelper;

public class BoatFixture extends WLFixture {

	@Before
	public void loadBoatData(){
		prepDatabase(DataFile.HAPPY_PATH_DATA, DataFile.BOAT_DATA);
	}
	
	@Test
	public void shouldExist() {
		Boat boat = Boat.find("byType", Boat.BoatType.POWER.toString()).first();
		assertNotNull(boat);
		
		boat = Boat.find("byLength", 10).first();
		assertNotNull(boat);
		
		boat = Boat.find("byBeam", 10).first();
		assertNotNull(boat);
	}
	
	@Test
	public void countsMatch(){
		assertTwo(Boat.count());
		assertTwo(Boat.find("byType", Boat.BoatType.POWER.toString()).fetch().size());
	}
	
	@Test
	public void deleteWorks(){
		Applicant applicant = WaitlistTestHelper.findByFirstName(WaitlistTestHelper.MICHAEL);
		applicant.delete();
		
		Boat boat = Boat.find("byType", Boat.BoatType.POWER.toString()).first();
		boat.delete(); 
		
		boat = Boat.find("byLength", 10).first();
		boat.delete();
		assertNone(Boat.count());
	}
}
