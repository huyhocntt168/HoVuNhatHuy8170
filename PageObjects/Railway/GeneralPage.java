package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

	//Locators
	private final By tabLogin = By.xpath("//span[.='Login']");
	private final By tabLogout = By.xpath("//span[.='Log out']");
	private final By tabBookTicket = By.xpath("//span[.='Book ticket']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']");
	private final By lblPageContent = By.xpath("//h1");
	
	//Elements
	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}
	
	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}
	
	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}
	
	protected WebElement getLblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}
	
	protected WebElement getLblPageContent() {
		return Constant.WEBDRIVER.findElement(lblPageContent);
	}
	
	//Methods
	public String getWelcomeMessage() {
		return this.getLblWelcomeMessage().getText();
	}
	
	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}
	
	public String getPageContent() {
		return this.getLblPageContent().getText();
	}
	
	public BookTicketPage gotoBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}
	
	public HomePage Logout() {
		this.getTabLogout().click();
		return new HomePage();
	}
	
	public void clearTextbox(WebElement txtField) {
		txtField.clear();
	}
}
