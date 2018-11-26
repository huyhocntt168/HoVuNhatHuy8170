package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class ChangePasswordPage extends GeneralPage {
	// Locators
	private final By txtCurrentPwd = By.id("currentPassword");
	private final By txtNewPwd = By.id("newPassword");
	private final By txtConfirmPwd = By.id("confirmPassword");
	private final By btnChangePwd = By.xpath("//input[@value='Change Password']");
	private final By lblChangePwd = By.xpath("//p[@class='message success']");
	// Elements
	
	// Methods

	public String getChangePwdMsg() {
		return Constant.WEBDRIVER.findElement(lblChangePwd).getText();
	}
	
	public void changePwd(String currentPwd, String newPwd, String confirmPwd) {
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtCurrentPwd), currentPwd);
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		utilities.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmPwd), confirmPwd);	
		Constant.WEBDRIVER.findElement(btnChangePwd).click();
	}
}
