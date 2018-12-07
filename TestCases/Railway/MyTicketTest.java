package Railway;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.ElementHelper;
import Common.TicketInfo;
import Constant.Constant;

public class MyTicketTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();
	TicketInfo ticketInfo = new TicketInfo();
	MyTicketPage myTicketPage = new MyTicketPage();

	@Test(description = "User can cancel a ticket", priority = 1)
	public void TC16() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		homePage.openTab(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.openTab(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket(ticketInfo);
		bookTicketPage.openTab(Constant.TabName.MYTICKET);
		myTicketPage.cancelTicket(ticketInfo);
		softAssert.assertFalse(ElementHelper.isElementDisplay(myTicketPage.getCancelButtonLocator(ticketInfo)),
				"Ticket is not removed");
		softAssert.assertAll();
	}

	@Test(description = "User can filter \"Manager ticket\" table with Depart Station", priority = 2)
	public void FTTC01() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		myTicketPage.openTab(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookMultipleTicket(7);
		bookTicketPage.openTab(Constant.TabName.MYTICKET);
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Sài Gòn"),
				"Filter for Sài Gòn is not correct");
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Phan Thiết"),
				"Filter for Phan Thiết is not correct");
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Nha Trang"),
				"Filter for Nha Trang is not correct");
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Đà Nẵng"),
				"Filter for Đà Nẵng is not correct");
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Huế"), "Filter for Huế is not correct");
		softAssert.assertTrue(myTicketPage.isFilterByDepartStationCorrect("Quảng Ngãi"),
				"Filter for Quảng Ngãi is not correct");
		myTicketPage.cancelAllTicket();
		softAssert.assertAll();
	}

	@Test(description = "Error displays when user applies filter with invalid format for \"Depart Date\" in \"Manage ticket\" table", priority = 3)
	public void FTTC02() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		myTicketPage.openTab(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookMultipleTicket(7);
		bookTicketPage.openTab(Constant.TabName.MYTICKET);
		softAssert.assertTrue(myTicketPage.isFilterByDepartDateCorrect(Constant.INVALID_DATE), "Filter for Sài Gòn is not correct");
		softAssert.assertEquals(
				Constant.WEBDRIVER.findElement(By.xpath("//div[@class='error message']")).getAttribute("textContent")
						.trim().replaceAll("\\s+", " "),
				"The date format is wrong, date filter is ignored. Example of a proper date: Today is 12/7/2018");
		myTicketPage.cancelAllTicket();
		softAssert.assertAll();
	}
}
