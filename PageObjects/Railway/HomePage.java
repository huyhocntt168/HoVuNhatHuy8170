package Railway;

import Constant.Constant;

public class HomePage extends GeneralPage {

	// Locators

	// Elements

	// Methods

	public void open() {
		Constant.WEBDRIVER.navigate().to(Constant.RAILWAY_URL);
	}
}
