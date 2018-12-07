package Railway;

import org.openqa.selenium.By;

import Common.ElementHelper;
import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage {

	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	private By txtNewPwd = By.id("newPassword");
	private By txtConfirmNewPwd = By.id("confirmPassword");
	private By txtResetToken = By.id("resetToken");
	private By btnResetPwd = By.xpath("//input[@value='Reset Password']");
	private By lblErrorMsg = By.xpath("//p[@class='message error']");
	private By lblResetFormHeader = By.xpath("//legend");
	private By lblTokenErrorMsg = By.xpath("//label[@for='resetToken' and @class='validation-error']");
	private By lblConfirmPwdErrorMsg = By.xpath("//label[@for='confirmPassword' and @class='validation-error']");
	
	public void goToResetPasswordPage(String email) {
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
		Constant.WEBDRIVER.get(Utilities.getActiveLink().replace(":8888", ""));
	}

	public String getErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();
	}
	
	public String getTokenErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblTokenErrorMsg).getText();
	}
	
	public String getConfirmPwdErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblConfirmPwdErrorMsg).getText();
	}
	
	public String getResetPasswordFormHeader() {
		return Constant.WEBDRIVER.findElement(lblResetFormHeader).getText();
	}

	public void resetPassword(String newPwd) {
		resetPassword(newPwd, newPwd);
	}

	public void resetPassword(String newPwd, String confirmPwd) {
		ElementHelper.waitElementLocale(txtNewPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();
	}

	public void resetPassword(String newPwd, String confirmPwd, String resetToken) {
		ElementHelper.waitElementLocale(txtNewPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtResetToken), resetToken);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();
	}
}
