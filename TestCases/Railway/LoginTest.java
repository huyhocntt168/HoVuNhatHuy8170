package Railway;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Common.Messages;
import Common.TabName;
import Common.Utilities;
import Constant.Constant;

public class LoginTest {

	Utilities utilities = new Utilities();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	SoftAssert sa = new SoftAssert();

	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		utilities.openChrome();
		homePage.open();
	}

	@BeforeMethod
	public void beforeMethod() {
		loginPage.logout();
		homePage.clickTab(TabName.loginTab);
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Messages.welcomeMsg;
		assertEquals(actualMsg, expectedMsg, String.format("%s must be displayed", Messages.welcomeMsg));
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		loginPage.login("", Constant.PASSWORD);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginErrorMsg;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginErrorMsg));
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, "invalidPwd");
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginErrorMsg;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginErrorMsg));
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.clickTab(TabName.bookTicketTab);

		String actualContent = homePage.getPageContent();
		String expectedContent = "Login page";

		assertEquals(actualContent, expectedContent, "Login page is not displayed as expected");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.WRONG_PASSWORD, 4);
		String actualMsg = loginPage.getErrorMsg();
		String expectedMsg = Messages.loginWrongPwdSeveralTimesMsg;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.loginWrongPwdSeveralTimesMsg));
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		utilities.isTabDisplay(TabName.myTicketTab, "My ticket tab is not displayed");
		utilities.isTabDisplay(TabName.changePwdTab, "Change password tab is not displayed");
		utilities.isTabDisplay(TabName.logoutTab, "Log out tab is not displayed");

		loginPage.clickTab(TabName.myTicketTab);
		String actual = loginPage.getPageContent();
		String expected = "Manage ticket";
		assertEquals(actual, expected, "My Ticket page is not displayed");

		loginPage.clickTab(TabName.changePwdTab);
		String actual1 = loginPage.getPageContent();
		String expected1 = "Change password";
		assertEquals(actual1, expected1, "Change password page is not displayed"); 

	}

	@Test(description = "User can create new account")
	public void TC07() {
		loginPage.clickTab("Register");
		registerPage.registerAccount();
		String actualMsg = registerPage.getPageContent();
		String expectedMsg = Messages.registerSuccess;

		assertEquals(actualMsg, expectedMsg,
				String.format("Error message %s must be displayed", Messages.registerSuccess));
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}

}
