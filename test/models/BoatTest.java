package models;

import static org.junit.Assert.*;
import static models.Boat.BoatType.*;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.GenericModel.JPAQuery;
import play.test.Fixtures;
import play.test.UnitTest;
import utils.WaitlistTestHelper;

public class BoatTest extends UnitTest {

	private Boat powerBoat;
	private Boat sailBoat;

	@Before
	public void setup(){
		Fixtures.deleteDatabase();
		powerBoat = new Boat(POWER, 10, 10).save();
		sailBoat = new Boat(SAIL, 10, 10).save();
	}
	
	@Test
	public void exists() {
		assertNotNull(powerBoat);
	}
	
	@Test
	public void isPowerBoat(){
		Boat found = Boat.find("byType", "Power").first();
		assertEquals(powerBoat, found);
	}
	
	@Test
	public void isSailBoat(){
		Boat found = Boat.find("byType", "Sail").first();
		assertEquals(sailBoat, found);
	}
	
	@Test
	public void hasLength(){
		int length = 12;
		powerBoat.setLength(length);
		Boat found = Boat.find("byLength", length).first();
		assertNotNull(found);
		assertEquals(length, found.length);
	}
	
	@Test
	public void hasBeam(){
		int beam = 15;
		sailBoat.setBeam(beam);
		Boat found = Boat.find("byBeam", beam).first();
		assertNotNull(found);
		assertEquals(beam, found.beam);
	}

}
