package Railway;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Common.Messages;
import Common.Utilities;
import Constant.Constant;

public class LoginTest {

	Utilities utilities = new Utilities();
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Pre-condition");
		utilities.openChrome();
		homePage.open();
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.clickTab("Login");
		loginPage.login(Constant.USERNAME, Constant.PASSWORD);
		String actualMsg = loginPage.getWelcomeMessage();
		String expectedMsg = Messages.welcomeMsg;
//		loginPage.logout();
		assertEquals(actualMsg, expectedMsg, String.format("%s must be displayed", Messages.welcomeMsg));		
		loginPage.logout();

	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		homePage.clickTab("Login");
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
		homePage.clickTab("Book ticket");

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
		utilities.isTabDisplay(loginPage.getTabButton("My ticket"));
		utilities.isTabDisplay(loginPage.getTabButton("Change password"));
		utilities.isTabDisplay(loginPage.getTabButton("Log out"));
		
		loginPage.clickTab("My ticket");
		String actual = loginPage.getPageContent();
		String expected = "Manage ticket";
		assertEquals(actual, expected, "My ticket page is not displayed");
		
		loginPage.clickTab("Change password");
		String actual1 = loginPage.getPageContent();
		String expected1 = "Change password";
		assertEquals(actual1, expected1, "Change password page is not displayed");
	}

	@Test(description = "User can create new account")
	public void TC07() {
		loginPage.logout();
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
