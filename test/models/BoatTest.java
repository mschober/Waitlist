package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.db.jpa.GenericModel.JPAQuery;
import play.test.UnitTest;

public class BoatTest extends UnitTest {

	private Boat powerBoat;

	@Test
	public void exists() {
		powerBoat = new Boat("power");
		assertNotNull(powerBoat);
	}
	
	@Test
	public void isPowerBoat(){
		Boat found = Boat.find("byType", "power").first();
		assertEquals(powerBoat, found);
	}

}
