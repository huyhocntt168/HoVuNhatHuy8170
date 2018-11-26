package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Constant.Constant;

public class LoginPage extends GeneralPage {

	ElementHelper elementHelper = new ElementHelper();
	// Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

	// Elements
	
	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(txtUsername);
	}
	// Methods
	public void login(String username, String password) {
		// Submit login credentials
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtUsername), username);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtPassword), password);
		Constant.WEBDRIVER.findElement(btnLogin).click();
	}

	public void login(String username, String password, int times) {
		for (int i = 1; i <= times; i++) {
			login(username, password);
		}
	}

	public String getErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg).getText();
	}

}
