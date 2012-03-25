package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class AddressTest extends UnitTest {
	
	private Address address;

	@Before
	public void setup(){
		address = new Address("3706 Amalfi Way", "Santa Barbara", "CA", 93105);
		address.save();
	}

	@Test
	public void test() {
		assertNotNull(address);
	}

}
