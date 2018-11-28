package Common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
//	public void WaitAndClick(WebElement element, int times) {
//		int i = 0;
//		while(i<times){
//			try {
//				element.click();
//				i=times;
//			}
//			catch (Exception e) {
//				i++;
//			}
//		}
//	}
	public WebElement waitElementLocale(By locate) {
		return new WebDriverWait(Constant.WEBDRIVER, 20).until(ExpectedConditions.visibilityOfElementLocated(locate));
	}
}
