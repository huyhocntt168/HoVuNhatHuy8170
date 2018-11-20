package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

	public void clickTab(String tabName) {
		Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[normalize-space()='%s']", tabName))).click();
	}

	public String getPageContent() {
		return Constant.WEBDRIVER.findElement(lblPageContent).getText();
	}

	public void logout() {
//		utilities.waitElementDisplay(Constant.WEBDRIVER.findElement(By.xpath("//span[normalize-space()='Log out']")));
//		if (Constant.WEBDRIVER.findElement(By.xpath("//span[normalize-space()='Log out']")).isDisplayed()) {
			clickTab("Log out");
//		}
	}

}
