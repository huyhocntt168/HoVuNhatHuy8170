package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ElementHelper {
	public void enterTextBox(WebElement txtBox, String value) {
		txtBox.clear();
		txtBox.sendKeys(value);
	}

	public boolean isTabDisplay(String tabName) {
		return !Constant.WEBDRIVER.findElements(By.xpath(String.format("//span[normalize-space()='%s']", tabName)))
				.isEmpty();
	}
	
//	public void waitElementDisplay(WebElement e) {
//	e = (new WebDriverWait(Constant.WEBDRIVER, 3)).until(ExpectedConditions.visibilityOf(e));
//}
}
