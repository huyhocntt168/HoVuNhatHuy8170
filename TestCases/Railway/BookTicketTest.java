package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.ElementHelper;
import Constant.Constant;
import Constant.Messages;

public class BookTicketTest extends TestBase {
	HomePage homePage = new HomePage();
	ElementHelper elementHelper = new ElementHelper();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	SoftAssert softAssert = new SoftAssert();
	
	@Test(description = "User can book 1 ticket at a time")
	public void TC01() {
		homePage.goToPage(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.goToPage(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket("5", Constant.DepartStation.SAIGON, Constant.ArriveStation.NHATRANG, Constant.SeatType.SOFTBED_AIR, "1");
		softAssert.assertEquals(bookTicketPage.getPageContent(), "Ticket booked successfully!");
		softAssert.assertEquals(bookTicketPage.getTblDepartStation(), Constant.DepartStation.SAIGON.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getTblArriveStation(), Constant.ArriveStation.NHATRANG.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getTblSeatType(), Constant.SeatType.SOFTBED_AIR.getSeatType());
	}
}
