package Railway;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	Calendar calendar = Calendar.getInstance();
	SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
	int departDate = 15;
	
	@Test(description = "User can book 1 ticket at a time")
	public void TC01() {
		homePage.goToPage(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		homePage.goToPage(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket(Integer.toString(departDate), Constant.DepartStation.SAIGON, Constant.ArriveStation.NHATRANG, Constant.SeatType.SOFTBED_AIR, "1");
		softAssert.assertEquals(bookTicketPage.getPageContent(), "Ticket booked successfully!");
		softAssert.assertEquals(bookTicketPage.getTblDepartStation(), Constant.DepartStation.SAIGON.getDepartStation());
		softAssert.assertEquals(bookTicketPage.getTblArriveStation(), Constant.ArriveStation.NHATRANG.getArriveStation());
		softAssert.assertEquals(bookTicketPage.getTblSeatType(), Constant.SeatType.SOFTBED_AIR.getSeatType());
		calendar.add(calendar.DAY_OF_MONTH, departDate);
		softAssert.assertEquals(bookTicketPage.getTblDepartDate(), format.format(calendar.getTime()));
		softAssert.assertAll();
	}
}
