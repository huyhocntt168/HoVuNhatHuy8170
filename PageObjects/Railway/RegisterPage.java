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
	
	//Methods
	public String getErrorMsg() {
		if(elementHelper.isElementDisplay(lblErrorMsg)) {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();
		}
		return null;
	}
	
	public String getPwdErrorMsg() {
		if(elementHelper.isElementDisplay(lblPwdErrorMsg)) {
			return Constant.WEBDRIVER.findElement(lblPwdErrorMsg).getText();
		}
		return null;
	}
	
	public String getPidErrorMsg() {
		if(elementHelper.isElementDisplay(lblPidErrorMsg)) {
			return Constant.WEBDRIVER.findElement(lblPidErrorMsg).getText();
		}
		return null;
	}
	
	public void registerAccount(String email, String pwd, String confirmPwd, String pid) {
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtUsername), email);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtPassword), pwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmPassword), confirmPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtPID), pid);
		Constant.WEBDRIVER.findElement(btnRegister).click();
		utilities.connectMail();
		Constant.WEBDRIVER.get(utilities.goToLinkWithinMail());	
	}
}
