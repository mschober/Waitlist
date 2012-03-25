package wl;

import org.junit.Before;

import play.test.Fixtures;
import play.test.UnitTest;


public class WLTest extends UnitTest {
	
	@Before
	public void clearData(){
		Fixtures.deleteDatabase();
	}

}
