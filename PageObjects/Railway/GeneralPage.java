package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.TabName;
import Constant.Constant;
import Constant.Tab;

public class GeneralPage {
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
		getTabButton(Tab.logout.Name()).click();
	}

}
