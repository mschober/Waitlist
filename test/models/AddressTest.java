package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;
import utils.WaitlistTestHelper;
import wl.WLTest;

public class AddressTest extends WLTest {
	
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
