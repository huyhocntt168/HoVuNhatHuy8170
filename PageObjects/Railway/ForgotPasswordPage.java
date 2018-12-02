package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage {

	Utilities utilites = new Utilities();

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

	public void goToResetPasswordPageWithoutToken(String email) {
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
		Constant.WEBDRIVER.get(getResetLink());
	}
	
	public void goToResetPasswordPageWithToken(String email) {
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
		Constant.WEBDRIVER.get(utilites.getActiveLink().replace(":8888", ""));
	}
	
	public String getResetLink() {
		String link = utilites.getActiveLink().substring(0, utilites.getActiveLink().indexOf("="));
		return link.replace(":8888", "");
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
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();
	}

	public void resetPassword(String newPwd, String confirmPwd, String resetToken) {
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		elementHelper.enter(Constant.WEBDRIVER.findElement(txtResetToken), resetToken);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();
	}
}
