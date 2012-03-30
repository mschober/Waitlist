package wl;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;

public abstract class WLTest extends UnitTest {
	
	@Before
	public void clearData(){
		Fixtures.deleteDatabase();
	}

}
