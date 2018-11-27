package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;


public class GeneralPage {
	ElementHelper elementHelper = new ElementHelper();
	
	// Locators
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblPageContent = By.xpath("//h1");
	// Elements

	// Methods
	public String getWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage).getText();
	}

	public WebElement getTabButton(Constant.TabName tabName) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format("//span[normalize-space()='%s']", tabName.getName())));
	}

	public void goToPage(Constant.TabName tabName) {
		getTabButton(tabName).click();
	}

	public String getPageContent() {
		return Constant.WEBDRIVER.findElement(lblPageContent).getText();
	}

	public void logout() {
		if(elementHelper.isTabDisplay(Constant.TabName.LOGOUT)) {
		getTabButton(Constant.TabName.LOGOUT).click();
		}
	}

}
