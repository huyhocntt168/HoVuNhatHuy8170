package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	Utilities utilities = new Utilities();
	// Locators
	private final By txtUsername = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPID = By.id("pid");
	private final By btnRegister = By.xpath("//input[@value = 'Register']");
	
	public void registerAccount() {
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtUsername), utilities.randomValidEmail());
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtPassword), "123456789");
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmPassword), "123456789");
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtPID), "123456789");
		Constant.WEBDRIVER.findElement(btnRegister).click();
	}
}
