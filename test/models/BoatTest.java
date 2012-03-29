package models;

import static org.junit.Assert.*;

import org.junit.Test;

import play.test.UnitTest;

public class BoatTest extends UnitTest {

	@Test
	public void exists() {
		assertNotNull(new Boat("power"));
	}

}
