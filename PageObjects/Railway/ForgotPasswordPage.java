package Railway;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage{
	
	Utilities utilites = new Utilities();
	
	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	private By sendResetMailSuccessMsg = By.xpath("//p[@class='message success']");
	private By txtNewPwd = By.id("newPassword");
	private By txtConfirmNewPwd = By.id("confirmPassword");
	public By txtResetToken = By.id("resetToken");
	private By btnResetPwd  = By.xpath("//input[@value='Reset Password']");
	private By lblErrorMsg = By.xpath("//p[@class='message error']");
	
	public void goToResetPassword(String email){
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
		if(elementHelper.isElementDisplay(sendResetMailSuccessMsg)) {
		utilites.connectMail();
		String link = utilites.goToLinkWithinMail();
		Constant.WEBDRIVER.get(link.substring(0,link.indexOf("=")));
		}
	}
	
	public String getErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg).getText();
	}
	
	public void resetPassword(String email, String newPwd, String confirmPwd){
		goToResetPassword(email);
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();;
	}
	
	public void resetPasswordWithToken(String email, String newPwd, String confirmPwd, String resetToken){
		goToResetPassword(email);
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtResetToken), resetToken);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();;
	}
}
