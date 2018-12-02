package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.TicketInfo;
import Constant.Constant;

public class MyTicketPage extends GeneralPage {
	
	public By getCancelButtonLocator(TicketInfo ticketInfo) {
		return By.xpath(String.format(
				"//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td//input[@value = 'Cancel']",
				ticketInfo.getDepartStation(), ticketInfo.getArriveStation(), ticketInfo.getSeatType(),
				ticketInfo.getDepartDate(), ticketInfo.getTicketAmount()));
	}

	public WebElement getCancelButton(TicketInfo ticketInfo) {
		return Constant.WEBDRIVER.findElement(getCancelButtonLocator(ticketInfo));
	}
	
	public void cancelTicket(TicketInfo ticketInfo) {
		getCancelButton(ticketInfo).click();
		Constant.WEBDRIVER.switchTo().alert().accept();
	}
	
}
