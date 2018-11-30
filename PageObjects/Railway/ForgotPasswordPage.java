package Railway;

import java.util.ArrayList;

import org.openqa.selenium.By;

import Common.Utilities;
import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage{
	
	Utilities utilites = new Utilities();
	
	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
//	private By resetMail = By.xpath("(//td[normalize-space()='Please reset your password'])[1]");
//	private By mailMsgIFrame = By.id("msg_body");
//	private By lnkResetPwd = By.xpath("//body[contains(text(),'to reset your password.')]/a");
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
//		Constant.WEBDRIVER.navigate().to(Constant.EMAILRESETPWD);
//		elementHelper.waitElementLocale(resetMail);
//		Constant.WEBDRIVER.findElement(resetMail).click();
//		elementHelper.waitElementLocale(mailMsgIFrame);
//		Constant.WEBDRIVER.switchTo().frame(Constant.WEBDRIVER.findElement(mailMsgIFrame));
//		elementHelper.waitElementLocale(lnkResetPwd);
//		Constant.WEBDRIVER.findElement(lnkResetPwd).click();
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
//		ArrayList<String> availableWindows = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
//		Constant.WEBDRIVER.switchTo().window(availableWindows.get(1));
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();;
	}
	
	public void resetPasswordWithToken(String email, String newPwd, String confirmPwd, String resetToken){
		goToResetPassword(email);
//		ArrayList<String> availableWindows = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
//		Constant.WEBDRIVER.switchTo().window(availableWindows.get(1));
		elementHelper.waitElementLocale(txtNewPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtNewPwd), newPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtConfirmNewPwd), confirmPwd);
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtResetToken), resetToken);
		Constant.WEBDRIVER.findElement(btnResetPwd).click();;
	}
}
