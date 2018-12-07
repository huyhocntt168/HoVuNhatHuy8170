package Railway;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.TicketInfo;
import Constant.Constant;

public class BookTicketTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();
	MyTicketPage myTicketpage = new MyTicketPage();
	TicketInfo ticketInfo = new TicketInfo();
	
	@Test(description = "User can book 1 ticket at a time")
	public void TC14() throws UnsupportedEncodingException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		homePage.openTab(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.openTab(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket(ticketInfo);
		softAssert.assertEquals(bookTicketPage.getPageHeader(), "Ticket booked successfully!");
		softAssert.assertEquals(bookTicketPage.getTblDepartStation(), ticketInfo.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getTblArriveStation(), ticketInfo.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getTblSeatType(), ticketInfo.getSeatType());
		softAssert.assertEquals(bookTicketPage.getTblDepartDate(), ticketInfo.getDepartDate());
		bookTicketPage.openTab(Constant.TabName.MYTICKET);
		myTicketpage.cancelTicket(ticketInfo);
		softAssert.assertAll();
	}
	
	@Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
	public void TC15(){
		SoftAssert softAssert = new SoftAssert();
		homePage.openTab(Constant.TabName.TIMETABLE);
		timeTablePage.openBookTicketPage("Huế", "Sài Gòn");
		softAssert.assertEquals(bookTicketPage.getPageHeader(), "Book ticket");
		softAssert.assertEquals(bookTicketPage.getDepartStation(), "Huế");
		softAssert.assertEquals(bookTicketPage.getArriveStation(), "Sài Gòn");
		softAssert.assertAll();
	}
}
