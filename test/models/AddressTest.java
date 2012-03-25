package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import utils.WaitlistTestHelper;

public class AddressTest extends UnitTest {
	
	private PostalAddress address;

	@Before
	public void setup(){
		address = WaitlistTestHelper.createDefaultPostalAddress();
		address.save();
	}

	@Test
	public void test() {
		assertNotNull(address);
	}

}
