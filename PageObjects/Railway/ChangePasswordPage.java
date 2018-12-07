package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
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
	
	public void changePassword(String currentPwd, String newPwd) {
		changePassword(currentPwd, newPwd, newPwd);
	}
	
	public void changePassword(String currentPwd, String newPwd, String confirmPwd) {
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtCurrentPwd), currentPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmPwd), confirmPwd);	
		Constant.WEBDRIVER.findElement(btnChangePwd).click();
	}
}
