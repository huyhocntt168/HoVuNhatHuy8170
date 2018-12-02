package Railway;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.TicketInfo;
import Constant.Constant;

public class MyTicketTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();
	TicketInfo ticketInfo = new TicketInfo();
	MyTicketPage myTicketPage = new MyTicketPage();
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.openTab(Constant.TabName.LOGIN);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
	}
	
	@Test(description = "User can cancel a ticket")
	public void TC16(){
		SoftAssert softAssert = new SoftAssert();
		homePage.openTab(Constant.TabName.BOOKTICKET);
		bookTicketPage.bookTicket(ticketInfo);
		bookTicketPage.openTab(Constant.TabName.MYTICKET);
//		int i = Constant.WEBDRIVER.findElements(myTicketPage.getCancelButtonLocator(ticketInfo)).size();
		myTicketPage.cancelTicket(ticketInfo);
//		softAssert.assertEquals(Constant.WEBDRIVER.findElements(myTicketPage.getCancelButtonLocator(ticketInfo)).size(), i-1);
		softAssert.assertFalse(elementHelper.isElementDisplay(myTicketPage.getCancelButtonLocator(ticketInfo)), "Ticket is not removed");
		softAssert.assertAll();
	}
}
