package models.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

@Ignore
public class WLFixture extends WLTest {
	
	private static final String DATA_YML = "data.yml";
	private static final String PATH_TO_RESOURCES = "../resources/";
	public static final String PATH_TO_LOAD_DATA_YML = PATH_TO_RESOURCES + DATA_YML;

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
		Fixtures.loadModels(PATH_TO_RESOURCES + DATA_YML);
	}
}
