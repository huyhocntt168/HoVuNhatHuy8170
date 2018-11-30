package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Common.TicketInfo;
import Constant.Constant;

public class BookTicketPage extends GeneralPage {
		//Locators
	private By drdDepartDate = By.name("Date");
	private By drdDepartStation = By.name("DepartStation");
	private By drdArriveStation = By.name("ArriveStation");
	private By drdSeatType = By.name("SeatType");
	private By drdTicketAmount = By.name("TicketAmount");
	private By btnBookticket = By.xpath("//input[@value='Book ticket']");
	private By tblDepartStation = By.xpath("//td[1]");
	private By tblArriveStation = By.xpath("//td[2]");
	private By tblSeatType = By.xpath("//td[3]");
	private By tblDepartDate = By.xpath("//td[4]");
		//Elements
	
		//Methods
	
	public void bookTicket(TicketInfo ticketInfo) {
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdDepartDate), ticketInfo.getDepartDate());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdDepartStation), ticketInfo.getDepartStation());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdArriveStation), ticketInfo.getArriveStation());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdSeatType), ticketInfo.getSeatType());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdTicketAmount), ticketInfo.getTicketAmount());
		Constant.WEBDRIVER.findElement(btnBookticket).click();
	}
	
	public String getTblDepartStation() {
		if(elementHelper.isElementDisplay(tblDepartStation))
		{
		return Constant.WEBDRIVER.findElement(tblDepartStation).getText();
		}
		return null;
	}
	public String getTblArriveStation() {
		if(elementHelper.isElementDisplay(tblArriveStation))
		{
		return Constant.WEBDRIVER.findElement(tblArriveStation).getText();
		}
		return null;
	}
	public String getTblSeatType() {
		if(elementHelper.isElementDisplay(tblSeatType))
		{
		return Constant.WEBDRIVER.findElement(tblSeatType).getText();
		}
		return null;
	}
	public String getTblDepartDate() {
		if(elementHelper.isElementDisplay(tblDepartDate))
		{
		return Constant.WEBDRIVER.findElement(tblDepartDate).getText();
		}
		return null;
	}
}
