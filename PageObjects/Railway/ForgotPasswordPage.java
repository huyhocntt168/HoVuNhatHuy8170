package Railway;

import org.openqa.selenium.By;

import Constant.Constant;

public class ForgotPasswordPage extends GeneralPage{
	
	private By txtEmail = By.id("email");
	private By btnSendInstructions = By.xpath("//input[@value='Send Instructions']");
	
	public void resetPassword(String email){
		elementHelper.enterTextBox(Constant.WEBDRIVER.findElement(txtEmail), email);
		Constant.WEBDRIVER.findElement(btnSendInstructions).click();
		Constant.WEBDRIVER.navigate().to(Constant.EMAILRESETPWD);
		elementHelper.waitElementLocale(By.xpath("(//td[normalize-space()='Please reset your password'])[1]"));
		Constant.WEBDRIVER.findElement(By.xpath("(//td[normalize-space()='Please reset your password'])[1]")).click();
//		elementHelper.waitElementLocale(By.xpath("//iFrame[@id='msg_body']"));
		Constant.WEBDRIVER.switchTo().frame(Constant.WEBDRIVER.findElement(By.xpath("//iFrame[@id='msg_body']")));
		elementHelper.waitElementLocale(By.xpath("//body[contains(text(),'to reset your password.')]/a"));
		Constant.WEBDRIVER.findElement(By.xpath("//body[contains(text(),'to reset your password.')]/a")).click();
	}
}
