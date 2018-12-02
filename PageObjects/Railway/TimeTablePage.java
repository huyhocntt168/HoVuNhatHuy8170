package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class TimeTablePage extends GeneralPage {

	public WebElement getBookTicketButton(String departStation, String arriveStation) {
		return Constant.WEBDRIVER.findElement(By.xpath(
				String.format("//td[.='%s']/following-sibling::td[.='%s']/following-sibling::td//a[.='book ticket']",
						departStation, arriveStation)));
	}
	
	public void openBookTicketPage(String departStation, String arriveStation) {
		getBookTicketButton(departStation, arriveStation).click();
	}
}
