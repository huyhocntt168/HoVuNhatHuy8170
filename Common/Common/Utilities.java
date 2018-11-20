package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Constant.Constant;
import Railway.LoginPage;

public class Utilities {

	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public void enterTextBox(WebElement txtBox, String value) {
		txtBox.clear();
		txtBox.sendKeys(value);
	}

	public void waitElementDisplay(WebElement e) {
		e = (new WebDriverWait(Constant.WEBDRIVER, 3)).until(ExpectedConditions.visibilityOf(e));
	}

	public void isTabDisplay(WebElement e) {
		Assert.assertTrue(e.isDisplayed(), "Tab is not displayed");
	}
	
	public String randomValidEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("huyhocntt168+%s@gmail.com", s.substring(5, s.length()));
	}
}
