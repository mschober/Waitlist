package models.fixtures;

import org.junit.Before;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

public class WLFixture extends WLTest {
	
	@Before
	public void loadData(){
		Fixtures.loadModels("data.yml");
	}

}
