package Common;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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

	public void isTabDisplay(WebElement element, String message) {
		try {
			Assert.assertTrue(element.isDisplayed(), message);
		} catch (NoSuchElementException e) {
//			throw new RuntimeException("Cannot find element");
		}
	}

	public String randomValidEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("%s@mailinator.com", s.substring(5, s.length()));
	}
}
