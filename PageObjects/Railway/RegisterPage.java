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
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtPassword), Constant.PASSWORD);
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmPassword), Constant.PASSWORD);
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtPID), Constant.PID);
		Constant.WEBDRIVER.findElement(btnRegister).click();
	}
}
