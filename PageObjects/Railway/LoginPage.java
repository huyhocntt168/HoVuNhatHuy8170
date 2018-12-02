package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Constant.Constant;

public class LoginPage extends GeneralPage {

	ElementHelper elementHelper = new ElementHelper();
	// Locators
	private By txtUsername = By.id("username");
	private By txtPassword = By.id("password");
	private By btnLogin = By.xpath("//input[@value='login']");
	private By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private By lnkForgotPassword = By.xpath("//a[normalize-space()='Forgot Password page']");

	// Elements

	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(txtUsername);
	}

	// Methods
	public void login(String username, String password) {
		// Submit login credentials
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtUsername), username);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtPassword), password);
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

	public void goToForgotPasswordPage() {
		Constant.WEBDRIVER.findElement(lnkForgotPassword).click();
	}

}
