package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Constant.Messages;
import Constant.TabName;
import Common.Utilities;
import Constant.Constant;

public class GeneralPage {
	Utilities utilities = new Utilities();
	// Locators
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblPageContent = By.xpath("//h1");
	// Elements

	// Methods
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}

	public WebElement getTabButton(String tabName) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[normalize-space()='%s']", tabName)));
	}

	public void goToPage(String tabName) {
		getTabButton(tabName).click();
	}

	public String getPageContent() {
		return Constant.WEBDRIVER.findElement(lblPageContent).getText();
	}

	public void logout() {
		goToPage(TabName.logout);
	}

}
