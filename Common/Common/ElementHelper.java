package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Constant.Constant;

public class ElementHelper {
	public void enterTextBox(WebElement txtBox, String value) {
		txtBox.clear();
		txtBox.sendKeys(value);
	}

	public boolean isTabDisplay(Constant.TabName tabName) {
		return !Constant.WEBDRIVER.findElements(By.xpath(String.format("//span[normalize-space()='%s']", tabName.getName())))
				.isEmpty();
	}
	
	public boolean isElementDisplay(By locator) {
		return !Constant.WEBDRIVER.findElements(locator).isEmpty();
	}
	
	public void selectItemByValue(WebElement drdElement, String value) {
		Select select = new Select(drdElement);
		select.selectByValue(value);
	}
	
	public void selectItemByText(WebElement drdElement, String value) {
		Select select = new Select(drdElement);
		select.selectByVisibleText(value);
	}
//	public void waitElementDisplay(WebElement e) {
//	e = (new WebDriverWait(Constant.WEBDRIVER, 3)).until(ExpectedConditions.visibilityOf(e));
//}
}
