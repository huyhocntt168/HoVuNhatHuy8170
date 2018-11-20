package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	public void clickTab(String tabName) {
		Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[normalize-space()='%s']", tabName))).click();
	}

	public String getPageContent() {
		return Constant.WEBDRIVER.findElement(lblPageContent).getText();
	}

	public void Logout() {
		utilities.waitElementDisplay(Constant.WEBDRIVER.findElement(By.xpath("//span[normalize-space()='Log out']")));
		if (Constant.WEBDRIVER.findElement(By.xpath("//span[normalize-space()='Log out']")).isDisplayed()) {
			clickTab("Log out");
		}
	}

}
