package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage{
	
	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	
	public void resetPassword(String email) {
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
//		Constant.WEBDRIVER.navigate().to(Constant.EMAILRESETPWD);
	}
}
