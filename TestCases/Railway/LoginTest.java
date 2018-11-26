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
	SoftAssert softAssert = new SoftAssert();

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.goToPage(TabName.login);
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		softAssert.assertEquals(loginPage.getWelcomeMessage(), Messages.welcome);
		loginPage.logout();
		softAssert.assertAll();
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		homePage.goToPage(TabName.login);
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getErrorMsg(), Messages.loginError);
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, "invalidPwd");
		assertEquals(loginPage.getErrorMsg(), Messages.loginError);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.goToPage(TabName.bookTicket);
		assertEquals(homePage.getPageContent(), "Login page");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.WRONG_PASSWORD, 4);
		assertEquals(loginPage.getErrorMsg(), Messages.loginWrongPwdSeveralTimes);
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		softAssert.assertTrue(elementHelper.isTabDisplay(TabName.myTicket));
		softAssert.assertTrue(elementHelper.isTabDisplay(TabName.changePwd));
		softAssert.assertTrue(elementHelper.isTabDisplay(TabName.logout));

		loginPage.goToPage(TabName.myTicket);
		softAssert.assertEquals(loginPage.getPageContent(), "Manage ticket");

		loginPage.goToPage(TabName.changePwd);
		softAssert.assertEquals(loginPage.getPageContent(), "Change password");

		loginPage.logout();
		softAssert.assertAll();
	}
	
	@Test(description = "User can't login with an account hasn't been activated")
	public void TC07() {
		homePage.goToPage(TabName.login);
		loginPage.login(Constant.USERNAMENOTACTIVE, Constant.WRONG_PASSWORD);

		assertEquals(loginPage.getErrorMsg(), Messages.loginAccountNotActive);
	}

}
