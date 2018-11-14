package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

	//Locators
	private final By tabLogin = By.xpath("//span[.='Login']");
	private final By tabLogout = By.xpath("//span[.='Log out']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	
	//Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}
	
	//Methods
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
}
