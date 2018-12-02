package Railway;

import org.openqa.selenium.By;

import Common.TicketInfo;
import Constant.Constant;

public class BookTicketPage extends GeneralPage {
	// Locators
	private By drdDepartDate = By.name("Date");
	private By drdDepartStation = By.name("DepartStation");
	private By drdArriveStation = By.name("ArriveStation");
	private By drdSeatType = By.name("SeatType");
	private By drdTicketAmount = By.name("TicketAmount");
	private By btnBookticket = By.xpath("//input[@value='Book ticket']");
	private By tblDepartStation = By.xpath("//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)]");
	private By tblArriveStation = By.xpath("//td[(count(//tr/th[.='Arrive Station']/preceding-sibling::th)+1)]");
	private By tblSeatType = By.xpath("//td[(count(//tr/th[.='Seat Type']/preceding-sibling::th)+1)]");
	private By tblDepartDate = By.xpath("//td[(count(//tr/th[.='Depart Date']/preceding-sibling::th)+1)]");
	private By selectedDepartSation = By.xpath("//select[@name='DepartStation']//option[@selected='selected']");
	private By selectedArriveStation = By.xpath("//select[@name='ArriveStation']//option[@selected='selected']");
	// Elements

	// Methods

	public void bookTicket(TicketInfo ticketInfo) {
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdDepartDate), ticketInfo.getDepartDate());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdDepartStation), ticketInfo.getDepartStation());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdArriveStation), ticketInfo.getArriveStation());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdSeatType), ticketInfo.getSeatType());
		elementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdTicketAmount), ticketInfo.getTicketAmount());
		Constant.WEBDRIVER.findElement(btnBookticket).click();
	}

	public String getTblDepartStation() {
		return Constant.WEBDRIVER.findElement(tblDepartStation).getText();
	}

	public String getTblArriveStation() {
		return Constant.WEBDRIVER.findElement(tblArriveStation).getText();
	}

	public String getTblSeatType() {
		return Constant.WEBDRIVER.findElement(tblSeatType).getText();
	}

	public String getTblDepartDate() {
		return Constant.WEBDRIVER.findElement(tblDepartDate).getText();
	}
	
	public String getDepartStation() {
		return Constant.WEBDRIVER.findElement(selectedDepartSation).getText();
	}
	
	public String getArriveStation() {
		return Constant.WEBDRIVER.findElement(selectedArriveStation).getText();
	}
}
