package models;

import static org.junit.Assert.*;
import static models.Boat.BoatType.*;

import org.junit.Before;
import org.junit.Test;

import play.db.jpa.GenericModel.JPAQuery;
import play.test.Fixtures;
import play.test.UnitTest;

public class BoatTest extends UnitTest {

	private Boat powerBoat;
	private Boat sailBoat;

	@Before
	public void setup(){
		Fixtures.deleteDatabase();
		powerBoat = new Boat(POWER).save();
		sailBoat = new Boat(SAIL).save();
	}
	
	@Test
	public void exists() {
		assertNotNull(powerBoat);
	}
	
	@Test
	public void isPowerBoat(){
		Boat found = Boat.find("byType", "power").first();
		assertEquals(powerBoat, found);
	}
	
	@Test
	public void isSailBoat(){
		Boat found = Boat.find("byType", "sail").first();
		assertEquals(sailBoat, found);
	}

}
