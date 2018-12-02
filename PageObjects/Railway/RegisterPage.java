package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	ElementHelper elementHelper = new ElementHelper();
	Utilities utilities = new Utilities();
	// Locators
	private By txtUsername = By.id("email");
	private By txtPassword = By.id("password");
	private By txtConfirmPassword = By.id("confirmPassword");
	private By txtPID = By.id("pid");
	private By btnRegister = By.xpath("//input[@value = 'Register']");
	private By lblErrorMsg = By.xpath("//p[@class='message error']");
	private By lblPwdErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
	private By lblPidErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");

	// Methods
	public String getErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();
	}

	public String getPwdErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblPwdErrorMsg).getText();
	}

	public String getPidErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblPidErrorMsg).getText();
	}

	public void registerAccount(String email, String pwd) {
		registerAccount(email, pwd, pwd, Constant.PID);
	}

	public void registerAccount(String email, String pwd, String confirmPwd) {
		registerAccount(email, pwd, confirmPwd, Constant.PID);
	}

	public void registerAccount(String email, String pwd, String confirmPwd, String pid) {
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtUsername), email);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtPassword), pwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmPassword), confirmPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtPID), pid);
		Constant.WEBDRIVER.findElement(btnRegister).click();
	}

	public void activateAccount() {
		Constant.WEBDRIVER.get(utilities.getActiveLink().replace(":8888", ""));
	}
}
