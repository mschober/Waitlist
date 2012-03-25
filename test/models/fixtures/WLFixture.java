package models.fixtures;

import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

@Ignore
public class WLFixture extends WLTest {
	
	@Before
	public void loadData(){
		Fixtures.loadModels("data.yml");
	}

}
