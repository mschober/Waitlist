package models.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

@Ignore
public class WLFixture extends WLTest {
	
	@Before
	public void loadData(){
		prepDatabase();
	}
	
	@After
	public void reloadData(){
		prepDatabase();
	}

	private void prepDatabase() {
		super.clearData();
		load();
	}
	
	private void load() {
		Fixtures.loadModels("data.yml");
	}
}
