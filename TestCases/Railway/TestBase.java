package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Utilities;
import Constant.Constant;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestBase {
	Utilities utilities = new Utilities();
	HomePage homePage = new HomePage();

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		utilities.openChrome();
		homePage.open();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}
