package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	ElementHelper elementHelper = new ElementHelper();
	// Locators
	private final By txtUsername = By.id("email");
	private final By txtPassword = By.id("password");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtPID = By.id("pid");
	private final By btnRegister = By.xpath("//input[@value = 'Register']");
	private final By lblErrorMsg = By.xpath("//p[@class='message error']");
	
	//Methods
	public String getErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();
	}
	public void registerAccount(String email, String pwd, String confirmPwd, String pid) {
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtUsername), email);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtPassword), pwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmPassword), confirmPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtPID), pid);
		Constant.WEBDRIVER.findElement(btnRegister).click();
	}
}
