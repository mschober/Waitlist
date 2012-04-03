package models.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

public abstract class WLFixture extends WLTest implements DataTest {
	
	public enum DataFiles {
		HAPPY_PATH_DATA();
		
		String yml;

		DataFiles(){
			this.yml = format(this) + addExtension();
		}

		private String addExtension() {
			return ".yml";
		}

		private String format(DataFiles fileName) {
			return fileName.toString().toLowerCase().replace("_", "-");
		}
		
	}

	public static final String PATH_TO_LOAD_DATA_YML = PATH_TO_RESOURCES + DataFiles.HAPPY_PATH_DATA.yml;

	@Before
	public void loadData(){
		prepDatabase(DataFiles.HAPPY_PATH_DATA);
	}
	
	@After
	public void reloadData(){
		prepDatabase(DataFiles.HAPPY_PATH_DATA);
	}

	protected void prepDatabase(DataFiles happyPathData) {
		clearData();
		load(happyPathData);
	}
	
	private void load(DataFiles happyPathData) {
		Fixtures.loadModels(PATH_TO_RESOURCES + happyPathData.yml);
	}
}
