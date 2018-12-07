package Railway;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;

public class TestBase {

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		Utilities.openChrome();
		Utilities.navigateToUrl(Constant.RAILWAY_URL);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}
