package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class ElementHelper {
	public void enter(WebElement txtBox, String value) {
		txtBox.clear();
		txtBox.sendKeys(value);
	}

	public boolean isTabDisplay(Constant.TabName tabName) {
		return isElementDisplay(By.xpath(String.format("//span[normalize-space()='%s']", tabName.getName())));
	}

	public boolean isElementDisplay(By locator) {
		try {
			if (Constant.WEBDRIVER.findElement(locator).isDisplayed()) {
				return true;
			}
			return false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void selectItemByValue(WebElement drdElement, String value) {
		Select select = new Select(drdElement);
		select.selectByValue(value);
	}

	public void selectItemByText(WebElement drdElement, String value) {
		Select select = new Select(drdElement);
		select.selectByVisibleText(value);
	}

	public WebElement waitElementLocale(By locate) {
		return new WebDriverWait(Constant.WEBDRIVER, 20).until(ExpectedConditions.visibilityOfElementLocated(locate));
	}
}
