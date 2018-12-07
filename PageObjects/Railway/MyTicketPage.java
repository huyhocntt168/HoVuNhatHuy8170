package Railway;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementHelper;
import Common.TicketInfo;
import Common.Utilities;
import Constant.Constant;

public class MyTicketPage extends GeneralPage {

	private String departStation = "//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)][normalize-space()='%s']";
	private String departDate = "//td[(count(//tr/th[.='Depart Date']/preceding-sibling::th)+1)][normalize-space()='%s']";
	private By drdDepartStation = By.name("FilterDpStation");
	private By txtDepartDate = By.name("FilterDpDate");
	private By btnApplyFilter = By.xpath("//input[@value='Apply filter']");
	private By lblErrorMsg = By.xpath("//div[@class='error message']");

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

	public void cancelAllTicket() {
		filterByDepartStation("Ignore");
		boolean isCancelButtonDisplay = true;
		while (isCancelButtonDisplay) {
			Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Cancel']")).click();
			Constant.WEBDRIVER.switchTo().alert().accept();
			isCancelButtonDisplay = !Constant.WEBDRIVER.findElements(By.xpath("//input[@value='Cancel']")).isEmpty();
		}
	}

	public void filterByDepartStation(String deparStation) {
		ElementHelper.selectItemByText(Constant.WEBDRIVER.findElement(drdDepartStation), deparStation);
		Constant.WEBDRIVER.findElement(btnApplyFilter).click();
	}

	public void filterByDepartDate(String deparDate) {
		ElementHelper.enter(Constant.WEBDRIVER.findElement(txtDepartDate), deparDate);
		Constant.WEBDRIVER.findElement(btnApplyFilter).click();
	}

	public int countTicketsByDepartStation(String deparStationName) {
		return Constant.WEBDRIVER.findElements(By.xpath(String.format(departStation, deparStationName))).size();
	}

	public int countTicketsByDepartDate(String deparDate) {
		return Constant.WEBDRIVER.findElements(By.xpath(String.format(departDate, deparDate))).size();
	}
	
	public int countAllTickets() {
		return Constant.WEBDRIVER.findElements(By.xpath("//input[@value='Cancel']")).size();
	}

	public boolean isFilterByDepartStationCorrect(String deparStation) {
		filterByDepartStation("Ignore");
		int ticketBeforeFilterAmount = countTicketsByDepartStation(deparStation);
		filterByDepartStation(deparStation);
		int ticketAfterFilterAmount = countTicketsByDepartStation(deparStation);
		int totalTicketafterFilter = countAllTickets();
		if (ticketBeforeFilterAmount == 0) {
			return ElementHelper.isElementDisplay(lblErrorMsg);
		} else if (ticketBeforeFilterAmount == ticketAfterFilterAmount && ticketBeforeFilterAmount == totalTicketafterFilter) {
			return true;
		} else
			return false;
	}

	public boolean isFilterByDepartDateCorrect(String deparDate) {
		SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
		Calendar calendar = Calendar.getInstance();
		filterByDepartStation("Ignore");
		int beforeFilterAmount = countTicketsByDepartDate(deparDate);
		filterByDepartDate(deparDate);
		int afterFilterAmount = countTicketsByDepartDate(deparDate);
		if (!Utilities.isDateValid(deparDate)) {
			return (Constant.WEBDRIVER.findElement(By.xpath("//div[@class='error message']"))
					.getAttribute("textContent").trim().replaceAll("\\s+", " ")
					.equals("The date format is wrong, date filter is ignored. Example of a proper date: Today is "
							+ format.format(calendar.getTime())));
		} else if (beforeFilterAmount == 0) {
			return ElementHelper.isElementDisplay(lblErrorMsg);
		} else if (beforeFilterAmount == afterFilterAmount) {
			return true;
		} else
			return false;
	}
}
