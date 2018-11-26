package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Constant.Constant;

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

//	public void waitElementDisplay(WebElement e) {
//		e = (new WebDriverWait(Constant.WEBDRIVER, 3)).until(ExpectedConditions.visibilityOf(e));
//	}

	public boolean isTabDisplay(String tabName) {
		return !Constant.WEBDRIVER.findElements(By.xpath(String.format("//span[normalize-space()='%s']", tabName)))
				.isEmpty();
	}

	public String validEmail() {
		String s = String.valueOf(System.currentTimeMillis());
		return String.format("huy%s@mailinator.com", s.substring(5, s.length()));
	}

}
