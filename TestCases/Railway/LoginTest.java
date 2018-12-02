package Railway;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Constant.Constant;
import Constant.Messages;

public class LoginTest extends TestBase {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.openTab(Constant.TabName.LOGIN);
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		SoftAssert softAssert = new SoftAssert();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		softAssert.assertEquals(loginPage.getWelcomeMessage(), String.format(Messages.WELCOME, Constant.USERNAME));
		loginPage.logout();
		softAssert.assertAll();
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		loginPage.login("", Constant.PASSWORD);
		assertEquals(loginPage.getErrorMsg(), Messages.ERROR_LOGIN_FORM);
	}

	@Test(description = "User cannot log into Railway with invalid password")
	public void TC03() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD_CHANGED);
		assertEquals(loginPage.getErrorMsg(), Messages.ERROR_LOGIN_FORM);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.openTab(Constant.TabName.BOOKTICKET);
		assertEquals(homePage.getPageHeader(), "Login page");
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		loginPage.login(Constant.USERNAME, Constant.PASSWORD_CHANGED, 4);
		assertEquals(loginPage.getErrorMsg(), Messages.ERROR_LOGIN_SEVERAL_TIMES);
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		SoftAssert softAssert = new SoftAssert();
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		softAssert.assertTrue(elementHelper.isTabDisplay(Constant.TabName.MYTICKET),"My Ticket tab is not displayed");
		softAssert.assertTrue(elementHelper.isTabDisplay(Constant.TabName.CHANGEPASSWORD),"Change Password tab is not displayed");
		softAssert.assertTrue(elementHelper.isTabDisplay(Constant.TabName.LOGOUT),"Logout tab is not displayed");

		loginPage.openTab(Constant.TabName.MYTICKET);
		softAssert.assertEquals(loginPage.getPageHeader(), "Manage ticket");

		loginPage.openTab(Constant.TabName.CHANGEPASSWORD);
		softAssert.assertEquals(loginPage.getPageHeader(), "Change password");

		loginPage.logout();
		softAssert.assertAll();
	}
	
	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		loginPage.login(Constant.USERNAME_INACTIVE, Constant.PASSWORD_INACTIVE);

		assertEquals(loginPage.getErrorMsg(), Messages.ERROR_LOGIN_INACTIVE_ACCOUNT);
	}

}
