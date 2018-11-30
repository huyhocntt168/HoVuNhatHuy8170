package Railway;

import java.io.UnsupportedEncodingException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.ElementHelper;
import Common.TicketInfo;
import Constant.Constant;

public class BookTicketTest extends TestBase {
	HomePage homePage = new HomePage();
	ElementHelper elementHelper = new ElementHelper();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	SoftAssert softAssert = new SoftAssert();
	
	
	@Test(description = "User can book 1 ticket at a time")
	public void TC01() throws UnsupportedEncodingException {
		TicketInfo ticketInfo = new TicketInfo();
		homePage.goToPage(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.goToPage(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket(ticketInfo);
		softAssert.assertEquals(bookTicketPage.getPageContent(), "Ticket booked successfully!");
		softAssert.assertEquals(bookTicketPage.getTblDepartStation(), ticketInfo.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getTblArriveStation(), ticketInfo.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getTblSeatType(), ticketInfo.getSeatType());
		softAssert.assertEquals(bookTicketPage.getTblDepartDate(), ticketInfo.getDepartDate());
		softAssert.assertAll();
	}
}
