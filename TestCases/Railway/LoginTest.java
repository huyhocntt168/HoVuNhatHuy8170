package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Constant.Messages;
import Constant.TabName;
import Common.Utilities;
import Constant.Constant;

public class LoginTest extends TestBase {

	LoginPage loginPage = new LoginPage();
	SoftAssert sa = new SoftAssert();

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.goToPage(TabName.login);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Messages.welcome;
		loginPage.logout();
		assertEquals(actualMsg, expectedMsg, String.format("%s must be displayed", Messages.welcome));
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		homePage.goToPage(TabName.login);
		loginPage.login("", Constant.PASSWORD);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginError;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginError));
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, "invalidPwd");
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginError;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginError));
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.goToPage(TabName.bookTicket);

		String actualContent = homePage.getPageContent();
		String expectedContent = "Login page";

		assertEquals(actualContent, expectedContent, "Login page is not displayed as expected");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.WRONG_PASSWORD, 4);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginWrongPwdSeveralTimes;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginWrongPwdSeveralTimes));
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		sa.assertTrue(utilities.isTabDisplay(TabName.myTicket), "My ticket tab is not displayed");
		sa.assertTrue(utilities.isTabDisplay(TabName.changePwd), "Change password tab is not displayed");
		sa.assertTrue(utilities.isTabDisplay(TabName.logout), "Log out tab is not displayed");

		loginPage.goToPage(TabName.myTicket);
		String actual = loginPage.getPageContent();
		String expected = "Manage ticket";
		sa.assertEquals(actual, expected, "My Ticket page is not displayed");

		loginPage.goToPage(TabName.changePwd);
		String actual1 = loginPage.getPageContent();
		String expected1 = "Change password";
		sa.assertEquals(actual1, expected1, "Change password page is not displayed");

		loginPage.logout();
		sa.assertAll();
	}
	
	@Test(description = "User can't login with an account hasn't been activated")
	public void TC07() {
		homePage.goToPage(TabName.login);
		loginPage.login(Constant.USERNAMENOTACTIVE, Constant.WRONG_PASSWORD);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginAccountNotActive;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginAccountNotActive));
	}

}
