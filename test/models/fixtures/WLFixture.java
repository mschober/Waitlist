package models.fixtures;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;

import play.test.Fixtures;
import play.test.UnitTest;
import wl.WLTest;

public abstract class WLFixture extends WLTest implements DataTest {
	
	public enum DataFile {
		HAPPY_PATH_DATA(), BOAT_DATA;
		
		String yml;

		DataFile(){
			this.yml = format(this) + addExtension();
		}

		private String addExtension() {
			return ".yml";
		}

		private String format(DataFile fileName) {
			return fileName.toString().toLowerCase().replace("_", "-");
		}
		
	}

	public static final String PATH_TO_LOAD_DATA_YML = PATH_TO_RESOURCES + DataFile.HAPPY_PATH_DATA.yml;

	@Before
	public void loadData(){
		prepDatabase(DataFile.HAPPY_PATH_DATA);
	}
	
	@After
	public void reloadData(){
		prepDatabase(DataFile.HAPPY_PATH_DATA);
	}

	protected void prepDatabase(DataFile... dataFiles) {
		clearData();
		for(DataFile df: dataFiles)
			load(df);
	}
	
	private void load(DataFile happyPathData) {
		Fixtures.loadModels(PATH_TO_RESOURCES + happyPathData.yml);
	}
}
